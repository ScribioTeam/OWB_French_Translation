import argparse
import os


def get_args():
    parser = argparse.ArgumentParser(description='Copy English files into French files when needed')
    parser.add_argument('dir', type=str, help='Directory of the localisation')
    return parser.parse_args()


def copy_english_to_french(directory):
    for filename in os.listdir(directory):
        if filename.replace('english', 'french') not in os.listdir(directory):
            with open(os.path.join(directory, filename), 'r', encoding='utf8') as f:
                lines = f.readlines()
            lines[0] = 'l_french:\n'
            with open(os.path.join(directory, filename.replace('english', 'french')), 'w', encoding='utf8') as f:
                f.write(''.join(lines))
            print(f'{filename} copied into French')


if __name__ == '__main__':
    args = get_args()
    copy_english_to_french(args.dir)
