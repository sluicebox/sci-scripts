;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use Interface)
(use Print)
(use Dialog)
(use Language)
(use File)

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
	[local6 15]
	[local21 15]
	[local36 15]
	[local51 15]
	[local66 25]
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

(procedure (GetDirectory where &tmp temp0 [temp1 33] [temp34 100] temp134 [temp135 50])
	(repeat
		(= temp134 (gGame parseLang:))
		(gGame parseLang: 1)
		(= temp0
			(Print
				font: 0
				addText: 1 0 0 1 0 0 990 ; "New save-game directory:"
				addEdit: (StrCpy @temp1 where) 29 0 20 where
				addButton: 1 27 0 0 1 0 34 990 ; "OK"
				addButton: 0 38 0 0 1 50 34 990 ; "Cancel"
				init:
			)
		)
		(gGame parseLang: temp134)
		(if (not temp0)
			(return 0)
		)
		(if (not (StrLen @temp1))
			(GetCWD @temp1)
		)
		(if (ValidPath @temp1)
			(StrCpy where @temp1)
			(return 1)
		else
			(Message msgGET 990 29 0 0 1 @temp135) ; "%s is not a valid directory."
			(Format @temp34 @temp135 @temp1)
			(Print font: 0 addText: @temp34 init:)
		)
	)
)

(procedure (HaveSpace)
	(if (< local3 20)
		(CheckFreeSpace gCurSaveDir)
	)
)

(procedure (NeedDescription)
	(Print font: 0 addText: 3 0 0 1 0 0 990 init:) ; "You must type a description for the game."
)

(class SRDialog of Dialog
	(properties)

	(method (dispose &tmp [temp0 20])
		(RestoreSubLang)
		(gGame parseLang: local0)
		(if (== global250 -31970)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		else
			(gGame setCursor: global250)
		)
		(super dispose: &rest)
	)

	(method (init theComment names nums &tmp [temp0 250])
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
		(switch local5
			(0
				(Message msgGET 990 26 0 0 1 @local6) ; "Restore"
			)
			(1
				(Message msgGET 990 28 0 0 1 @local6) ; "Save"
			)
			(else
				(Message msgGET 990 25 0 0 1 @local6) ; "Replace"
			)
		)
		(= local2 (+ (selectorI nsRight:) 4))
		(okI
			text: @local6
			setSize:
			moveTo: local2 (selectorI nsTop:)
			state:
				(if (or (and (== local5 0) (not local3)) (== local5 3))
					0
				else
					3
				)
		)
		(Message msgGET 990 24 0 0 1 @local21) ; "Delete"
		(deleteI
			text: @local21
			setSize:
			moveTo: local2 (+ (okI nsBottom:) 4)
			state: (if (not local3) 0 else 3)
		)
		(Message msgGET 990 23 0 0 1 @local36) ; "Change Directory"
		(changeDirI
			text: @local36
			setSize:
			moveTo: local2 (+ (deleteI nsBottom:) 4)
			state: (& (changeDirI state:) $fff7)
		)
		(Message msgGET 990 22 0 0 1 @local51) ; "Cancel"
		(cancelI
			text: @local51
			setSize:
			moveTo: local2 (+ (changeDirI nsBottom:) 4)
			state: (& (cancelI state:) $fff7)
		)
		(self add: selectorI okI deleteI changeDirI cancelI setSize:)
		(switch local5
			(0
				(Message msgGET 990 10 0 0 1 @temp0) ; "Select the game that you would like to restore."
			)
			(1
				(Message msgGET 990 11 0 0 1 @temp0) ; "Type the description of this saved game."
			)
			(else
				(Message msgGET 990 30 0 0 1 @temp0) ; "This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk."
			)
		)
		(textI text: @temp0 setSize: (- (- nsRight nsLeft) 8) moveTo: 4 4)
		(= local2 (+ (textI nsBottom:) 4))
		(self eachElementDo: #move 0 local2)
		(self add: textI setSize: center: open: 4 -1)
		(return 1)
	)

	(method (doit theComment &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
		(if (and (== self Restore) argc theComment)
			(if
				(==
					(= temp0
						(FileIO fiOPEN (Format @temp385 {%ssg.dir} (gGame name:)))
					)
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
						(if local3 okI else changeDirI)
					)
					(1 editI)
					(2 okI)
					(else changeDirI)
				)
			)
			(= local2 (super doit: local1))
			(= temp2 (* (= local4 (selectorI indexOf: (selectorI cursor:))) 18))
			(if (== local2 changeDirI)
				(self dispose:)
				(gGame setCursor: 999)
				(if
					(and
						(GetDirectory gCurSaveDir)
						(==
							(= local3
								(GetSaveFiles (gGame name:) @temp3 @temp364)
							)
							-1
						)
					)
					(= temp1 -1)
					(break)
				)
				(self init: theComment @temp3 @temp364)
			else
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
							(not
								(= temp1 (StrCmp theComment @[temp3 (* local2 18)]))
							)
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
					((== local2 deleteI)
						(self dispose:)
						(gGame setCursor: 999)
						(if
							(not
								(Print
									addText: 12 0 0 1 0 0 990 ; "Are you sure you want to delete this saved game?"
									addButton: 0 31 0 0 1 0 35 990 ; "No"
									addButton: 1 32 0 0 1 50 35 990 ; "Yes"
									init:
								)
							)
							(self init: theComment @temp3 @temp364)
						else
							((= temp0 (File new:))
								name: (DeviceInfo 7 @temp385 (gGame name:)) ; MakeSaveDirName
								open: 2
							)
							(= temp1 2570)
							(for ((= local2 0)) (< local2 local3) ((++ local2))
								(if (!= local2 local4)
									(temp0 write: @[temp364 local2] 2)
									(temp0 writeString: @[temp3 (* local2 18)])
									(temp0 write: @temp1 1)
								)
							)
							(= temp1 -1)
							(temp0 write: @temp1 2 close: dispose:)
							(DeviceInfo
								8 ; MakeSaveFileName
								@temp385
								(gGame name:)
								[temp364 local4]
							)
							(FileIO fiUNLINK @temp385)
							(self init: theComment @temp3 @temp364)
						)
					)
					((== local2 okI)
						(= temp1 [temp364 local4])
						(break)
					)
					((or (== local2 -1) (== local2 cancelI))
						(= temp1 -1)
						(break)
					)
					((== local5 1)
						(editI
							cursor: (StrLen (StrCpy theComment @[temp3 temp2]))
							draw:
						)
					)
				)
			)
		)
		(DisposeScript 993)
		(self dispose:)
		(DisposeScript 990)
		(return temp1)
	)
)

(class Restore of SRDialog
	(properties)

	(method (init)
		(Message msgGET 990 20 0 0 1 @local66) ; "Restore a Game"
		(= text @local66)
		(super init: &rest)
	)
)

(class Save of SRDialog
	(properties)

	(method (init)
		(Message msgGET 990 21 0 0 1 @local66) ; "Save a Game"
		(= text @local66)
		(super init: &rest)
	)
)

(instance GetReplaceName of Dialog
	(properties)

	(method (doit theComment &tmp temp0 temp1 [temp2 15] [temp17 15] [temp32 15] [temp47 15])
		(= temp1 (gGame parseLang:))
		(gGame parseLang: 1)
		(= window gSystemWindow)
		(Message msgGET 990 33 0 0 1 @temp2) ; "Replace"
		(text1 text: @temp2 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName text: theComment font: gSmallFont setSize: moveTo: 4 nsBottom)
		(self add: oldName setSize:)
		(Message msgGET 990 34 0 0 1 @temp17) ; "with:"
		(text2 text: @temp17 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName text: theComment font: gSmallFont setSize: moveTo: 4 nsBottom)
		(self add: newName setSize:)
		(Message msgGET 990 33 0 0 1 @temp32) ; "Replace"
		(button1 text: @temp32 nsLeft: 0 nsTop: 0 setSize:)
		(Message msgGET 990 38 0 0 1 @temp47) ; "Cancel"
		(button2 text: @temp47 nsLeft: 0 nsTop: 0 setSize:)
		(button2 moveTo: (- nsRight (+ (button2 nsRight:) 4)) nsBottom)
		(button1
			moveTo: (- (button2 nsLeft:) (+ (button1 nsRight:) 4)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 -1)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen theComment))
			(NeedDescription)
			(= temp0 0)
		)
		(gGame parseLang: temp1)
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

	(method (dispose)
		(super dispose: 1)
	)
)

(instance cancelI of DButton
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance changeDirI of DButton
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance deleteI of DButton
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance textI of DText
	(properties
		font 0
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance text1 of DText
	(properties
		font 0
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance text2 of DText
	(properties
		font 0
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance oldName of DText
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance newName of DEdit
	(properties
		max 35
	)
)

(instance button1 of DButton
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance button2 of DButton
	(properties)

	(method (dispose)
		(super dispose: 1)
	)
)

