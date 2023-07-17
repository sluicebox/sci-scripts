;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use n011)
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

(procedure (localproc_0 param1 &tmp temp0)
	(if (ResCheck 151 param1) ; VMD
		(proc11_21 param1)
	else
		(Printf {*** %d.vmd Not Found! ***} param1)
	)
	(while ((= temp0 (Event new: 3)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(class movieCast of Set
	(properties)
)

(instance moviePlane of PanelPlane
	(properties)

	(method (init)
		(proc11_12)
		(gSounds eachElementDo: #pause 1)
		((gUser sel_715:) sel_736:)
		(= picture (+ 120 gChapter))
		(= global135 0)
		(= local1 gChapter)
		(= local2 (gUser sel_712:))
		(gUser sel_712: 62)
		((gUser sel_715:) show: update:)
		(= local0 ((gUser sel_715:) sel_718:))
		((gUser sel_715:) sel_718: (List new:))
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
		((gUser sel_715:) update: sel_719: 0)
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
		(gUser sel_712: local2)
		(((gUser sel_715:) sel_718:) release: dispose:)
		((gUser sel_715:) sel_718: local0)
		((gUser sel_715:) sel_719: 1 update:)
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
		BAD_SELECTOR 1
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
		x 184
		view 127
		BAD_SELECTOR 1
		cycleSpeed 15
		BAD_SELECTOR 0
		BAD_SELECTOR 0
	)

	(method (doVerb)
		(proc11_12)
		(movieCast eachElementDo: #hide)
		(exitButton hide:)
		(plane drawPic: -1)
		(FrameOut)
		(Palette 2 0 255 100) ; PalIntensity
		(gGame getDisc: BAD_SELECTOR)
		(localproc_0 BAD_SELECTOR)
		(if (== BAD_SELECTOR 5450)
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
		y 67
		BAD_SELECTOR 10010
		BAD_SELECTOR 1
	)
)

(instance pCh1Open of MovieButton
	(properties
		y 99
		loop 1
		BAD_SELECTOR 20
		BAD_SELECTOR 1
	)
)

(instance pCh1Close of MovieButton
	(properties
		y 115
		loop 2
		BAD_SELECTOR 1150
		BAD_SELECTOR 1
	)
)

(instance pCh2Open of MovieButton
	(properties
		y 145
		loop 3
		BAD_SELECTOR 1170
		BAD_SELECTOR 2
	)
)

(instance pCh2Close of MovieButton
	(properties
		y 161
		loop 4
		BAD_SELECTOR 2200
		BAD_SELECTOR 2
	)
)

(instance pCh3Open of MovieButton
	(properties
		y 193
		loop 5
		BAD_SELECTOR 2230
		BAD_SELECTOR 2
	)
)

(instance pCh3Crime of MovieButton
	(properties
		y 209
		loop 6
		BAD_SELECTOR 3400
		BAD_SELECTOR 3
	)
)

(instance pCh3Close of MovieButton
	(properties
		y 224
		loop 7
		BAD_SELECTOR 4110
		BAD_SELECTOR 3
	)
)

(instance pCh4Open of MovieButton
	(properties
		y 252
		loop 8
		BAD_SELECTOR 4120
		BAD_SELECTOR 4
	)
)

(instance pCh4Close of MovieButton
	(properties
		y 268
		loop 9
		BAD_SELECTOR 5370
		BAD_SELECTOR 4
	)
)

(instance pCh5Open of MovieButton
	(properties
		y 298
		loop 10
		BAD_SELECTOR 5440
		BAD_SELECTOR 5
	)
)

(instance pCh5Mid of MovieButton
	(properties
		y 311
		loop 11
		BAD_SELECTOR 6480
		BAD_SELECTOR 4
	)
)

(instance pCh5Close of MovieButton
	(properties
		y 327
		loop 12
		BAD_SELECTOR 6970
		BAD_SELECTOR 5
	)
)

(instance pCh6Open of MovieButton
	(properties
		y 356
		loop 13
		BAD_SELECTOR 7180
		BAD_SELECTOR 6
	)
)

(instance pCh6Opera of MovieButton
	(properties
		y 372
		loop 14
		BAD_SELECTOR 9430
		BAD_SELECTOR 2
	)
)

