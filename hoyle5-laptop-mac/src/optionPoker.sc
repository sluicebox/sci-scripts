;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1190)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Str)
(use Array)
(use Print)
(use GameControls)
(use Save)
(use File)
(use System)

(public
	optionPoker 0
)

(local
	local0
	[local1 2]
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
)

(procedure (localproc_0)
	(= local0 gGameControls)
	((= gGameControls pokerOptions)
		plane: pokerWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconAnte theObj: iconAnte selector: #doit yourself:)
			(iconLoad theObj: iconLoad selector: #doit yourself:)
			(iconSave theObj: iconSave selector: #doit yourself:)
			(icon1stBetLimit theObj: icon1stBetLimit selector: #doit yourself:)
			(icon2ndBetLimit theObj: icon2ndBetLimit selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls init:)
	(gGameControls show:)
	(DisposeScript 1190)
)

(procedure (localproc_1 param1)
	(if (== param1 1)
		(= local18 global883)
		(= local19 global884)
		(= local20 global879)
		(= local21 (gChar1 view:))
		(= local22 (gChar2 view:))
		(= local23 (gChar3 view:))
		(= local24 ((global117 at: 0) total:))
		(= local25 ((global117 at: 1) total:))
		(= local26 ((global117 at: 2) total:))
		(= local27 ((global117 at: 3) total:))
		(= local28 gAttitudeSetting)
		(= local29 gSkill)
		(= local30 global197)
		(= local31 global198)
	else
		(= global883 local18)
		(= global884 local19)
		(= global879 local20)
		(gChar1 view: local21)
		(gChar2 view: local22)
		(gChar3 view: local23)
		((global117 at: 0) total: local24)
		((global117 at: 1) total: local25)
		((global117 at: 2) total: local26)
		((global117 at: 3) total: local27)
		(= gAttitudeSetting local28)
		(= gSkill local29)
		(= global197 local30)
		(= global198 local31)
	)
)

(instance optionPoker of Code
	(properties)

	(method (init)
		(Load rsVIEW 1190)
		(localproc_0)
	)
)

(instance pokersg_025 of File
	(properties
		name {pokersg.025}
	)

	(method (doit param1 param2 param3 &tmp temp0 temp1 temp2 temp3 [temp4 2])
		(= temp3 (Str format: {pokersg.%03d} param2))
		(self name: (temp3 data:))
		(cond
			((and argc (== param1 3))
				(Save 0 {poker} param2 (param3 data:) {1.0}) ; SaveGame
				(if (self open: 2)
					(= temp0 (Str new:))
					(= temp2
						(-
							(+
								((global117 at: 0) total:)
								((global117 at: 1) total:)
								((global117 at: 2) total:)
								((global117 at: 3) total:)
								global198
							)
							((global117 at: 0) total:)
						)
					)
					(self
						writeString:
							(temp0
								format:
									{%4d%d%d%2d%4d%4d%4d%4d%4d%4d%4d%2d%4d%4d%4d%d}
									temp2
									global883
									global884
									global879
									(gChar1 view:)
									(gChar2 view:)
									(gChar3 view:)
									((global117 at: 0) total:)
									((global117 at: 1) total:)
									((global117 at: 2) total:)
									((global117 at: 3) total:)
									gAttitudeSetting
									gSkill
									global197
									global198
									global916
							)
						close:
					)
					(temp0 dispose:)
					(return 1)
				else
					(return 0)
				)
			)
			((self open: 1)
				(= temp1 (Str new:))
				(localproc_1 1)
				(self readString: temp1 5)
				(= temp2 (temp1 asInteger:))
				(self readString: temp1 2)
				(= local6 (temp1 asInteger:))
				(self readString: temp1 2)
				(= local7 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local8 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local9 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local10 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local11 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local12 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local13 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local14 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local15 (temp1 asInteger:))
				(self readString: temp1 3)
				(= local16 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local3 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local4 (temp1 asInteger:))
				(self readString: temp1 5)
				(= local5 (temp1 asInteger:))
				(self readString: temp1 2)
				(= local17 (temp1 asInteger:))
				(temp1 dispose:)
				(self close:)
				(if
					(==
						temp2
						(- (+ local12 local13 local14 local15 local5) local12)
					)
					(= global911 local12)
					(= global912 local13)
					(= global913 local14)
					(= global914 local15)
					(= global883 local6)
					(= global884 local7)
					(= global879 local8)
					(= global463 local9)
					(= global464 local10)
					(= global465 local11)
					((global117 at: 0) total: local12)
					((global117 at: 1) total: local13)
					((global117 at: 2) total: local14)
					((global117 at: 3) total: local15)
					(= gAttitudeSetting local16)
					(= global916 local17)
					(return 1)
				else
					(Print
						back: -1
						fore: 0
						addBitmap: 917 5 0
						margin: 10
						mode: 1
						addText: {corrupt game file.} 70 6
						init:
					)
					(localproc_1 0)
					(return 0)
				)
			)
			(else
				(cond
					((== param2 -1)
						(Print
							back: -1
							fore: 0
							addBitmap: 917 5 0
							margin: 10
							mode: 1
							addText: {Invalid file name.} 70 6
							init:
						)
					)
					((== param2 -2)
						(DisposeScript 64990)
						(Print
							back: -1
							fore: 0
							addBitmap: 917 5 0
							margin: 10
							mode: 1
							addText: {No games to restore.} 70 6
							init:
						)
					)
				)
				(return 0)
			)
		)
		(return (temp3 dispose:))
	)
)

(instance pokerWindow of InvisibleWindow
	(properties
		left 134
		top 101
		right 504
		bottom 418
	)

	(method (init &tmp temp0)
		(= priority 15)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 1190 0 1 0 0 0 self)
	)
)

(instance pokerOptions of HoyleGameControls
	(properties)
)

(instance iconSave of ControlIcon
	(properties
		noun 4
		modNum 1190
		nsLeft 191
		nsTop 63
		x 191
		y 63
		signal 387
		mainView 1190
		mainLoop 3
		maskView 1190
		maskLoop 1
		maskCel 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (== global889 0)
			(= temp0 (Str newWith: 36 {default saved game}))
			(if (!= (= temp2 (Save doit: temp0 1100)) -1)
				(pokersg_025 doit: 3 temp2 temp0)
			)
			(temp0 dispose:)
		else
			(Print
				back: -1
				fore: 0
				addBitmap: 917 5 0
				margin: 10
				mode: 1
				addText: {Can't save until end of hand.} 30 6
				init:
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconLoad of ControlIcon
	(properties
		noun 6
		modNum 1190
		nsLeft 19
		nsTop 63
		x 19
		y 63
		signal 387
		mainView 1190
		mainLoop 2
		maskView 1190
		maskLoop 2
		maskCel 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= temp0 (Str newWith: 36 {default saved game}))
		(= temp2 (IntArray new: 25))
		(if (== (= temp3 (Restore doit: temp0 1100)) -1)
			(= temp1 0)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
		(if (and (!= temp1 0) (pokersg_025 doit: 2 temp3 temp0))
			(= gNewRoomNum gCurRoomNum)
			(= gCurRoomNum 0)
			(gCurRoom style: 256)
			(proc0_8 0)
			(= global199 1)
			(proc0_9 (gCast elements:) 0)
			(gChar1 setChar: 1 global463 1100)
			(gChar2 setChar: 2 global464 1100)
			(gChar3 setChar: 3 global465 1100)
			(= gSkill local3)
			(= global197 local4)
			(= global198 local5)
			(gPoker_opt doit: 3)
			(gGameControls hide:)
			(= gGameControls local0)
			(PlaySong play: 0)
		)
		(temp0 dispose:)
		(temp2 dispose:)
	)
)

(instance icon1stBetLimit of ControlIcon
	(properties
		noun 5
		modNum 1190
		nsLeft 19
		nsTop 106
		x 19
		y 106
		signal 387
		mainView 1190
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(switch global883
			(0
				(= mainCel 0)
				(= [global891 0] 15)
				(= [global894 0] 5)
			)
			(1
				(= mainCel 2)
				(= [global891 0] 25)
				(= [global894 0] 5)
			)
			(2
				(= mainCel 4)
				(= [global891 0] 50)
				(= [global894 0] 25)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global883
			(0
				(= global883 1)
				(= mainCel 2)
				(= [global891 0] 25)
				(= [global894 0] 5)
			)
			(1
				(= global883 2)
				(= mainCel 4)
				(= [global891 0] 50)
				(= [global894 0] 25)
			)
			(2
				(= global883 0)
				(= mainCel 0)
				(= [global891 0] 15)
				(= [global894 0] 5)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance icon2ndBetLimit of ControlIcon
	(properties
		noun 7
		modNum 1190
		nsLeft 19
		nsTop 149
		x 19
		y 149
		signal 387
		mainView 1190
		mainLoop 5
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(switch global884
			(0
				(= mainCel 0)
				(= [global891 1] 25)
				(= [global894 1] 5)
			)
			(1
				(= mainCel 2)
				(= [global891 1] 50)
				(= [global894 1] 5)
			)
			(2
				(= mainCel 4)
				(= [global891 1] 100)
				(= [global894 1] 25)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global884
			(0
				(= global884 1)
				(= mainCel 2)
				(= [global891 1] 50)
				(= [global894 1] 5)
			)
			(1
				(= global884 2)
				(= mainCel 4)
				(= [global891 1] 100)
				(= [global894 1] 25)
			)
			(2
				(= global884 0)
				(= mainCel 0)
				(= [global891 1] 25)
				(= [global894 1] 5)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconAnte of ControlIcon
	(properties
		noun 1
		modNum 1190
		nsLeft 19
		nsTop 20
		x 19
		y 20
		signal 387
		mainView 1190
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainCel
			(switch global879
				(5 0)
				(25 2)
				(50 4)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch global879
			(5
				(= global879 25)
				(= mainCel 2)
			)
			(25
				(= global879 50)
				(= mainCel 4)
			)
			(50
				(= global879 5)
				(= mainCel 0)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 2
		modNum 1190
		nsLeft 19
		nsTop 193
		x 19
		y 193
		signal 387
		mainView 1190
		mainLoop 6
		maskView 1190
		maskLoop 6
		maskCel 1
		cursorView 995
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 3
		modNum 1190
		nsLeft 191
		nsTop 193
		x 191
		y 193
		signal 387
		mainView 1190
		mainLoop 6
		mainCel 2
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(= gGameControls local0)
		(gPoker_opt doit: 3)
	)
)

