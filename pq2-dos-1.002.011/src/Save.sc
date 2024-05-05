;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use Interface)
(use DSelector)

(public
	GetDirectory 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 4] = [{Restore} {__Save__} {Replace} {Replace}]
	[local10 4] = [{Select the game that you would like to restore.} {Type the description of this saved game.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.}]
)

(procedure (localproc_0)
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
	(if (< local2 20)
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
		(if (== (= local2 (GetSaveFiles (gGame name:) names nums)) -1)
			(return 0)
		)
		(if (== (= local4 (localproc_0)) 1)
			(editI
				text: (StrCpy theComment names)
				font: gSmallFont
				setSize:
				moveTo: 4 4
			)
			(self add: editI setSize:)
		)
		((= local5 (DSelector new:))
			x: 36
			y: 8
			text: names
			font: gSmallFont
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: 2
		)
		(= local1 (+ (local5 nsRight:) 4))
		(okI
			text: [local6 local4]
			setSize:
			moveTo: local1 (local5 nsTop:)
			state: (if (== local4 3) 0 else 3)
		)
		(cancelI
			setSize:
			moveTo: local1 (+ (okI nsBottom:) 4)
			state: (& (cancelI state:) $fff7)
		)
		(changeDirI
			setSize:
			moveTo: local1 (+ (cancelI nsBottom:) 4)
			state: (& (changeDirI state:) $fff7)
		)
		(self add: local5 okI cancelI changeDirI setSize:)
		(textI
			text: [local10 local4]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local1 (+ (textI nsBottom:) 4))
		(self eachElementDo: #move 0 local1)
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
			(DisposeScript 975)
			(return -1)
		)
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
			(= names (* (= local3 (local5 indexOf: (local5 cursor:))) 18))
			(if (== local1 changeDirI)
				(if (GetDirectory gCurSaveDir)
					(if
						(==
							(= local2
								(GetSaveFiles (gGame name:) @nums @str)
							)
							-1
						)
						(= offset -1)
						(break)
					)
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
					(local5 draw:)
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
						(localproc_2)
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
		(DisposeScript 975)
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

