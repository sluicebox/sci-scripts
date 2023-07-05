;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 806)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Save)
(use System)

(public
	GetHeroFileName 0
)

(local
	[curDir 20]
)

(procedure (GetHeroFileName name)
	(getFileName doit: name)
	(DisposeScript 944)
	(DisposeScript 806)
)

(procedure (ChangeDir)
	(if (GetCurSaveDir)
		(gGame setCursor: gWaitCursor)
		(if (not (savedHeros init:))
			(return 0)
		)
		(self dispose:)
		(self init:)
		(savedHeros draw:)
	)
	(gGame setCursor: gNormalCursor)
	(return 1)
)

(procedure (MakeFileName name path root &tmp sep pathLen)
	(if (= pathLen (StrLen path))
		(= sep (StrAt path (- pathLen 1)))
		(Format
			name
			{%s%c%s}
			path
			(if (OneOf sep 92 58) 0 else 92)
			root
		)
	else
		(StrCpy name root)
	)
	(return name)
)

(procedure (ValidFileName name &tmp i len char) ; UNUSED
	(= i 0)
	(for ((= len 0)) (= char (StrAt name i)) ((++ len))
		(if (not (or (<= 48 char 57) (<= 65 char 90) (<= 97 char 122)))
			(Print 806 1) ; "Illegal character(s) in file name"
			(return 0)
		)
		(if (>= len 8)
			(Print 806 2) ; "Name must be 8 characters or less"
			(return 0)
		)
		(++ i)
	)
	(return 1)
)

(procedure (GetCurSaveDir &tmp result [newDir 20] [str 40])
	(repeat
		(if
			(not
				(= result
					(Print ; "New directory:"
						806
						3
						#edit
						(StrCpy @newDir @curDir)
						40
						#button
						{OK}
						1
						#button
						{Cancel}
						0
					)
				)
			)
			(break)
		)
		(if (not (StrLen @newDir))
			(GetCWD @newDir)
		)
		(if (ValidPath @newDir)
			(StrCpy @curDir @newDir)
			(break)
		else
			(Print (Format @str 806 4 @newDir)) ; "%s is not a valid directory"
		)
	)
	(return result)
)

(instance getFileName of Dialog
	(properties
		text {Import Character}
	)

	(method (init &tmp left)
		(= window SysWindow)
		(= nsBottom 0)
		(if (not (savedHeros init:))
			(return 0)
		)
		(savedHeros setSize: moveTo: 4 (+ nsBottom 4) state: 2)
		(= left (+ (savedHeros nsRight:) 4))
		(importItem
			setSize:
			moveTo: left (+ 10 (savedHeros nsTop:))
			state: (if (savedHeros nFiles:) 3 else 0)
		)
		(changeDirItem
			setSize:
			moveTo: left (+ (importItem nsBottom:) 4)
			state: (& (changeDirItem state:) $fff7)
		)
		(cancelItem
			setSize:
			moveTo: left (+ (changeDirItem nsBottom:) 4)
			state: (& (changeDirItem state:) $fff7)
		)
		(self
			add: savedHeros importItem changeDirItem cancelItem
			setSize:
			center:
			open: 4 15
		)
		(return 1)
	)

	(method (doit theName &tmp [str 100] choice ret)
		(= curDir 0)
		(if (not (self init:))
			(self dispose:)
			(return 0)
		)
		(repeat
			(cond
				(
					(==
						(= choice
							(super
								doit:
									(if (savedHeros nFiles:)
										importItem
									else
										changeDirItem
									)
							)
						)
						importItem
					)
					(MakeFileName theName @curDir (savedHeros cursor:))
					(= ret 1)
					(break)
				)
				((== choice changeDirItem)
					(if (not (= ret (ChangeDir)))
						(break)
					)
				)
				((or (== choice 0) (== choice cancelItem))
					(= ret 0)
					(break)
				)
			)
		)
		(self dispose:)
		(return ret)
	)

	(method (dispose)
		(savedHeros dispose:)
		(super dispose:)
	)
)

(instance savedHeros of FileSelector
	(properties
		y 16
	)

	(method (init &tmp sep rc i j cp char [savedHerosMask 80])
		(gGame setCursor: gWaitCursor)
		(= font gSmallFont)
		(= mask (MakeFileName @savedHerosMask @curDir {*.*}))
		(if (not (= rc (super init:)))
			(Print 806 0) ; "Too many files in this directory"
		else
			(= cp text)
			(= i 0)
			(while (< i nFiles)
				(for ((= j 0)) (= char (StrAt cp j)) ((++ j))
					(StrAt
						cp
						j
						(if (or (< char 65) (> char 90))
							char
						else
							(+ (- char 65) 97)
						)
					)
				)
				(++ i)
				(+= cp x)
			)
		)
		(gGame setCursor: gNormalCursor)
		(return rc)
	)
)

(instance cancelItem of DButton
	(properties
		text { Cancel }
	)
)

(instance changeDirItem of DButton
	(properties
		text {Change\r\nDirectory}
	)
)

(instance importItem of DButton
	(properties
		text { Import }
	)
)

