;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3300)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm3300 0
)

(local
	local0
	[local1 2]
)

(instance rm3300 of KQRoom
	(properties
		picture 3300
	)

	(method (init)
		(if (IsFlag 103)
			(waterSound number: 894 loop: -1 play:)
		)
		(Load rsMESSAGE 3300)
		(Load rsVIEW 3300)
		(Load rsVIEW 3301)
		(if (not (IsFlag 100))
			(Load rsSOUND 3300)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 35 125 62 124 91 127 126 131 148 189 0 189 0 0 320 0 320 115 179 122 155 120 111 125 72 122 39 122
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 320 140 319 123 184 129 168 140
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 94 92 100 96 136 105 127 122 112 126 57 120 36 119 30 123 62 123 106 128 140 136 140 142 203 143 205 130 316 130 319 111 247 113 169 125 145 120 145 110 145 105 119 99
						yourself:
					)
			)
		)
		(SetFlag 106)
		(switch gPrevRoomNum
			(3050
				(gEgo posn: 330 128 normalize: 1)
			)
			(5400
				(gEgo posn: 97 90 normalize: 2)
			)
			(23 ; selectGameRoom
				(gEgo normalize:)
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 161 138 normalize: 3)
			)
		)
		(super init: &rest)
		(gEgo init: setScaler: Scaler 83 28 128 69 normalize:)
		(cond
			((not (IsFlag 101))
				(gKqMusic1 stop:)
				(humSound number: 3300 loop: -1 play:)
				(ClearFlag 539)
				(spider
					setPri: 106
					approachVerbs: 8 10 17 ; Do, Exit, Basket
					setHotspot: 8 10 17 ; Do, Exit, Basket
					ignoreActors: 1
					init:
				)
				(if (IsFlag 402)
					(spider cel: 22)
				)
			)
			((== gPrevRoomNum 5400)
				(gKqMusic1 number: 3000 loop: -1 play:)
			)
		)
		(if (not (IsFlag 100))
			(bird init: setPri: 106 setCycle: Fwd)
			(web
				approachVerbs: 8 10 ; Do, Exit
				setHotspot: 8 10 ; Do, Exit
				setPri: 104
				ignoreActors: 1
				init:
			)
			(if (IsFlag 101)
				(web approachVerbs: 0 setHotspot: 0)
			)
		)
		(if (IsFlag 100)
			(myNorthExit init:)
		)
		(myEastExit init:)
		(mySouthExit init:)
		(cond
			((== gPrevRoomNum 23) 0) ; selectGameRoom
			((== gPrevRoomNum 5400)
				(gCurRoom setScript: sComeIn)
			)
			((not (IsFlag 402))
				(gCurRoom setScript: introScript)
			)
			(else
				(gCurRoom setScript: sNextEnter)
			)
		)
		(if (not (gCurRoom script:))
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 5400)
			(gKqMusic1 fade: 0 30 10 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sComeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo setPri: 90 setMotion: PolyPath 132 104 self)
			)
			(2
				(gEgo setPri: -1 normalize: 4 setHeading: 135 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sNextEnter of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 3)
				)
				(1
					(if (== gPrevRoomNum 5400)
						(gEgo setMotion: MoveTo 127 101 self)
					else
						(self cue:)
					)
				)
				(2
					(if (== gPrevRoomNum 3050)
						(gEgo setMotion: MoveTo 305 128 self)
					else
						(gEgo setMotion: PolyPath 161 128 self)
					)
				)
				(3
					(switch gPrevRoomNum
						(5400
							(gEgo normalize: 0 setHeading: 90 self)
						)
						(3050
							(= cycles 1)
						)
						(else
							(gEgo setHeading: 315 self)
						)
					)
				)
				(4
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo loop: 7 posn: 161 128)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sToGate of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					normalize: 7
					posn: 127 101
					setMotion: MoveTo 97 90 self
				)
			)
			(1
				(if (== (waterSound number:) 894)
					(waterSound setLoop: 1 stop:)
				)
				(gCurRoom newRoom: 5400)
			)
		)
	)
)

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(= cycles 4)
				)
				(1
					(spider setCycle: End self)
				)
				(2
					(gMessager say: 0 0 1 0 self) ; "(PANICKED, SCREAMING)Help! Heeeeelp!"
				)
				(3
					(if (== gPrevRoomNum 3050)
						(gEgo setMotion: MoveTo 305 128 self)
					else
						(gEgo setMotion: PolyPath 161 128 self)
					)
				)
				(4
					(gEgo setHeading: 315 self)
				)
				(5
					(gGame handsOn:)
					(SetFlag 402)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(spider setCycle: 0)
					(gEgo loop: 7 posn: 161 128)
					(SetFlag 402)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sReachedOnce of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc11_3 gEgo spider self)
					(Load 140 3301) ; WAVE
				)
				(1
					(gEgo
						view: 8105
						loop: 1
						cel: 0
						posn: 171 120
						setCycle: End self
					)
				)
				(2
					(spiderSound number: 3301 loop: 1 play:)
					(gMessager say: 1 8 2 0 self) ; "(URGENT, TERRIFIED)Lady, NO! The spider's venom is deadly!"
				)
				(3
					(gEgo setCycle: Beg self)
				)
				(4
					(Load rsSOUND 821)
					(Load rsSOUND 818)
					(gEgo posn: 171 122 normalize: 7)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gEgo posn: 171 122 normalize: 7)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance spiderDeath of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsSOUND 821)
					(Load rsSOUND 818)
					(Load 140 3303) ; WAVE
					(gEgo setHeading: 325 self)
				)
				(1
					(spiderSound number: 821 loop: 1 play:)
					(spider loop: 2 cel: 0 posn: 139 80 0 setCycle: End self)
				)
				(2
					(gEgo hide:)
					(spiderSound number: 818 loop: 1 play:)
					(painSound number: 3303 loop: 1 play:)
					(spider
						loop: 3
						cel: 0
						posn: 149 121
						setPri: 120
						setCycle: End self
					)
				)
				(3
					(gEgo show:)
					(EgoDead 27 self)
				)
				(4
					(gKqMusic1 stop:)
					(spider loop: 1 cel: 22 setPri: 106 posn: 134 78 30)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(spider loop: 1 cel: 22 setPri: 106 posn: 134 78 30)
					(ClearFlag 539)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sBasketCase of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(web approachVerbs: 0 setHotspot: 0)
					(gEgo setMotion: PolyPath 147 122 self)
				)
				(1
					(Load rsVIEW 3301)
					(if (not (== (gEgo view:) 7))
						(proc11_3 gEgo spider self)
					else
						(= cycles 2)
					)
				)
				(2
					(Load rsSOUND 3302)
					(Load rsSOUND 3304)
					(gEgo
						view: 3301
						loop: 7
						cel: 0
						posn: 134 123
						setScale: 0
						setCycle: CT 17 1 self
					)
				)
				(3
					(spiderSound number: 3302 loop: 1 play:)
					(gEgo
						view: 3301
						loop: 7
						cel: 17
						setScale: 0
						setCycle: CT 20 1 self
					)
					(spider hide:)
				)
				(4
					(humSound stop:)
					(gKqMusic1 number: 3000 loop: -1 setVol: 127 play:)
					(gEgo loop: 7 cel: 20 setCycle: CT 27 1 self)
				)
				(5
					((ScriptID 13) view: 3301 hide_mouth: 1) ; aEgoTalker
					(gMessager say: 3 17 0 0 self) ; "(ALARMED, YELLING FROM INSIDE BASKET)HEY! Who took the sun? Who took my LUNCH? WHERE AM I?"
				)
				(6
					(Load rsVIEW 800)
					(gEgo
						view: 3301
						loop: 7
						cel: 27
						setScale: 0
						setPri: 114
						setCycle: CT 31 1 self
					)
				)
				(7
					(painSound number: 3304 loop: 1 play:)
					(gEgo
						view: 3301
						loop: 7
						cel: 31
						setScale: 0
						setCycle: End self
					)
				)
				(8
					(spider dispose:)
					(gEgo put: 7) ; Basket
					(gEgo
						view: 800
						setPri: -1
						posn: 150 124
						setScaler: Scaler 83 28 128 69
						normalize: 6
					)
					((ScriptID 13) ; aEgoTalker
						view: -1
						mouth_x: -999
						mouth_y: -999
						hide_mouth: 0
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(painSound stop:)
					(web approachVerbs: 0 setHotspot: 0)
					(gEgo
						view: 800
						posn: 150 124
						setPri: -1
						setScaler: Scaler 83 28 128 69
						normalize: 6
					)
					((ScriptID 13) ; aEgoTalker
						view: -1
						mouth_x: -999
						mouth_y: -999
						hide_mouth: 0
					)
					(if (gCast contains: spider)
						(spider dispose:)
					)
					(if (gEgo has: 7) ; Basket
						(gEgo put: 7) ; Basket
					)
					(if (IsFlag 100)
						(myNorthExit init:)
					)
					(humSound stop:)
					(gKqMusic1 number: 3000 loop: -1 setVol: 127 play:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sBird of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Load rsVIEW 3301)
					(= cycles 1)
				)
				(1
					(gEgo
						view: 3301
						loop: 4
						cel: 0
						posn: 154 123
						ignoreActors: 1
						setScale: 0
						setCycle: End self
					)
				)
				(2
					(Load rsSOUND 3255)
					(Load rsVIEW 3302)
					(bird setCycle: 0)
					(= cycles 1)
				)
				(3
					(bird hide:)
					(gEgo
						posn: 144 118
						cel: 0
						loop: 5
						ignoreActors: 1
						setCycle: End self
					)
				)
				(4
					(Load rsSOUND 3254)
					(Load rsVIEW 3301)
					(web loop: 1 cel: 0 setCycle: End)
					(gKqMusic1 stop:)
					(humSound number: 3254 loop: -1 play:)
					(gEgo
						view: 3301
						loop: 6
						cel: 0
						posn: 133 117
						setCycle: End self
					)
				)
				(5
					(web dispose:)
					(gEgo
						posn: 156 116
						setScaler: Scaler 83 28 128 69
						normalize: 1
					)
					(bird
						view: 3301
						loop: 9
						cel: 0
						posn: 138 88
						setPri: 120
						setCycle: Fwd
						show:
					)
					(= cycles 2)
				)
				(6
					(gMessager say: 1 8 3 0 self) ; "(KINDLY)There you are, pretty one. Safe and sound."
				)
				(7
					(humSound number: 3255 loop: -1 play:)
					(bird
						view: 3302
						loop: 0
						cel: 1
						posn: 226 158
						setPri: 120
						setCycle: End self
					)
				)
				(8
					(humSound stop:)
					(gKqMusic1 play:)
					(gEgo setMotion: MoveTo 139 116 self)
					(if (gCurRoom obstacles:)
						((gCurRoom obstacles:) dispose:)
					)
					(gCurRoom obstacles: 0)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 94 92 100 96 136 105 127 122 112 126 57 120 36 119 30 123 62 123 106 128 140 136 140 142 203 143 205 130 316 130 319 111 247 113 169 125 145 120 145 110 145 105 119 99
								yourself:
							)
					)
					(bird dispose:)
					(SetFlag 100)
					(myNorthExit init:)
				)
				(9
					(gEgo setHeading: 180 self)
				)
				(10
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(humSound stop:)
					(if (gCast contains: web)
						(web dispose:)
					)
					(if (gCast contains: bird)
						(bird dispose:)
					)
					(gEgo
						loop: 1
						posn: 154 116
						setScaler: Scaler 83 28 128 69
						normalize: 1
					)
					(SetFlag 100)
					(myNorthExit init:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance exitToEast of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo setMotion: MoveTo 330 119 self)
				)
				(1
					(gCurRoom newRoom: 3050)
				)
			)
		else
			(switch (= state newState)
				(0
					(ClearFlag 539)
					(gCurRoom newRoom: 3050)
				)
			)
		)
	)
)

(instance bird of Actor
	(properties
		noun 1
		sightAngle 300
		approachX 172
		approachY 122
		x 156
		y 83
		view 3301
	)

	(method (init)
		(super init:)
		(self approachVerbs: 8 10 setHotspot: 8 10 ignoreActors: 1) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((and (gCast contains: spider) local0)
						(gCurRoom setScript: spiderDeath)
					)
					((and (gCast contains: spider) (not local0))
						(= local0 1)
						(gCurRoom setScript: sReachedOnce)
					)
					(else
						(gCurRoom setScript: sBird)
					)
				)
			)
		)
	)
)

(instance spider of Prop
	(properties
		noun 3
		sightAngle 40
		approachX 143
		approachY 120
		x 134
		y 78
		z 30
		view 3301
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(17 ; Basket
				(SetFlag 101)
				(ClearFlag 539)
				(gCurRoom setScript: sBasketCase)
			)
			(8 ; Do
				(if (IsFlag 403)
					(gMessager say: noun theVerb 5 0) ; "(SCARY, THREATENING)Back off, lady, if you value your life! Heh heh heh!"
				else
					(SetFlag 403)
					(gMessager say: noun theVerb 4 0) ; "(FIRMLY)Listen, spider! You let that poor bird go!"
				)
			)
		)
	)
)

(instance web of Prop
	(properties
		noun 2
		sightAngle 300
		approachX 172
		approachY 122
		x 140
		y 50
		view 3300
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((and (gCast contains: spider) local0)
						(gCurRoom setScript: spiderDeath)
					)
					((and (gCast contains: spider) (not local0))
						(= local0 1)
						(gCurRoom setScript: sReachedOnce)
					)
					(else
						(gCurRoom setScript: sBird)
					)
				)
			)
		)
	)
)

(instance myNorthExit of ExitFeature
	(properties
		nsLeft 95
		nsRight 177
		nsBottom 107
		approachX 97
		approachY 96
		x 10
		y 40
		exitDir 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(if (== (waterSound number:) 894)
				(waterSound setLoop: 1 stop:)
			)
			(gCurRoom newRoom: 5400)
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)
)

(instance myEastExit of ExitFeature
	(properties
		nsLeft 309
		nsTop 112
		nsRight 320
		nsBottom 127
		approachX 318
		approachY 119
		x 330
		y 119
		exitDir 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: exitToEast)
			(return 1)
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)
)

(instance mySouthExit of ExitFeature
	(properties
		nsLeft 126
		nsTop 130
		nsRight 200
		nsBottom 135
		approachX 161
		approachY 138
		x 161
		y 160
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom newRoom: 3000)
		)
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)
)

(instance humSound of Sound
	(properties)
)

(instance spiderSound of Sound
	(properties)
)

(instance painSound of Sound
	(properties)
)

(instance waterSound of Sound
	(properties)
)

