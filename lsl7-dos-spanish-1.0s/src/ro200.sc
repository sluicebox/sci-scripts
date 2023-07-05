;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use oAnnounceTimer)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Styler)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	ro200 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 1
	local7
)

(instance ro200 of L7Room
	(properties
		picture 20000
	)

	(method (init)
		(super init:)
		(poLarry init:)
		(if
			(and
				((ScriptID 64017 0) test: 27) ; oFlags
				(not ((ScriptID 64017 0) test: 24)) ; oFlags
			)
			(proc80_1 0)
			(if ((ScriptID 64017 0) test: 291) ; oFlags
				(self setScript: soCyberSniff)
			else
				(self setScript: soLoudspeaker)
			)
		else
			(self setScript: soCyberSniff)
		)
		(poSail init:)
		(if ((ScriptID 64017 0) test: 291) ; oFlags
			(poSail cel: 99 doit:)
		)
		(foYardarmLeft init:)
		(foYardarmRight init:)
		(foIsland1 init:)
		(foIsland2 init:)
		(foOcean init:)
		(poWaterRipples1 init:)
		(poWaterRipples2 init:)
		(poBoatRipples init:)
		(foExit init:)
		(gOSound1 setRelVol: 35)
		(gOAmbience setAmbient: 20110)
		(gGame handsOn:)
	)

	(method (gimme)
		(proc80_1 0)
		((ScriptID 64017 0) set: 27) ; oFlags
		(gEgo get: ((ScriptID 64037 0) get: 3)) ; oInvHandler, ioKnife
		(self setScript: soLoudspeaker)
	)

	(method (dispose)
		(gOSound1 setRelVol: 100)
		(gOAmbience fadeOut:)
		(proc80_1 1)
		(super dispose:)
	)
)

(instance soCyberSniff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 120)
			)
			(2
				(= local7 1)
				(if ((ScriptID 64017 0) test: 290) ; oFlags
					(proc64896_15 1 0)
				else
					(proc64896_15 1)
					((ScriptID 64017 0) set: 290) ; oFlags
				)
				(self dispose:)
			)
		)
	)
)

(instance soLoudspeaker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 60)
			)
			(2
				(if (not local7)
					(if ((ScriptID 64017 0) test: 290) ; oFlags
						(proc64896_15 1 0)
					else
						(proc64896_15 1)
						((ScriptID 64017 0) set: 290) ; oFlags
					)
				)
				(= cycles 1)
			)
			(3
				(Load 140 20101) ; WAVE
				(= ticks (Random 180 300))
			)
			(4
				(cond
					((poLarry script:)
						(-- state)
						(= cycles 3)
					)
					((== local0 2)
						(= local2 1)
						(-- state)
						(= cycles 3)
					)
					((== local0 1)
						(gGame handsOff:)
						(oSFX setAmbient: 20101)
						(poSail setCycle: End poSail)
						((ScriptID 64017 0) set: 291) ; oFlags
						(gOSound1
							playSubtitledSound:
								(= register (Random 6200 6225))
								0
								0
								(+ 10 (- register 6200))
								0
								0
								80
						)
						(poLarry
							view: 20103
							loop: 0
							cel: 0
							posn: 214 235
							setScript: soRunInPlace
						)
						(gMessager say: 0 0 5 2) ; "(LOSING BALANCE) Oh. Whoa! (AND OVER YOU GO!) Whoaaaaaahhhhhhhhh!!"
						(= ticks 120)
					)
					(else
						(gGame handsOff:)
						(oSFX setAmbient: 20101)
						(poSail setCycle: End poSail)
						((ScriptID 64017 0) set: 291) ; oFlags
						(if global229
							(proc64031_2 (/ (* (= register global229) 30) 100))
						else
							(= register 0)
						)
						(gMessager say: 0 0 5 1 self) ; "Mr. Munsil: report to Massage Therapy immediately!"
					)
				)
			)
			(5
				(switch local0
					(0
						(proc64031_2 register)
						(gGame handsOn:)
						(self dispose:)
					)
					(1
						(poLarry setScript: 0 setCycle: End self)
					)
				)
			)
			(6
				(poLarry dispose:)
				(= cycles 1)
			)
			(7
				(if (gTalkers isEmpty:)
					(= ticks 90)
				else
					(-- state)
					(= cycles 3)
				)
			)
			(8
				(ShakePlane gThePlane 2 5)
				((ScriptID 64017 0) set: 267) ; oFlags
				(gCurRoom newRoom: 210) ; ro210
				(self dispose:)
			)
		)
	)
)

(instance soRunInPlace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: CT 13 1 self)
			)
			(1
				(client cel: 10 setCycle: CT 13 1 self)
			)
			(2
				(self changeState: (- state 1))
			)
		)
	)
)

(instance soCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 20105 20104 20107 32205 20109 20108) ; WAVE
				(= local3 1)
				(switch local0
					(0
						(poLarry setScript: soWalkOut self)
					)
					(2
						(poLarry setScript: soWalkBackPartial self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(poLarry
					view: 20104
					loop: 0
					cel: 0
					posn: 207 233
					cycleSpeed: 9
					setCycle: End self 6 19 99
				)
				(UpdateScreenItem poLarry)
				(poSail dispose:)
			)
			(2
				(oSFX playSound: 20104)
			)
			(3
				(oSFX stop:)
			)
			(4
				((ScriptID 64017 0) set: 24) ; oFlags
				(gEgo get: ((ScriptID 64037 0) get: 31)) ; oInvHandler, ioPolyester
				(poLarry cycleSpeed: 6 setScript: soMakeAnnouncement self)
				(= ticks 20)
			)
			(5
				(oSFX setAmbient: 20105)
				(poLarry view: 20105 loop: 0 cel: 0 setCycle: End self 4 999)
			)
			(6
				(= local4 0)
				(gMessager say: 2 52 0 2 oCueMe) ; "Oh, no! (TURN OFF-MIKE, AND THUMP SELF AS YOU'RE ROLLED UP IN THE SHIP'S ELECTRIC SAILS) Ohhfgttf. Ouuamph. Grabprt!"
			)
			(7
				(oSFX stop:)
				(= cycles 1)
			)
			(8
				(if (not local4)
					(-- state)
					(poLarry view: 20200 loop: 0 cel: 0 setCycle: End self)
					(oSFX setAmbient: 20108)
				else
					(poLarry view: 20200 loop: 1 cel: 0)
					(oSFX stop:)
					(= cycles 1)
				)
			)
			(9
				(poBirds init: setCycle: End self)
			)
			(10
				(poBirds hide:)
				(= ticks 60)
			)
			(11
				(oSFX playSound: 20107)
				(poBirds
					view: 20201
					loop: 0
					cel: 0
					posn: 207 233
					show:
					setCycle: End self
				)
			)
			(12
				(oSFX stop:)
				(= ticks 150)
			)
			(13
				(poBirds setScript: soPeckLarry)
			)
			(14
				(= local6 0)
				(gMessager say: 2 52 0 6 self) ; "(MUFFLED; FROM INSIDE THE SAILS) Doh!"
			)
			(15
				(= local6 1)
				(gOAmbience fadeOut:)
				(proc64896_1 1 6 self)
			)
			(16
				(= local6 0)
				(poBirds setScript: 0 hide:)
				(poLarry view: 20202 loop: 1 cel: 0)
				(gCurRoom drawPic: 20100)
				(oSFX setAmbient: 32205)
				(proc64896_1 0 6 self)
			)
			(17
				(Load 140 20106 20301) ; WAVE
				(= ticks 240)
			)
			(18
				(oSFX2 setAmbient: 20108)
				(poLarry loop: 0 cel: 0 setCycle: ForwardCounter 2 poLarry)
				(proc64896_1 1 6 self)
			)
			(19
				(Load rsVIEW 20301)
				(Load 140 20308 20306) ; WAVE
				(oSFX stop:)
				(oSFX2 stop:)
				(poBirds view: 20300 loop: 0 cel: 0 posn: 207 233 show:)
				(poLarry view: 20200 loop: 1 cel: 0 setCycle: 0)
				(gCurRoom drawPic: 20200)
				(gOMusic1 playSound: 20300)
				(oSFX setAmbient: 20106)
				(proc64896_1 0 1 self)
			)
			(20
				(oSFX playSound: 20301)
				(poBirds setCycle: End poBirds)
				(= ticks 90)
			)
			(21
				(gOSound1 playSubtitledSound: 20304 2 52 0 7)
				(= ticks 20)
			)
			(22
				(poLarry view: 20301 loop: 0 cel: 0 setCycle: End self 3 18)
			)
			(23
				(gMessager say: 2 52 0 8) ; "(MUFFLED) Oh, boy!"
			)
			(24
				(oSFX playSound: 20308)
				((= register (Prop new:))
					view: 20301
					loop: 1
					cel: 0
					setPri: 500
					posn: 207 233
					init:
					setCycle: End self
				)
			)
			(25
				(register dispose:)
				(= ticks 180)
			)
			(26
				(oSFX playSound: 20306 self)
				(gOMusic1 fadeOut:)
				(ShakePlane gThePlane 2 5)
			)
			(27
				((ScriptID 64017 0) set: 267) ; oFlags
				(gCurRoom newRoom: 210) ; ro210
				(self dispose:)
			)
		)
	)
)

(instance soMakeAnnouncement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gOSound1 playSubtitledSound: 20305 2 52 0 3 self)
				(= ticks 1530)
			)
			(1
				(= local6 0)
				(gMessager say: 2 52 0 4 self) ; "(MUFFLED) I hope he makes another announcement quick, so I can get out of here!"
			)
			(2
				(= local6 1)
			)
			(3
				(gOSound1 playSubtitledSound: 20303 2 52 0 5 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soPeckLarry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poBirds view: 20201 loop: 1 cel: 0 setCycle: End self 3 99)
			)
			(1
				(if local6
					(oSFX2 playSound: 20109 self)
				else
					(= cycles 1)
				)
			)
			(2 0)
			(3
				(poBirds view: 20201 loop: 1 cel: 0 setCycle: End self 3 99)
			)
			(4
				(if local6
					(oSFX2 playSound: 20109 self)
				else
					(= cycles 1)
				)
			)
			(5 0)
			(6
				(poLarry loop: 0 cel: 0 setCycle: ForwardCounter 2 self)
				(oSFX setAmbient: 20108)
			)
			(7
				(oSFX stop:)
				(poLarry loop: 1 cel: 0)
				(= ticks (Random 90 180))
			)
			(8
				(self changeState: 0)
			)
		)
	)

	(method (dispose)
		(poBirds setCycle: Beg)
		(poLarry loop: 1 cel: 0)
		(super dispose:)
	)
)

(instance soWalkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client cel: 0 loop: 0 setCycle: End self)
			)
			(1
				(= local0 1)
				(foYardarmLeft forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
				(if (not local3)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance soWalkBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 20100
					loop: 0
					cel: 99
					posn: 207 233
					setCycle: Beg self
				)
			)
			(1
				(= local0 0)
				(foYardarmLeft forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
				(if local1
					(gCurRoom newRoom: 210) ; ro210
				else
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance soWalkFurther of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 20101
					loop: 0
					cel: 0
					posn: 214 235
					setCycle: End self
				)
			)
			(1
				(= local0 2)
				(foYardarmRight forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soWalkBackPartial of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client view: 20101 loop: 0 cel: 99 setCycle: Beg self)
			)
			(1
				(= local0 1)
				(foYardarmRight forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
				(cond
					((or local2 local3) 0)
					(local1
						(poLarry setScript: soWalkBack)
					)
					(else
						(gGame handsOn:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance poLarry of Prop
	(properties
		priority 500
		x 207
		y 233
		view 20100
		fixPriority 1
	)

	(method (cue)
		(oSFX2 stop:)
	)
)

(instance poSail of Prop
	(properties
		noun 2
		x 207
		y 233
		view 20102
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; Carving Knife
				(if cel
					((ScriptID 64017 0) set: 298) ; oFlags
					(gCurRoom setScript: soCartoon)
				else
					(gMessager say: noun theVerb 1) ; "Good idea, Larry! However, the sail, unlike you, is wound quite tightly."
				)
			)
			(1 ; Look
				((ScriptID 64017 0) set: 23) ; oFlags
				((ScriptID 64017 0) set: 298) ; oFlags
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(oSFX stop:)
	)
)

(instance poWaterRipples1 of Prop
	(properties
		priority 5
		x 325
		y 150
		cycleSpeed 30
		view 20107
		fixPriority 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance poWaterRipples2 of Prop
	(properties
		priority 5
		x 400
		y 300
		cycleSpeed 20
		view 20108
		fixPriority 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance poBoatRipples of Prop
	(properties
		priority 5
		y 478
		cycleSpeed 15
		view 20109
		fixPriority 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance poBirds of Prop
	(properties
		priority 10
		x 300
		view 20106
		fixPriority 1
	)

	(method (cue)
		(if local5
			(oSFX stop:)
			(self dispose:)
		else
			(self loop: 1 cel: 0 setCycle: End self)
		)
		(++ local5)
	)
)

(instance foYardarmLeft of Feature
	(properties
		x 167
		y 261
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 119 263 206 227 218 253 128 294
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(cond
			((== local0 0)
				(poLarry setScript: soWalkOut)
			)
			((== local0 1)
				(poLarry setScript: soWalkBack)
			)
			(else
				(poLarry setScript: soWalkBackPartial)
			)
		)
	)
)

(instance foYardarmRight of Feature
	(properties
		x 406
		y 161
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 205 228 603 69 607 75 217 253
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(cond
			((== local0 0)
				(poLarry setScript: soWalkOut)
			)
			((== local0 1)
				(poLarry setScript: soWalkFurther)
			)
			(else
				(poLarry setScript: soWalkBackPartial)
			)
		)
	)
)

(instance foIsland1 of Feature
	(properties
		noun 3
		x 390
		y 281
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 314 257 350 256 376 256 406 237 425 244 445 294 467 306 467 314 434 311 441 322 429 325 402 314 403 306 379 296 383 308 364 309 337 289 352 285
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foIsland2 of Feature
	(properties
		noun 3
		x 347
		y 124
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 315 121 321 117 338 118 348 113 367 116 379 131 352 135 332 131 332 125
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foOcean of Feature
	(properties
		noun 4
		x 375
		y 1
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 121 95 224 98 359 112 498 143 588 173 639 200 639 478 195 478 112 407
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExit of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 110 0 110 479 0 479 yourself:)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(= local1 1)
		(switch local0
			(0
				(gCurRoom newRoom: 210) ; ro210
			)
			(1
				(poLarry setScript: soWalkBack)
			)
			(2
				(poLarry setScript: soWalkBackPartial)
			)
		)
	)
)

(instance oCueMe of CueMe
	(properties)

	(method (cue)
		(= local4 1)
	)
)

(instance oSFX of TPSound
	(properties)
)

(instance oSFX2 of TPSound
	(properties)
)

