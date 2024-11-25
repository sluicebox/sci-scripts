;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use n011)
(use Str)
(use Print)
(use PanelPlane)
(use System)

(public
	moviePlane 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2)
	(if (ResCheck 151 param1) ; VMD
		(= temp1 (Str newWith: 10 {}))
		(temp1 format: {%d.VMD} param1)
		(gTopMessage toggleText: param1)
		(PlayVMD 0 (temp1 data:)) ; Open
		(PlayVMD 23 16 256) ; RestrictPalette
		(if (IsFlag 34)
			(PlayVMD 1 165 98 128 25 16 256) ; Put
		else
			(PlayVMD 1 12 15 149 25 16 256) ; Put
		)
		(PlayVMD 21 12 15 627 349) ; Black
		(PlayVMD 14 32 10) ; WaitEvent
		(PlayVMD 14 7) ; WaitEvent
		(gTopMessage toggleText:)
		(PlayVMD 6) ; Close
		(temp1 dispose:)
	else
		(Printf {*** %d.vmd Not Found! ***} param1)
	)
	(while ((= temp2 (Event new: evMOUSE)) type:)
		(temp2 dispose:)
	)
	(temp2 dispose:)
)

(class movieCast of Set
	(properties)
)

(instance moviePlane of PanelPlane
	(properties)

	(method (init)
		(proc11_12)
		(gSounds eachElementDo: #pause 1)
		((gUser hotCursor:) showWait:)
		(= picture (+ 120 gChapter))
		(= global135 0)
		(= local1 gChapter)
		(= local2 (gUser curVerb:))
		(gUser curVerb: 62)
		((gUser hotCursor:) show: update:)
		(= local0 ((gUser hotCursor:) hotObjList:))
		((gUser hotCursor:) hotObjList: (List new:))
		(movieCast add: pPrologue)
		(movieCast add: pCh1Open)
		(if (>= gChapter 2)
			(movieCast add: pCh1Close)
		)
		(if (>= gChapter 2)
			(movieCast add: pCh2Open)
		)
		(if (>= gChapter 3)
			(movieCast add: pCh2Close)
		)
		(if (>= gChapter 3)
			(movieCast add: pCh3Open)
		)
		(if (or (IsFlag 973) (>= gChapter 4))
			(movieCast add: pCh3Crime)
		)
		(if (>= gChapter 4)
			(movieCast add: pCh3Close)
		)
		(if (>= gChapter 4)
			(movieCast add: pCh4Open)
		)
		(if (>= gChapter 5)
			(movieCast add: pCh4Close)
		)
		(if (>= gChapter 5)
			(movieCast add: pCh5Open)
		)
		(if (or (IsFlag 1098) (>= gChapter 6))
			(movieCast add: pCh5Mid)
		)
		(if (>= gChapter 6)
			(movieCast add: pCh5Close)
		)
		(if (>= gChapter 6)
			(movieCast add: pCh6Open)
		)
		(if (IsFlag 815)
			(movieCast add: pCh6Opera)
		)
		(super init: &rest)
		(movieCast eachElementDo: #init self 1 1)
		(exitButton init: self 1 1)
		(= priority (+ (GetHighPlanePri) 1))
		((gUser hotCursor:) update: isHot: 0)
		(UpdatePlane self)
		(proc11_13)
	)

	(method (handleEvent event)
		(super handleEvent: event &rest)
		(if (event type:)
			(event claimed: 1)
		)
		(event claimed:)
	)

	(method (dispose)
		(gUser curVerb: local2)
		(((gUser hotCursor:) hotObjList:) release: dispose:)
		((gUser hotCursor:) hotObjList: local0)
		((gUser hotCursor:) isHot: 1 update:)
		(= global135 1)
		(super dispose: &rest)
		(gSounds eachElementDo: #pause 0)
		(if global249
			(Palette 1 global249) ; PalLoad
		)
		(proc11_13)
	)
)

(instance exitButton of PanelButton
	(properties
		x 8
		y 440
		view 140
		loop 11
		highlit 1
	)

	(method (doVerb)
		(proc11_12)
		(plane drawPic: -1)
		(movieCast eachElementDo: #dispose)
		(movieCast dispose:)
		(gGame getDisc: local1)
		(moviePlane dispose:)
	)
)

(class MovieButton of PanelButton
	(properties
		x 197
		view 127
		highlit 1
		cycleSpeed 15
		movieNum 0
		discNum 0
	)

	(method (doVerb)
		(proc11_12)
		(movieCast eachElementDo: #hide)
		(exitButton hide:)
		(plane drawPic: -1)
		(FrameOut)
		(Palette 2 0 255 100) ; PalIntensity
		(gGame getDisc: discNum)
		(localproc_0 movieNum)
		(if (== movieNum 5450)
			(PlayVMDFile 5440)
		)
		(Palette 2 0 255 0) ; PalIntensity
		(movieCast eachElementDo: #show)
		(exitButton show:)
		(plane drawPic: (+ 120 gChapter))
		(proc11_13)
	)
)

(instance pPrologue of MovieButton
	(properties
		y 53
		movieNum 10010
		discNum 1
	)
)

(instance pCh1Open of MovieButton
	(properties
		y 85
		loop 1
		movieNum 20
		discNum 1
	)
)

(instance pCh1Close of MovieButton
	(properties
		y 101
		loop 2
		movieNum 1150
		discNum 1
	)
)

(instance pCh2Open of MovieButton
	(properties
		y 133
		loop 3
		movieNum 1170
		discNum 2
	)
)

(instance pCh2Close of MovieButton
	(properties
		y 149
		loop 4
		movieNum 2200
		discNum 2
	)
)

(instance pCh3Open of MovieButton
	(properties
		y 181
		loop 5
		movieNum 2230
		discNum 2
	)
)

(instance pCh3Crime of MovieButton
	(properties
		y 197
		loop 6
		movieNum 3400
		discNum 3
	)
)

(instance pCh3Close of MovieButton
	(properties
		y 213
		loop 7
		movieNum 4110
		discNum 3
	)
)

(instance pCh4Open of MovieButton
	(properties
		y 245
		loop 8
		movieNum 4120
		discNum 4
	)
)

(instance pCh4Close of MovieButton
	(properties
		y 261
		loop 9
		movieNum 5370
		discNum 4
	)
)

(instance pCh5Open of MovieButton
	(properties
		y 293
		loop 10
		movieNum 5440
		discNum 5
	)
)

(instance pCh5Mid of MovieButton
	(properties
		y 309
		loop 11
		movieNum 6480
		discNum 4
	)
)

(instance pCh5Close of MovieButton
	(properties
		y 325
		loop 12
		movieNum 6970
		discNum 5
	)
)

(instance pCh6Open of MovieButton
	(properties
		y 357
		loop 13
		movieNum 7180
		discNum 6
	)
)

(instance pCh6Opera of MovieButton
	(properties
		y 373
		loop 14
		movieNum 9430
		discNum 2
	)
)

