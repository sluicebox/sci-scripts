;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use Interface)

(public
	GetDirectory 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 &tmp [temp0 41])
	(return
		(cond
			((== self Restore) 0)
			((localproc_1) 1)
			(local2 2)
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
						2
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
			(Print (Format @str 990 3 @newDir) #font 0) ; "%s is not a valid directory"
		)
	)
)

(procedure (localproc_1)
	(if (< local2 20)
		(CheckFreeSpace gCurSaveDir)
	)
)

(class SRDialog of Dialog
	(properties)

	(method (init theComment names nums)
		(= local2 (GetSaveFiles (gGame name:) names nums))
		(= local4 (localproc_0))
		(= nsBottom 0)
		(if (== local4 1)
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
		)
		(= local1 (+ (selectorI nsRight:) 4))
		(okI
			text:
				(switch local4
					(0 {Restore})
					(1 {  Save  })
					(else {Replace})
				)
			setSize:
			moveTo: local1 (selectorI nsTop:)
		)
		(okI state: (if (== local4 3) 0 else 3))
		(cancelI setSize: moveTo: local1 (+ (okI nsBottom:) 4))
		(changeDirI setSize: moveTo: local1 (+ (cancelI nsBottom:) 4))
		(self add: selectorI okI cancelI changeDirI setSize:)
		(textI
			text:
				(switch local4
					(0 {Select the game that you would like to restore.})
					(1 {Type the description of this saved game.})
					(else {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.})
				)
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local1 (+ (textI nsBottom:) 4))
		(if (== local4 1)
			(editI move: 0 local1)
		)
		(selectorI move: 0 local1)
		(okI move: 0 local1 state: (& (okI state:) $fff7))
		(changeDirI move: 0 local1 state: (& (changeDirI state:) $fff7))
		(cancelI move: 0 local1 state: (& (cancelI state:) $fff7))
		(self add: textI setSize: center: open: 4 15)
	)

	(method (doit theComment &tmp fd ret offset names [nums 361] [str 21] [dir 40])
		(if (and (== self Restore) argc theComment)
			(if (== (= ret (FOpen (Format @dir 990 0 (gGame name:)))) -1) ; "%ssg.dir"
				(return)
			)
			(FClose ret)
		)
		(self init: theComment @nums @str)
		(repeat
			(= local0
				(switch local4
					(0
						(if local2 okI)
					)
					(1 editI)
					(2 okI)
					(else changeDirI)
				)
			)
			(= local1 (super doit: local0))
			(= names (* (= local3 (selectorI indexOf: (selectorI cursor:))) 18))
			(if (== local1 changeDirI)
				(if (GetDirectory gCurSaveDir)
					(= local2 (GetSaveFiles (gGame name:) @nums @str))
					(= fd local4)
					(switch (= local4 (localproc_0))
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
				(if (and (== local4 2) (== local1 okI))
					(if (GetReplaceName doit: (StrCpy theComment @[nums names]))
						(= offset [str local3])
						(break)
					)
					(continue)
				)
				(if (and (== local4 1) (or (== local1 okI) (== local1 editI)))
					(if (== (StrLen theComment) 0)
						(Print 990 1 #font 0) ; "You must type a description for the game."
						(continue)
					)
					(= offset -1)
					(for ((= local1 0)) (< local1 local2) ((++ local1))
						(breakif
							(not
								(= offset (StrCmp theComment @[nums (* local1 18)]))
							)
						)
					)
					(= offset
						(cond
							((not offset) [str local1])
							((== local2 20) [str local3])
							(else local2)
						)
					)
					(break)
				)
				(cond
					((== local1 okI)
						(= offset [str local3])
						(break)
					)
					((or (== local1 0) (== local1 cancelI))
						(= offset -1)
						(break)
					)
					((== local4 1)
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
		text {Change\r\nDirectory}
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

