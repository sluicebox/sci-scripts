;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use Interface)
(use Language)

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
	[local6 4] = [{Play Saved Game} { Save Game } {Replace} {Replace}]
	local10
	local11 = {Start New Game}
	local12 = {Continue Playing}
	[local13 3] = [{Pick the game you want to play.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.}]
)

(procedure (GetStatus)
	(return
		(cond
			((== self Restore) 0)
			((HaveSpace) 1)
			(local3 2)
			(else 3)
		)
	)
)

(procedure (GetDirectory where &tmp result [newDir 33] [str 100] saveParseLang)
	(repeat
		(= saveParseLang (gGame parseLang:))
		(gGame parseLang: 1)
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
				{Play Saved Game}
				1
				#button
				local10
				0
			)
		)
		(gGame parseLang: saveParseLang)
		(if (not result)
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

(procedure (HaveSpace)
	(if (< local3 20)
		(CheckFreeSpace gCurSaveDir)
	)
)

(procedure (NeedDescription)
	(Print 990 3 #font 0) ; "You must type a description for the game."
)

(class SRDialog of Dialog
	(properties)

	(method (dispose)
		(RestoreSubLang)
		(gGame parseLang: local0)
		(super dispose: &rest)
	)

	(method (init theComment names nums)
		(= local10 (if (== gCurRoomNum 100) local11 else local12))
		(cancelI text: local10)
		(button2 text: local10)
		(SaveSubLang)
		(= local0 (gGame parseLang:))
		(gGame parseLang: 1)
		(= window gSystemWindow)
		(= nsBottom 0)
		(if (== (= local3 (GetSaveFiles (gGame name:) names nums)) -1)
			(return 0)
		)
		(if (== (= local5 (GetStatus)) 1)
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
		(= local2 (+ (selectorI nsRight:) 4))
		(okI
			text: [local6 local5]
			setSize:
			moveTo: local2 (selectorI nsTop:)
			state:
				(if (or (and (== local5 0) (not local3)) (== local5 3))
					0
				else
					3
				)
		)
		(cancelI
			setSize:
			moveTo: local2 (+ (okI nsBottom:) 4)
			state: (& (cancelI state:) $fff7)
		)
		(self add: selectorI okI cancelI setSize:)
		(textI
			text: [local13 local5]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local2 (+ (textI nsBottom:) 4))
		(self eachElementDo: #move 0 local2)
		(self add: textI setSize: center: open: 4 -1)
		(return 1)
	)

	(method (doit theComment &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
		(if (and (== self Restore) argc theComment)
			(if
				(==
					(= temp0 (FileIO fiOPEN (Format @temp385 990 0 (gGame name:)))) ; "%ssg.dir"
					-1
				)
				(return)
			)
			(FileIO fiCLOSE temp0)
		)
		(if (not (self init: theComment @temp3 @temp364))
			(return -1)
		)
		(repeat
			(= local1
				(switch local5
					(0
						(if local3 okI)
					)
					(1 editI)
					(2 okI)
				)
			)
			(= local2 (super doit: local1))
			(= temp2 (* (= local4 (selectorI indexOf: (selectorI cursor:))) 18))
			(if (and (== local5 2) (== local2 okI))
				(self dispose:)
				(if (GetReplaceName doit: (StrCpy theComment @[temp3 temp2]))
					(= temp1 [temp364 local4])
					(break)
				)
				(self init: theComment @temp3 @temp364)
				(continue)
			)
			(if (and (== local5 1) (or (== local2 okI) (== local2 editI)))
				(if (== (StrLen theComment) 0)
					(self dispose:)
					(NeedDescription)
					(self init: theComment @temp3 @temp364)
					(continue)
				)
				(= temp1 -1)
				(for ((= local2 0)) (< local2 local3) ((++ local2))
					(breakif
						(not (= temp1 (StrCmp theComment @[temp3 (* local2 18)])))
					)
				)
				(if (not temp1)
					(= temp1 [temp364 local2])
					(break)
				)
				(if (== local3 20)
					(= temp1 [temp364 local4])
					(break)
				)
				(for ((= temp1 0)) 1 ((++ temp1))
					(for ((= local2 0)) (< local2 local3) ((++ local2))
						(breakif (== temp1 [temp364 local2]))
					)
					(if (== local2 local3)
						(break)
					)
				)
				(break)
			)
			(cond
				((== local2 okI)
					(= temp1 [temp364 local4])
					(break)
				)
				((or (== local2 0) (== local2 cancelI))
					(= temp1 -1)
					(break)
				)
				((== local5 1)
					(editI cursor: (StrLen (StrCpy theComment @[temp3 temp2])) draw:)
				)
			)
		)
		(DisposeScript 993)
		(DisposeScript 940)
		(self dispose:)
		(DisposeScript 990)
		(return temp1)
	)
)

(class Restore of SRDialog
	(properties
		text {Play Saved Game}
	)
)

(class Save of SRDialog
	(properties
		text {Save a Game}
	)
)

(instance GetReplaceName of Dialog
	(properties)

	(method (doit theComment &tmp ret saveParseLang)
		(= saveParseLang (gGame parseLang:))
		(gGame parseLang: 1)
		(= window gSystemWindow)
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
		(self add: button1 button2 setSize: center: open: 0 -1)
		(= ret (super doit: newName))
		(self dispose:)
		(if (not (StrLen theComment))
			(NeedDescription)
			(= ret 0)
		)
		(gGame parseLang: saveParseLang)
		(return (or (== ret newName) (== ret button1)))
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
		text {Start New Game}
	)
)

(instance changeDirI of DButton ; UNUSED
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
		text {Start New Game}
	)
)

