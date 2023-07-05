;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use n940)
(use File)

(public
	GetDirectory 0
)

(local
	saveParse
	default
	i
	numGames
	selected
	theStatus
	[okIText 4] = [{ Restore } {  Save  } {Replace} {Replace}]
	[textIText 4] = [{Select the game that you would like to restore.} {Type the description of this saved game.} {This directory/disk can hold no more saved games. You must replace one of your saved games or useChange Directory to save on a different directory/disk.} {This directory/disk can hold no more saved games. You must replace one of your saved games or useChange Directory to save on a different directory/disk.}]
)

(procedure (GetStatus)
	(return
		(cond
			((== self Restore) 0)
			((HaveSpace) 1)
			(numGames 2)
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
				{OK}
				1
				#button
				{Cancel}
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
			(Print (Format @str 990 2 @newDir @newDir) #font 0) ; "%s is not a valid directory"
		)
	)
)

(procedure (HaveSpace)
	(if (< numGames 20)
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
		(gGame parseLang: saveParse)
		(super dispose: &rest)
	)

	(method (init theComment names nums)
		(SaveSubLang)
		(= saveParse (gGame parseLang:))
		(gGame parseLang: 1)
		(= window gSystemWindow)
		(= nsBottom 0)
		(if (== (= numGames (GetSaveFiles (gGame name:) names nums)) -1)
			(return 0)
		)
		(if (== (= theStatus (GetStatus)) 1)
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
			text: [okIText theStatus]
			setSize:
			moveTo: i (selectorI nsTop:)
			state:
				(if (or (and (== theStatus 0) (not numGames)) (== theStatus 3))
					0
				else
					3
				)
		)
		(deleteI
			setSize:
			moveTo: i (+ (okI nsBottom:) 4)
			state: (if (not numGames) 0 else 3)
		)
		(changeDirI
			setSize:
			moveTo: i (+ (deleteI nsBottom:) 4)
			state: (& (changeDirI state:) $fff7)
		)
		(cancelI
			setSize:
			moveTo: i (+ (changeDirI nsBottom:) 4)
			state: (& (cancelI state:) $fff7)
		)
		(self add: selectorI okI deleteI changeDirI cancelI setSize:)
		(textI
			text: [textIText theStatus]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= i (+ (textI nsBottom:) 4))
		(self eachElementDo: #move 0 i)
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
			(= default
				(switch theStatus
					(0
						(if numGames okI)
					)
					(1 editI)
					(2 okI)
					(else changeDirI)
				)
			)
			(= i (super doit: default))
			(= temp2 (* (= selected (selectorI indexOf: (selectorI cursor:))) 18))
			(if (== i changeDirI)
				(self dispose:)
				(if
					(and
						(GetDirectory gCurSaveDir)
						(==
							(= numGames
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
				(if (and (== theStatus 2) (== i okI))
					(self dispose:)
					(if (GetReplaceName doit: (StrCpy theComment @[temp3 temp2]))
						(= temp1 [temp364 selected])
						(break)
					)
					(self init: theComment @temp3 @temp364)
					(continue)
				)
				(if (and (== theStatus 1) (or (== i okI) (== i editI)))
					(if (== (StrLen theComment) 0)
						(self dispose:)
						(NeedDescription)
						(self init: theComment @temp3 @temp364)
						(continue)
					)
					(= temp1 -1)
					(for ((= i 0)) (< i numGames) ((++ i))
						(breakif
							(not
								(= temp1 (StrCmp theComment @[temp3 (* i 18)]))
							)
						)
					)
					(if (not temp1)
						(= temp1 [temp364 i])
						(break)
					)
					(if (== numGames 20)
						(= temp1 [temp364 selected])
						(break)
					)
					(for ((= temp1 0)) 1 ((++ temp1))
						(for ((= i 0)) (< i numGames) ((++ i))
							(breakif (== temp1 [temp364 i]))
						)
						(if (== i numGames)
							(break)
						)
					)
					(break)
				)
				(cond
					((== i deleteI)
						(self dispose:)
						(if
							(not
								(PrintD
									{Are you sure you want to\r\ndelete this saved game?}
									106
									81
									{ No }
									0
									81
									{Yes}
									1
								)
							)
							(self init: theComment @temp3 @temp364)
						else
							((= temp0 (File new:))
								name: (DeviceInfo 7 @temp385 (gGame name:)) ; MakeSaveDirName
								open: 2
							)
							(= temp1 2570)
							(for ((= i 0)) (< i numGames) ((++ i))
								(if (!= i selected)
									(temp0 write: @[temp364 i] 2)
									(temp0 writeString: @[temp3 (* i 18)])
									(temp0 write: @temp1 1)
								)
							)
							(= temp1 -1)
							(temp0 write: @temp1 2 close: dispose:)
							(DeviceInfo
								8 ; MakeSaveFileName
								@temp385
								(gGame name:)
								[temp364 selected]
							)
							(FileIO fiUNLINK @temp385)
							(self init: theComment @temp3 @temp364)
						)
					)
					((== i okI)
						(= temp1 [temp364 selected])
						(break)
					)
					((or (== i 0) (== i cancelI))
						(= temp1 -1)
						(break)
					)
					((== theStatus 1)
						(editI
							cursor: (StrLen (StrCpy theComment @[temp3 temp2]))
							draw:
						)
					)
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
		text {  Cancel  }
	)
)

(instance changeDirI of DButton
	(properties
		text {Change\r\nDirectory}
	)
)

(instance deleteI of DButton
	(properties
		text {  Delete  }
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

