;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30100)
(include sci.sh)
(use Main)
(use ScrollExit)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use n64896)
(use foEExit)
(use Plane)
(use Talker)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roPergolaOpening 0
)

(local
	nZoomFactor = 64
	nZoomAmt = 1
	nZoomDir = 1
	nZoomEnd = 128
	nZoomSaveTime
	nZoomElapsed
	nZoomSpeed = 8
	bClickedOnTiedTorin
)

(instance voBackground of View
	(properties
		y 316
		view 30105
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
	)
)

(instance oZoomer of Code
	(properties)

	(method (doit &tmp nStep nDist)
		(if (>= (= nZoomElapsed (- gGameTime nZoomSaveTime)) nZoomSpeed)
			(if (== nZoomFactor nZoomEnd)
				(soEntrance cue:)
				(return)
			)
			(= nStep (MulDiv nZoomAmt nZoomElapsed nZoomSpeed))
			(if (< (= nDist (- nZoomEnd nZoomFactor)) 0)
				(= nZoomDir -1)
			else
				(= nZoomDir 1)
			)
			(if (< (= nDist (Abs nDist)) nStep)
				(+= nZoomFactor (* nDist nZoomDir))
			else
				(+= nZoomFactor (* nStep nZoomDir))
			)
			(= nZoomSaveTime gGameTime)
			(voBackground scaleX: nZoomFactor scaleY: nZoomFactor)
		)
	)
)

(instance foLowerShard of ExitFeature
	(properties
		noun 2
		nsTop 191
		nsRight 80
		nsBottom 312
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 13)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gMessager say: noun 0 0 0) ; "Perhaps that's what I should do...transport myself on down...through that shard!"
			)
			(13 ; ioEressdy
				(gEgo get: ((ScriptID 64001 0) get: 9)) ; oInvHandler, ioEressdy
				(gMessager say: noun theVerb 0 0 self) ; "Of course. Why didn't I think of that before? I'll just use a little more of the erresdy powder and continue on down."
			)
		)
	)

	(method (cue)
		(gEgo setMotion: MoveTo 86 297)
	)
)

(instance foUpperShard of Feature
	(properties
		noun 1
		nsLeft 56
		nsRight 132
		nsBottom 75
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gMessager say: noun 0 0 0) ; "Look at how that shard is broken. I should have continued on down. But down to where?"
	)
)

(instance foThunderstorm of Feature
	(properties
		noun 3
		nsLeft 356
		nsRight 630
		nsBottom 132
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gMessager say: noun 0 0 0) ; "Looks like rain approaching. I wonder if Boogle can be an umbrella?"
	)
)

(instance foHorizon of Feature
	(properties
		nsLeft 353
		nsTop 184
		nsRight 542
		nsBottom 225
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gEgo setMotion: MoveTo 448 216)
	)
)

(instance oAmbient of TPSound
	(properties)
)

(instance oTorinFaceDown of Narrator
	(properties)
)

(instance soEntrance of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(FadeToBlack 0 10 self)
				(oAmbient setAmbient: 30199)
			)
			(1
				(= ticks 180)
			)
			(2
				(= nZoomSaveTime gGameTime)
				(gTheDoits add: oZoomer)
			)
			(3
				(gTheDoits delete: oZoomer)
				(oZoomer dispose:)
				(= cycles 3)
			)
			(4
				(oTreetopPlane dispose:)
				(gCurRoom plane: (oTreetopPicPlane init: yourself:))
				(foUpperShard init:)
				(foLowerShard init:)
				(foThunderstorm init:)
				(foHorizon init:)
				((ScriptID 64899 1) init:) ; foWExit
				((ScriptID 64899 0) init:) ; foEExit
				(poTorinEntrance init: hide:)
				(goSound1 playSound: 30101)
				(= ticks 120)
			)
			(5
				(poTorinEntrance show: setCycle: CT 5 1 self)
			)
			(6
				(= ticks (poTorinEntrance cycleSpeed:))
			)
			(7
				(= gtTorin oTorinFaceDown)
				(gMessager say: 0 0 0 1) ; "(LANDING FACE DOWN) Ugh."
				(poTorinEntrance setCycle: End self)
				(poLeavesScatter init: setCycle: End self)
			)
			(8)
			(9
				(poTorinEntrance dispose:)
				(poLeavesScatter dispose:)
				(poTorinLooksAround init:)
				(= ticks 150)
			)
			(10
				(gMessager kill:)
				(gMessager sayRange: 0 0 0 2 3) ; "What is THIS place?"
				(poTorinLooksAround setCycle: CT 7 1 self)
			)
			(11
				(= ticks 60)
			)
			(12
				(poTorinLooksAround setCycle: CT 17 1 self)
			)
			(13
				(= ticks 60)
			)
			(14
				(poTorinLooksAround setCycle: CT 33 1 self)
			)
			(15
				(= ticks 60)
			)
			(16
				(poTorinLooksAround setCycle: End self)
			)
			(17
				(poTorinLooksAround dispose:)
				(gEgo
					loop: 8
					cel: 0
					posn: 204 252
					init:
					normalize: 0 60100 8
				)
				(gTheDoits add: oTestForFall)
				(= gtTorin 0)
				(gMessager kill:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTorinEntrance of Prop
	(properties
		x 204
		y 252
		view 30100
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)
)

(instance poTorinLooksAround of Prop
	(properties
		x 204
		y 252
		view 30100
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)
)

(instance poTorinFallsThrough of Prop
	(properties
		x 204
		y 252
		view 30106
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)
)

(instance poLeavesFlyUp of Prop
	(properties
		x 204
		y 252
		view 30106
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100)
	)
)

(instance poLeavesScatter of Prop
	(properties
		x 204
		y 252
		view 30100
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 99)
	)
)

(instance oTreetopPlane of Plane
	(properties
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance oTreetopPicPlane of Plane
	(properties
		picture 30100
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance oTreebasePlane of Plane
	(properties
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(voTorinUnconscious init: self setScale:)
		(poPergolians
			y: 180
			setCel: 0
			init: self
			setCycle: End coTestForClick
			setScale:
		)
		(poPergoliansKillTorin setScale:)
		(= nZoomFactor 128)
		(= nZoomEnd (MulDiv 128 133 100))
		(= nZoomSaveTime gGameTime)
		(gTheDoits add: oBaseZoomer)
	)
)

(instance voTorinUnconscious of View
	(properties
		x 445
		y 180
		maxScale 256
		view 30104
	)
)

(instance poPergolians of Prop
	(properties
		x 445
		y 1444
		maxScale 256
		view 30104
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(= bClickedOnTiedTorin 1)
		((ScriptID 64017 0) set: 115) ; oFlags
		(gGame handsOff:)
	)
)

(instance poPergoliansKillTorin of Prop
	(properties
		x 445
		y 180
		maxScale 256
		view 30104
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 182)
	)
)

(instance voSkeleton of Prop
	(properties
		x 330
		y 130
		maxScale 256
		view 30104
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 181)
	)
)

(instance coTestForClick of CueMe
	(properties)

	(method (cue)
		(if bClickedOnTiedTorin
			(FadeToBlack 1 10 coNextRoom)
		else
			(gCurRoom setScript: soSkeleton)
		)
	)
)

(instance coNextRoom of CueMe
	(properties)

	(method (cue)
		(gCurRoom newRoom: 30200) ; roPergolaCity
	)
)

(instance soSkeleton of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPergolians dispose:)
				(poPergoliansKillTorin setCel: 0 init: setCycle: CT 12 1 self)
			)
			(1
				(voSkeleton init:)
				(poPergoliansKillTorin setCycle: End self)
			)
			(2
				((ScriptID 64019 0) show: 0 42 1 30200) ; DeathDialog
				(oTreebasePlane dispose: init:)
				(self dispose:)
			)
		)
	)
)

(instance oBaseZoomer of Code
	(properties)

	(method (doit &tmp nStep nDist)
		(if (>= (= nZoomElapsed (- gGameTime nZoomSaveTime)) nZoomSpeed)
			(if (== nZoomFactor nZoomEnd)
				(gTheDoits delete: self)
				(self dispose:)
			)
			(= nStep (MulDiv nZoomAmt nZoomElapsed nZoomSpeed))
			(if (< (= nDist (- nZoomEnd nZoomFactor)) 0)
				(= nZoomDir -1)
			else
				(= nZoomDir 1)
			)
			(if (< (= nDist (Abs nDist)) nStep)
				(+= nZoomFactor (* nDist nZoomDir))
			else
				(+= nZoomFactor (* nStep nZoomDir))
			)
			(= nZoomSaveTime gGameTime)
			(voTorinUnconscious scaleX: nZoomFactor scaleY: nZoomFactor)
			(poPergolians scaleX: nZoomFactor scaleY: nZoomFactor)
			(poPergoliansKillTorin scaleX: nZoomFactor scaleY: nZoomFactor)
		)
	)
)

(instance roPergolaOpening of TPRoom
	(properties
		purge 2500
	)

	(method (init)
		(super init: &rest)
		(gOEventHandler unregisterGlobalHandler: (ScriptID 64010 1)) ; oRightClickHandler
		(= plane (oTreetopPlane init: yourself:))
		(voBackground setScale: scaleX: 64 scaleY: 64 init:)
		(gCurRoom setScript: soEntrance)
		(goMusic1 setMusic: 0)
	)

	(method (dispose)
		(gOEventHandler registerGlobalHandler: (ScriptID 64010 1)) ; oRightClickHandler
		(super dispose: &rest)
	)

	(method (gimme))
)

(instance oTreeScrollPlane of TorScrollPlane
	(properties
		priority 20
	)

	(method (addPics)
		(AddPicAt self 30100 0 0)
		(AddPicAt self 30101 0 316)
		(AddPicAt self 30102 0 632)
		(AddPicAt self 30103 0 948)
		(AddPicAt self 30104 0 1264)
	)
)

(instance oTestForFall of Code
	(properties)

	(method (doit)
		(if
			(or
				(> (Abs (- (gEgo x:) 204)) 35)
				(> (Abs (- (gEgo y:) 252)) 15)
			)
			(gCurRoom setScript: soTorinFallsThrough)
			(gTheDoits delete: self)
			(self dispose:)
		)
	)
)

(instance oFallTalk of TPSound
	(properties)
)

(instance soTorinFallsThrough of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(if (OneOf (gEgo loop:) 5 1 7)
					(gEgo setHeading: 270 self)
					(poTorinFallsThrough
						loop: (+ 1 (poTorinFallsThrough loop:))
					)
				else
					(gEgo setHeading: 90 self)
				)
				(poTorinFallsThrough posn: (gEgo x:) (gEgo y:))
			)
			(1
				(gEgo hide:)
				((ScriptID 64017 0) set: 114) ; oFlags
				(goSound1 preload: 30103 30208 30102)
				(poTorinFallsThrough init: setCycle: End self)
				(oAmbient fadeRel: 70)
				(goSound1 playSound: 30102 coMoreFallingSFX)
				(gMessager say: 0 0 0 4) ; "(FALLING THROUGH TREETOPS) Ooooohhhhh."
			)
			(2
				(poTorinFallsThrough dispose:)
				(poLeavesFlyUp
					posn: (gEgo x:) (gEgo y:)
					init:
					setCycle: End self
				)
			)
			(3
				(poLeavesFlyUp dispose:)
				(= ticks 1)
			)
			(4
				(oTreetopPicPlane dispose:)
				(goMusic1 fadeIn: 30100 6 60)
				(gCurRoom
					plane:
						(oTreeScrollPlane
							oNScrollExit: 0
							oSScrollExit: 0
							init: (gThePlane getWidth:) 1580
							yourself:
						)
				)
				(poPergolians init:)
				(= cycles 2)
			)
			(5
				(oTreeScrollPlane panTo: 0 1264 self 3)
			)
			(6
				(oTreeScrollPlane dispose:)
				(gCurRoom plane: (oTreebasePlane init: yourself:))
				(= nZoomSaveTime gGameTime)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coMoreFallingSFX of CueMe
	(properties)

	(method (cue)
		(goSound1 playSound: 30103 coUgh)
	)
)

(instance coUgh of CueMe
	(properties)

	(method (cue)
		(oFallTalk playSound: 30208)
	)
)

