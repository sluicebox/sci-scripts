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
	[local0 90]
	[local90 10]
	[local100 10]
	[local110 40]
	[local150 40]
	[local190 40]
	[local230 5]
	[local235 5]
	[local240 5]
	[local245 15]
	[local260 25]
	[local285 25]
	[local310 25]
	[local335 25]
	[local360 15]
	[local375 15]
	[local390 15]
	[local405 20]
	[local425 20]
	[local445 21]
	local466
	local467
	local468
	local469
	local470
	local471
)

(procedure (localproc_0)
	(return
		(cond
			((== self Restore) 0)
			((localproc_1) 1)
			(local469 2)
			(else 3)
		)
	)
)

(procedure (GetDirectory where &tmp result [newDir 33] [str 100] saveParseLang)
	(repeat
		(= saveParseLang (gGame parseLang:))
		(gGame parseLang: 1)
		(= result
			(Print
				@local260
				#font
				0
				#edit
				(StrCpy @newDir where)
				29
				#button
				@local240
				1
				#button
				@local245
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
			(Print (Format @str @local285 @newDir) #font 0)
		)
	)
)

(procedure (localproc_1)
	(if (< local469 20)
		(CheckFreeSpace gCurSaveDir)
	)
)

(procedure (localproc_2)
	(Print @local310 #font 0)
)

(procedure (localproc_3)
	(proc932_8 98 0 40 @local0)
	(proc932_8 98 0 41 @local90)
	(proc932_8 98 0 42 @local100)
	(proc932_8 98 0 43 @local110)
	(proc932_8 98 0 44 @local150)
	(proc932_8 98 0 45 @local190)
	(proc932_8 98 0 47 @local230)
	(proc932_8 98 0 46 @local235)
	(proc932_8 98 0 48 @local240)
	(proc932_8 98 0 49 @local245)
	(proc932_8 98 0 50 @local260)
	(proc932_8 98 0 51 @local285)
	(proc932_8 98 0 52 @local310)
	(proc932_8 98 0 53 @local335)
	(proc932_8 98 0 54 @local360)
	(proc932_8 98 0 55 @local375)
	(proc932_8 98 0 56 @local390)
	(proc932_8 98 0 57 @local405)
	(proc932_8 98 0 58 @local425)
	(proc932_8 98 0 59 @local445)
)

(class SRDialog of Dialog
	(properties)

	(method (dispose)
		(proc932_4)
		(gGame parseLang: local466)
		(super dispose: &rest)
	)

	(method (init theComment names nums)
		(proc932_3)
		(= local466 (gGame parseLang:))
		(gGame parseLang: 1)
		(= window gSystemWindow)
		(= nsBottom 0)
		(if (== (= local469 (GetSaveFiles (gGame name:) names nums)) -1)
			(return 0)
		)
		(if (== (= local471 (localproc_0)) 1)
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
		(= local468 (+ (selectorI nsRight:) 4))
		(okI
			text:
				(switch local471
					(0 @local90)
					(1 @local100)
					(2 @local375)
					(3 @local375)
				)
			setSize:
			moveTo: local468 (selectorI nsTop:)
			state:
				(if (or (and (== local471 0) (not local469)) (== local471 3))
					0
				else
					3
				)
		)
		(deleteI
			text: @local360
			setSize:
			moveTo: local468 (+ (okI nsBottom:) 4)
			state: (if (not local469) 0 else 3)
		)
		(changeDirI
			text: @local335
			setSize:
			moveTo: local468 (+ (deleteI nsBottom:) 4)
			state: (& (changeDirI state:) $fff7)
		)
		(cancelI
			text: @local245
			setSize:
			moveTo: local468 (+ (changeDirI nsBottom:) 4)
			state: (& (cancelI state:) $fff7)
		)
		(self add: selectorI okI deleteI changeDirI cancelI setSize:)
		(textI
			text:
				(switch local471
					(0 @local110)
					(1 @local150)
					(2 @local0)
					(3 @local0)
				)
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= local468 (+ (textI nsBottom:) 4))
		(self eachElementDo: #move 0 local468)
		(self add: textI setSize: center: open: 4 -1)
		(return 1)
	)

	(method (doit theComment &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
		(if (and (== self Restore) argc theComment)
			(if
				(==
					(= temp0
						(FileIO fiOPEN (Format @temp385 @local445 (gGame name:)))
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
			(= local467
				(switch local471
					(0
						(if local469 okI)
					)
					(1 editI)
					(2 okI)
					(else changeDirI)
				)
			)
			(= local468 (super doit: local467))
			(= temp2
				(* (= local470 (selectorI indexOf: (selectorI cursor:))) 18)
			)
			(if (== local468 changeDirI)
				(self dispose:)
				(if
					(and
						(GetDirectory gCurSaveDir)
						(==
							(= local469
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
				(if (and (== local471 2) (== local468 okI))
					(self dispose:)
					(if (GetReplaceName doit: (StrCpy theComment @[temp3 temp2]))
						(= temp1 [temp364 local470])
						(break)
					)
					(self init: theComment @temp3 @temp364)
					(continue)
				)
				(if
					(and
						(== local471 1)
						(or (== local468 okI) (== local468 editI))
					)
					(if (== (StrLen theComment) 0)
						(self dispose:)
						(localproc_2)
						(self init: theComment @temp3 @temp364)
						(continue)
					)
					(= temp1 -1)
					(for ((= local468 0)) (< local468 local469) ((++ local468))
						(breakif
							(not
								(= temp1
									(StrCmp theComment @[temp3 (* local468 18)])
								)
							)
						)
					)
					(if (not temp1)
						(= temp1 [temp364 local468])
						(break)
					)
					(if (== local469 20)
						(= temp1 [temp364 local470])
						(break)
					)
					(for ((= temp1 0)) 1 ((++ temp1))
						(for
							((= local468 0))
							(< local468 local469)
							((++ local468))
							
							(breakif (== temp1 [temp364 local468]))
						)
						(if (== local468 local469)
							(break)
						)
					)
					(break)
				)
				(cond
					((== local468 deleteI)
						(self dispose:)
						(if
							(not
								(PrintD
									@local190
									106
									81
									@local235
									0
									81
									@local230
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
							(for
								((= local468 0))
								(< local468 local469)
								((++ local468))
								
								(if (!= local468 local470)
									(temp0 write: @[temp364 local468] 2)
									(temp0 writeString: @[temp3 (* local468 18)])
									(temp0 write: @temp1 1)
								)
							)
							(= temp1 -1)
							(temp0 write: @temp1 2 close: dispose:)
							(DeviceInfo
								8 ; MakeSaveFileName
								@temp385
								(gGame name:)
								[temp364 local470]
							)
							(FileIO fiUNLINK @temp385)
							(self init: theComment @temp3 @temp364)
						)
					)
					((== local468 okI)
						(= temp1 [temp364 local470])
						(break)
					)
					((or (== local468 0) (== local468 cancelI))
						(= temp1 -1)
						(break)
					)
					((== local471 1)
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
	(properties)

	(method (doit)
		(localproc_3)
		(super doit: &rest)
	)

	(method (init)
		(= text @local405)
		(super init: &rest)
	)
)

(class Save of SRDialog
	(properties)

	(method (doit)
		(localproc_3)
		(super doit: &rest)
	)

	(method (init)
		(= text @local425)
		(super init: &rest)
	)
)

(instance GetReplaceName of Dialog
	(properties)

	(method (doit theComment &tmp ret saveParseLang)
		(= saveParseLang (gGame parseLang:))
		(gGame parseLang: 1)
		(= window gSystemWindow)
		(text1 text: @local375 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName text: theComment font: gSmallFont setSize: moveTo: 4 nsBottom)
		(self add: oldName setSize:)
		(text2 text: @local390 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName text: theComment font: gSmallFont setSize: moveTo: 4 nsBottom)
		(self add: newName setSize:)
		(button1 text: @local375 nsLeft: 0 nsTop: 0 setSize:)
		(button2 text: @local245 nsLeft: 0 nsTop: 0 setSize:)
		(button2 moveTo: (- nsRight (+ (button2 nsRight:) 4)) nsBottom)
		(button1
			moveTo: (- (button2 nsLeft:) (+ (button1 nsRight:) 4)) nsBottom
		)
		(self add: button1 button2 setSize: center: open: 0 -1)
		(= ret (super doit: newName))
		(self dispose:)
		(if (not (StrLen theComment))
			(localproc_2)
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
	(properties)
)

(instance changeDirI of DButton
	(properties)
)

(instance deleteI of DButton
	(properties)
)

(instance textI of DText
	(properties
		font 0
	)
)

(instance text1 of DText
	(properties
		font 0
	)
)

(instance text2 of DText
	(properties
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
	(properties)
)

(instance button2 of DButton
	(properties)
)

