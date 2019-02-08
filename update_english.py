import os
import argparse
import shutil


def get_args():
    parser = argparse.ArgumentParser(description='Update English files')
    parser.add_argument('steam', type=str, help='Steam mod directory')
    parser.add_argument('mod', type=str, help='Local mod directory')
    return parser.parse_args()


def main(args):
    # TODO unzip steam archive

    unzip_mod_dir = os.path.join('1.2.2')

    # Remove old English files
    i = 0
    for file in os.listdir(os.path.join(args.mod, 'localisation')):
        if file.endswith('l_english.yml'):
            i += 1
            os.remove(os.path.join(args.mod, 'localisation', file))
    if os.path.exists(os.path.join(args.mod, 'localisation', 'replace')):
        for file in os.listdir(os.path.join(args.mod, 'localisation', 'replace')):
            if file.endswith('l_english.yml'):
                i += 1
                os.remove(os.path.join(args.mod, 'localisation', 'replace', file))
    print('{0} old files removed'.format(i))

    # Copy new English files
    i = 0
    for file in os.listdir(os.path.join(unzip_mod_dir, 'localisation')):
        if file.endswith('l_english.yml'):
            i += 1
            shutil.copyfile(os.path.join(unzip_mod_dir, 'localisation', file),
                            os.path.join(args.mod, 'localisation', file))
    if os.path.exists(os.path.join(unzip_mod_dir, 'localisation', 'replace')):
        for file in os.listdir(os.path.join(unzip_mod_dir, 'localisation', 'replace')):
            if file.endswith('l_english.yml'):
                i += 1
                shutil.copyfile(os.path.join(unzip_mod_dir, 'localisation', 'replace', file),
                                os.path.join(args.mod, 'localisation', 'replace', file))
    print('{0} new files copied'.format(i))

if __name__ == "__main__":
    # execute only if run as a script
    args = get_args()
    main(args)