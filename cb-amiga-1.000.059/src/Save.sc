;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use Interface)
(use Window)

(public
	GetDirectory 0
)

(local
	default
	i
	numGames
	selected
	status
	[okIText 4] = [{Restore} {__Save__} {Replace} {Replace}]
	[textIText 4] = [{Select the game that you would like to restore.} {Type the description of this saved game.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.}]
)

(procedure (localproc_0)
	(return
		(cond
			((== self Restore) 0)
			((localproc_1) 1)
			(numGames 2)
			(else 3)
		)
	)
)

(procedure (GetDirectory where &tmp result [newDir 33] [str 40])
	(repeat
		(if
			(not
				(= result
					(Print ; "New save-game directory:"
						990
						1
						#font
						0
						#edit
						(StrCpy @newDir where)
						29
						#button
						{OK}
						1
						#button
						{Cancel}
						0
					)
				)
			)
			(return 0)
		)
		(if (not (StrLen @newDir))
			(GetCWD @newDir)
		)
		(if (ValidPath @newDir)
			(StrCpy where @newDir)
			(return 1)
		else
			(Print (Format @str 990 2 @newDir) #font 0) ; "%s is not a valid directory"
		)
	)
)

(procedure (localproc_1)
	(if (< numGames 20)
		(CheckFreeSpace gCurSaveDir)
	)
)

(procedure (localproc_2)
	(Print 990 3 #font 0) ; "You must type a description for the game."
)

(class SRDialog of Dialog
	(properties)

	(method (init theComment names nums)
		(= window SysWindow)
		(= nsBottom 0)
		(if (== (= numGames (GetSaveFiles (gGame name:) names nums)) -1)
			(return 0)
		)
		(if (== (= status (localproc_0)) 1)
			(editI
				text: (StrCpy theComment names)
				font: gSmallFont
				setSize:
				moveTo: 4 4
			)
			(self add: editI setSize:)
		)
		(selectorI
			text: names
			font: gSmallFont
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: 2
		)
		(= i (+ (selectorI nsRight:) 4))
		(okI
			text: [okIText status]
			setSize:
			moveTo: i (selectorI nsTop:)
			state: (if (== status 3) 0 else 3)
		)
		(cancelI
			setSize:
			moveTo: i (+ (okI nsBottom:) 4)
			state: (& (cancelI state:) $fff7)
		)
		(changeDirI
			setSize:
			moveTo: i (+ (cancelI nsBottom:) 4)
			state: (& (changeDirI state:) $fff7)
		)
		(self add: selectorI okI cancelI changeDirI setSize:)
		(textI
			text: [textIText status]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= i (+ (textI nsBottom:) 4))
		(self eachElementDo: #move 0 i)
		(self add: textI setSize: center: open: 4 15)
		(return 1)
	)

	(method (doit theComment &tmp fd ret offset names [nums 361] [str 21] [dir 40])
		(if (and (== self Restore) argc theComment)
			(if (== (= ret (FOpen (Format @dir 990 0 (gGame name:)))) -1) ; "%ssg.dir"
				(return)
			)
			(FClose ret)
		)
		(if (not (self init: theComment @nums @str))
			(return -1)
		)
		(repeat
			(= default
				(switch status
					(0
						(if numGames okI)
					)
					(1 editI)
					(2 okI)
					(else changeDirI)
				)
			)
			(= i (super doit: default))
			(= names (* (= selected (selectorI indexOf: (selectorI cursor:))) 18))
			(if (== i changeDirI)
				(if (GetDirectory gCurSaveDir)
					(if
						(==
							(= numGames
								(GetSaveFiles (gGame name:) @nums @str)
							)
							-1
						)
						(= offset -1)
						(break)
					)
					(= fd status)
					(switch (= status (localproc_0))
						(0)
						(fd
							(if (self contains: editI)
								(editI
									cursor: (StrLen (StrCpy theComment @nums))
									draw:
								)
							)
						)
						(else
							(self dispose: init: theComment @nums @str)
						)
					)
					(selectorI draw:)
				)
			else
				(if (and (== status 2) (== i okI))
					(if (GetReplaceName doit: (StrCpy theComment @[nums names]))
						(= offset [str selected])
						(break)
					)
					(continue)
				)
				(if (and (== status 1) (or (== i okI) (== i editI)))
					(if (== (StrLen theComment) 0)
						(localproc_2)
						(continue)
					)
					(= offset -1)
					(for ((= i 0)) (< i numGames) ((++ i))
						(breakif
							(not
								(= offset (StrCmp theComment @[nums (* i 18)]))
							)
						)
					)
					(= offset
						(cond
							((not offset) [str i])
							((== numGames 20) [str selected])
							(else numGames)
						)
					)
					(break)
				)
				(cond
					((== i okI)
						(= offset [str selected])
						(break)
					)
					((or (== i 0) (== i cancelI))
						(= offset -1)
						(break)
					)
					((== status 1)
						(editI
							cursor: (StrLen (StrCpy theComment @[nums names]))
							draw:
						)
					)
				)
			)
		)
		(self dispose:)
		(return offset)
	)
)

(class Restore of SRDialog
	(properties
		text {Restore a Game}
	)
)

(class Save of SRDialog
	(properties
		text {Save a Game}
	)
)

(instance GetReplaceName of Dialog
	(properties)

	(method (doit theComment &tmp temp0)
		(= window SysWindow)
		(text1 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName text: theComment font: gSmallFont setSize: moveTo: 4 nsBottom)
		(self add: oldName setSize:)
		(text2 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName text: theComment font: gSmallFont setSize: moveTo: 4 nsBottom)
		(self add: newName setSize:)
		(button1 nsLeft: 0 nsTop: 0 setSize:)
		(button2 nsLeft: 0 nsTop: 0 setSize:)
		(button2 moveTo: (- nsRight (+ (button2 nsRight:) 4)) nsBottom)
		(button1
			moveTo: (- (button2 nsLeft:) (+ (button1 nsRight:) 4)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 15)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen theComment))
			(localproc_2)
			(= temp0 0)
		)
		(return (or (== temp0 newName) (== temp0 button1)))
	)
)

(instance selectorI of DSelector
	(properties
		x 36
		y 8
	)
)

(instance editI of DEdit
	(properties
		max 35
	)
)

(instance okI of DButton
	(properties)
)

(instance cancelI of DButton
	(properties
		text { Cancel }
	)
)

(instance changeDirI of DButton
	(properties
		text {Change\0d\nDirectory}
	)
)

(instance textI of DText
	(properties
		font 0
	)
)

(instance text1 of DText
	(properties
		text {Replace}
		font 0
	)
)

(instance text2 of DText
	(properties
		text {with:}
		font 0
	)
)

(instance oldName of DText
	(properties)
)

(instance newName of DEdit
	(properties
		max 35
	)
)

(instance button1 of DButton
	(properties
		text {Replace}
	)
)

(instance button2 of DButton
	(properties
		text {Cancel}
	)
)

