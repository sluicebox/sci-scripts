;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50900)
(include sci.sh)
(use Main)
(use InfiniteScrollExit)
(use ScrollExit)
(use oBoogle)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use NewUser)
(use n64896)
(use foEExit)
(use Plane)
(use Talker)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	roBackstageAmp 0
	toRabbitCu 1
	toRabbit 2
	toCentipede 3
	toMagician 4
	toAcrobat 5
	toStageManager 6
	oCarpenterActionCuer 7
	oCarpenterActionSeenCuer 8
	oCarpenterVanishCuer 9
	oAcrobatsVanishCuer 10
)

(local
	lastEgoX = -1
	bStageManagerFacingRight = 1
	bAcrobatsTumbled
	bWaitingForDustToClear
	bCarpenterDoneMeasuring
	bStageManagerStopped
	bSeenArchery
	bWhirlPlaying
	oCarpenterScript
	[trans2 8] = [3 6 0 4 2 5 1 7]
)

(instance foLeftCurtain of Feature
	(properties
		nsLeft 2998
		nsTop 12
		nsRight 3067
		nsBottom 239
		approachX 3050
		approachY 257
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 5)) ; oNorthEastCursor
	)

	(method (doVerb)
		(gEgo setScript: soLeftCurtain)
	)
)

(instance soLeftCurtain of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(foLeftCurtain approachX:)
					(foLeftCurtain approachY:)
					self
				)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 3050 220 self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gCurRoom newRoom: 51000) ; roOnStage
			)
		)
	)
)

(instance foRightCurtain of ExitFeature
	(properties
		nsLeft 734
		nsTop 17
		nsRight 801
		nsBottom 227
		approachX 768
		approachY 233
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
	)

	(method (doVerb)
		(ShortestWalk approachX approachY self)
	)

	(method (cue)
		(gCurRoom newRoom: 51000) ; roOnStage
	)
)

(instance voDoor of View
	(properties
		x 2109
		y 212
		view 50927
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
	)
)

(instance voBlackDoor of View
	(properties
		x 2109
		y 212
		view 50928
	)

	(method (init)
		(super init: &rest)
		(self setPri: 0)
	)
)

(instance poEgoEntrance of Prop
	(properties
		x 2069
		y 207
		view 50912
	)
)

(instance poDancingCentipede of Prop
	(properties
		x 1904
		y 269
		view 50912
		loop 2
	)
)

(instance voCentipedeBody of View
	(properties
		x 1874
		y 269
		view 50912
		loop 5
	)
)

(instance toCentipede of Talker
	(properties
		x 1874
		y 269
		view 50912
		loop 1
		priority 270
	)

	(method (init)
		(poDancingCentipede hide:)
		(voCentipedeBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(poDancingCentipede show:)
		(voCentipedeBody dispose:)
		(super dispose: &rest)
	)
)

(instance soEgoEntrance of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo bAutoScroll: 0)
				(oBackstageScrollPlane scrollTo: 1756 0)
				(poEgoEntrance init:)
				(poDancingCentipede init:)
				(= gnCentipedeTalker 1)
				(gMessager say: 0 0 0 0 self) ; "That's it."
			)
			(1
				(= ticks (poDancingCentipede cycleSpeed:))
			)
			(2
				(goSound1 setAmbient: 50902)
				(poDancingCentipede setCycle: CT 22 1 self)
			)
			(3
				(poEgoEntrance setCycle: End)
				(poDancingCentipede setCycle: CT 25 1 self)
			)
			(4
				(goSound1 stop:)
				(goSound1 preload: 50903)
				(= ticks 60)
			)
			(5
				(poDancingCentipede setCycle: CT 29 1 self)
			)
			(6
				(goSound1 playSound: 50903)
				(= ticks (poDancingCentipede cycleSpeed:))
			)
			(7
				(voHat init:)
				(voCane init:)
				(poDancingCentipede setCel: 30)
				(= ticks 60)
			)
			(8
				(goSound1 preload: 50801 50802)
				(goSound1 playSound: 50902)
				(poDancingCentipede setCycle: End self)
			)
			(9
				(poDancingCentipede
					setLoop: 3
					setCel: 0
					posn: 2109 212
					setCycle: CT 3 1 self
				)
			)
			(10
				(voBlackDoor init:)
				(voDoor hide:)
				(= ticks (poDancingCentipede cycleSpeed:))
			)
			(11
				(goSound1 playSound: 50801 self)
				(poDancingCentipede setCycle: CT 8 1 self)
			)
			(12)
			(13
				(goSound1 playSound: 50802)
				(poDancingCentipede setCycle: End self)
			)
			(14
				(poDancingCentipede dispose:)
				(voDoor show:)
				(voBlackDoor dispose:)
				(= gnCentipedeTalker 0)
				(poEgoEntrance
					setLoop: 4
					setCel: 0
					posn: 2000 206
					setCycle: End self
				)
			)
			(15
				(gEgo
					posn: 2074 207
					loop: 8
					cel: 2
					normalize: 0 60100 8
					setScaler: Scaler 100 85 283 211
					init:
					normalize: 1 60100 8
					ignoreActors: 1
					code: oEgoCode
					setWalkHandler: oScrollerWalkHandler
				)
				(gTheDoits add: oRabbitCuer)
				(poCarpenter setScript: soCarpenterSaws)
				(gTheDoits add: oAcrobatCuer)
				(poEgoDouble init:)
				(gGame handsOn:)
				(poEgoEntrance dispose:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(oBackstageScrollPlane scrollTo: 1756 0)
		(poEgoEntrance dispose:)
		(poDancingCentipede dispose:)
		(voHat init:)
		(voCane init:)
		(voBlackDoor dispose:)
		(voDoor show:)
		(= gnCentipedeTalker 0)
		(goSound1 stop:)
		(gEgo
			posn: 2074 207
			loop: 8
			cel: 2
			normalize: 0 60100 8
			setScaler: Scaler 100 85 283 211
			init:
			normalize: 1 60100 8
			ignoreActors: 1
			code: oEgoCode
			setWalkHandler: oScrollerWalkHandler
		)
		(if (not (gTheDoits contains: oRabbitCuer))
			(gTheDoits add: oRabbitCuer)
		)
		(if (not (poCarpenter script:))
			(poCarpenter setScript: soCarpenterSaws)
		)
		(if (not (gTheDoits contains: oAcrobatCuer))
			(gTheDoits add: oAcrobatCuer)
		)
		(poEgoDouble init:)
		(gGame handsOn:)
		(poEgoEntrance dispose:)
		(self dispose:)
	)
)

(instance oRabbitCuer of Code
	(properties)

	(method (doit)
		(if (< 1640 (gEgo x:) 1960)
			(gEgo setMotion: 0)
			(gGame handsOff:)
			(gCurRoom setScript: soArchery)
			(gTheDoits delete: self)
			(self dispose:)
		)
	)
)

(instance oCarpenterVanishCuer of Code
	(properties)

	(method (doit)
		(if
			(or
				(< (oBackstageScrollPlane nCurPosX:) 577)
				(> (oBackstageScrollPlane nCurPosX:) 1687)
			)
			(poCarpenter dispose:)
			(voSaw init: addHotspotVerb: 1)
			((ScriptID 64017 0) set: 209) ; oFlags
			(gTheDoits delete: self)
			(self dispose:)
		)
	)
)

(instance oCarpenterSound of TPSound
	(properties)
)

(instance oCarpenterActionCuer of Code
	(properties)

	(method (doit)
		(if
			(or
				(< (oBackstageScrollPlane nCurPosX:) 577)
				(> (oBackstageScrollPlane nCurPosX:) 1687)
			)
			(if (Random 0 1)
				(= gtCarpenter toCarpenterHammer)
				(poCarpenter
					posn: 1529 231
					view: 50953
					setLoop: 0
					setCel: 0
					setPri: 231
					setScript: soHammering
					approachX: 1488
					approachY: 271
				)
				(voSaw init: addHotspotVerb: 1)
			else
				(= gtCarpenter toCarpenterSaw)
				(poCarpenter
					posn: 1282 244
					view: 50952
					setLoop: 0
					setCel: 0
					setPri: 265
					setScript: soSawing
					approachX: 1400
					approachY: 284
				)
				(voSaw dispose:)
			)
			(gTheDoits delete: self)
			(gTheDoits add: oCarpenterActionSeenCuer)
			(self dispose:)
		)
	)
)

(instance oCarpenterActionSeenCuer of Code
	(properties)

	(method (doit)
		(if (< 684 (oBackstageScrollPlane nCurPosX:) 1471)
			(gTheDoits delete: self)
			(gTheDoits add: oCarpenterActionCuer)
			(self dispose:)
		)
	)
)

(instance oAcrobatCuer of Code
	(properties)

	(method (doit)
		(if
			(and
				(or
					(< (oBackstageScrollPlane nCurPosX:) 1157)
					(> (oBackstageScrollPlane nCurPosX:) 2593)
				)
				(or (< (gEgo x:) 1787) (> (gEgo x:) 2593))
			)
			(poManAcrobat init:)
			(poGirlAcrobat init: setScript: soGirlHitsPillow)
			(gTheDoits delete: self)
			(gTheDoits add: oAcrobatsStartCuer)
			(self dispose:)
		)
	)
)

(instance oAcrobatsStartCuer of Code
	(properties)

	(method (doit)
		(if (<= 1961 (gEgo x:) 2416)
			(gEgo setMotion: 0)
			(gGame handsOff:)
			(= bAcrobatsTumbled 1)
			(poAcrobats init: setScript: soTumbleAct)
			(gTheDoits delete: self)
			(self dispose:)
		)
	)
)

(instance oAcrobatsVanishCuer of Code
	(properties)

	(method (doit)
		(if
			(and
				bAcrobatsTumbled
				(or
					(< (oBackstageScrollPlane nCurPosX:) 1157)
					(> (oBackstageScrollPlane nCurPosX:) 2593)
				)
				(or (< (gEgo x:) 1787) (> (gEgo x:) 2593))
			)
			(poAcrobats dispose:)
			(poManAcrobat dispose:)
			(poGirlAcrobat dispose:)
			(voAcrobatHead dispose:)
			((ScriptID 64017 0) set: 210) ; oFlags
			(gTheDoits delete: self)
			(self dispose:)
		)
	)
)

(instance oStageManagerCuer of Code
	(properties)

	(method (doit)
		(if
			(and
				((ScriptID 64017 0) test: 176) ; oFlags
				((ScriptID 64017 0) test: 167) ; oFlags
				((ScriptID 64017 0) test: 168) ; oFlags
				((ScriptID 64017 0) test: 169) ; oFlags
				((ScriptID 64017 0) test: 162) ; oFlags
			)
			(aoStageManager setScript: soStageManagerReady)
			(gTheDoits delete: self)
			(self dispose:)
		)
	)
)

(instance poRabbit of Prop
	(properties
		approachX 1859
		approachY 251
		x 1871
		y 195
		view 50943
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(ShortestWalk approachX approachY)
	)
)

(instance poArcher of Prop
	(properties
		x 1715
		y 294
		view 50944
	)

	(method (init)
		(super init: &rest)
		(self setScript: soArcherDrinks)
	)
)

(instance soArcherDrinks of TPScript
	(properties
		bKillRew 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poArcher setCel: 0)
				(= ticks (Random 120 360))
			)
			(1
				(poArcher setCycle: End self)
			)
			(2
				(= ticks (poArcher cycleSpeed:))
				(= state -1)
			)
		)
	)
)

(instance poRabbitQuits of Prop
	(properties
		case 1
		approachX 2031
		approachY 269
		x 1897
		y 199
		view 50915
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 57 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gCurRoom setScript: soTalkToRabbit)
			)
			(57 ; ioTopHat
				(gCurRoom setScript: soRabbitClimbsInHat)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poArcherLeaves of Prop
	(properties
		x 1725
		y 289
		view 50948
	)
)

(instance poArrowFlight of Prop
	(properties
		x 291
		y 269
		view 50914
		cycleSpeed 30
	)
)

(instance toRabbit of Talker
	(properties
		x 1897
		y 199
		view 50947
		priority 199
	)

	(method (init)
		(poRabbitQuits hide:)
		(super init: &rest)
	)

	(method (dispose)
		(poRabbitQuits show:)
		(super dispose: &rest)
	)
)

(instance toArcher of Talker
	(properties
		view 50946
		loop 1
	)

	(method (init)
		(poArcher hide:)
		(voArcher init:)
		(poRabbit setCel: 0 setCycle: 0)
		(= x (poArcher x:))
		(= y (poArcher y:))
		(= priority (+ 1 (poArcher priority:)))
		(super init: &rest)
	)

	(method (dispose)
		(poArcher show:)
		(voArcher dispose:)
		(super dispose: &rest)
	)
)

(instance voArcher of View
	(properties
		view 50946
	)

	(method (init)
		(= x (poArcher x:))
		(= y (poArcher y:))
		(super init: &rest)
	)
)

(instance toArcherAfterShot of Talker
	(properties
		view 50948
		loop 3
	)

	(method (init)
		(poArcherLeaves hide:)
		(voArcherAfterShot init:)
		(= x (poArcherLeaves x:))
		(= y (poArcherLeaves y:))
		(= priority (+ 1 (poArcher priority:)))
		(super init: &rest)
	)

	(method (dispose)
		(poArcherLeaves show:)
		(voArcherAfterShot dispose:)
		(super dispose: &rest)
	)
)

(instance voArcherAfterShot of View
	(properties
		view 50948
		loop 2
	)

	(method (init)
		(= x (poArcherLeaves x:))
		(= y (poArcherLeaves y:))
		(super init: &rest)
	)
)

(instance soArchery of TPScript
	(properties
		bHasFF 1
	)

	(method (ff)
		(oBackstageScrollPlane killPan: scrollTo: 1553 0)
		(poArcher dispose:)
		(goSound1 stop: setRelVol: 100)
		(poRabbit dispose:)
		(if (== (gCurRoom plane:) oArcheryCU)
			(gCurRoom deleteRoomPlane: oArcheryCU)
		)
		(poRabbitQuits dispose: init: setCel: (poRabbitQuits lastCel:))
		(poArcherLeaves dispose:)
		(poBowFalls dispose:)
		(= bSeenArchery 1)
		(voBow init:)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) 1700)
					(gEgo setMotion: PolyPath 1667 265 self)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo x:) 1700)
					(gEgo setHeading: 90 self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo bAutoScroll: 0)
				(oBackstageScrollPlane panTo: 1553 0 self)
			)
			(3
				(poArcher setScript: 0 setCycle: End self)
			)
			(4
				(= gtArcher toArcher)
				(gMessager say: 0 0 17 1 self) ; "(FOSTER BROOKS VOICE) Hold shtill. Itsh tough enough aimin' between the two of ya!"
			)
			(5
				(= gtArcher 0)
				(poArcher
					view: 50945
					setLoop: 0
					setCel: 0
					setCycle: CT 7 1 self
				)
			)
			(6
				(= ticks 180)
			)
			(7
				(poArcher setCycle: End self)
				(goSound1 playSound: 50904)
				(gMessager say: 0 0 17 2 self) ; "Oops."
			)
			(8)
			(9
				(poRabbit dispose:)
				(poArcher dispose:)
				(gCurRoom addRoomPlane: oArcheryCU)
				(poArrowFlight init:)
				(goSound1 fadeIn: 50905)
				(= ticks 60)
			)
			(10
				(poArrowFlight setCycle: End self)
				(= ticks 140)
			)
			(11
				(gMessager say: 0 0 17 3 self) ; "(SLOWED DOWN 16X FOR SLOW MOTION SOUNDFX) Oh, no!"
			)
			(12)
			(13
				(goSound1 playSound: 50906)
				(gCurRoom deleteRoomPlane: oArcheryCU)
				(poRabbitQuits init:)
				(poArcherLeaves init:)
				(= ticks 60)
			)
			(14
				(poRabbitQuits setCycle: End self)
			)
			(15
				(= gnRabbitTalker 2)
				(= gtArcher toArcherAfterShot)
				(gMessager sayRange: 0 0 17 4 7 self) ; "(NORMAL SPEED) That's it! THAT'S IT! I have had it! I QUIT!!"
			)
			(16
				(= gnRabbitTalker 0)
				(poRabbitQuits view: 50949 loop: 0 cel: 0)
				(goSound1 preload: 50915 50927)
				(poArcherLeaves setCycle: CT 9 1 self)
				(= gtArcher 0)
			)
			(17
				(= ticks (poArcherLeaves cycleSpeed:))
			)
			(18
				(poBowFalls setCel: 0 init: setCycle: End)
				(goSound1 playSound: 50927)
				(poArcherLeaves setCycle: End self)
			)
			(19
				(goSound1 playSound: 50915)
				(poArcherLeaves
					posn: 1697 289
					setLoop: 1
					setCel: 0
					setCycle: End
				)
				(gMessager say: 0 0 17 8 self) ; "(MUMBLING TO SELF AS YOU TURN AWAY FROM MIKE) I ssshoulda never fired his 15 sisters...."
			)
			(20
				(poArcherLeaves setCycle: End self)
			)
			(21
				(= bSeenArchery 1)
				(poArcherLeaves dispose:)
				(poBowFalls dispose:)
				(voBow init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTalkToRabbit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk 1815 259 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(2
				(= cycles 3)
			)
			(3
				((ScriptID 64017 0) set: 204) ; oFlags
				(poRabbitQuits dispose:)
				(gCurRoom addRoomPlane: oRabbitCU)
				(if
					(and
						(== (poRabbitQuits case:) 2)
						((ScriptID 64017 0) test: 205) ; oFlags
					)
					(poRabbitQuits case: 4)
				)
				(gMessager say: 0 1 (poRabbitQuits case:) 0 self 53100)
				(switch (poRabbitQuits case:)
					(1
						(poRabbitQuits case: 3)
					)
					(3
						(poRabbitQuits case: 5)
					)
					(5
						(poRabbitQuits case: 2)
					)
				)
			)
			(4
				(gCurRoom deleteRoomPlane: oRabbitCU)
				(poRabbitQuits
					view: 50942
					loop: 0
					cel: 0
					init:
					setScript: soUnhappyBunny
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poRabbitBlink of Prop
	(properties
		x 1897
		y 199
		view 50942
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
	)
)

(instance soUnhappyBunny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 1 200))
			)
			(1
				(if (Random 0 1)
					(self cue:)
				else
					(= state -1)
					(if (poRabbitQuits cel:)
						(poRabbitQuits setCycle: Beg self)
					else
						(poRabbitQuits setCycle: End self)
					)
				)
			)
			(2
				(poRabbitBlink
					setCel: 1
					cycleSpeed: (Random 2 6)
					init:
					setCycle: Beg self
				)
			)
			(3
				(= ticks (Random 1 20))
			)
			(4
				(poRabbitBlink setCycle: End self)
			)
			(5
				(= ticks (poRabbitBlink cycleSpeed:))
			)
			(6
				(poRabbitBlink dispose:)
				(= state -1)
				(self cue:)
			)
		)
	)

	(method (dispose)
		(poRabbitBlink dispose:)
		(super dispose: &rest)
	)
)

(instance voRabbitBody of View
	(properties
		x 285
		y 313
		view 50916
	)
)

(instance voRabbitMouth of View
	(properties
		x 285
		y 313
		view 50916
		loop 1
	)
)

(instance toRabbitCu of Talker
	(properties
		x 285
		y 313
		view 50916
		loop 1
		priority 400
	)

	(method (init)
		(voRabbitMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voRabbitMouth show:)
		(super dispose: &rest)
	)
)

(instance poTorinWithHat of Prop
	(properties
		x 2031
		y 269
		view 50950
	)
)

(instance poRabbitClimbsInHat of Prop
	(properties
		x 1880
		y 195
		view 50950
		loop 1
	)
)

(instance soRabbitClimbsInHat of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk 1815 259 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gGame handsOff:)
				((ScriptID 64017 0) set: 204) ; oFlags
				(gCurRoom addRoomPlane: oRabbitCU)
				(gMessager sayRange: 0 57 0 1 7 self 53100) ; "Hey, Bags! Take a look at this."
			)
			(4
				(gCurRoom deleteRoomPlane: oRabbitCU)
				(poRabbitQuits dispose:)
				(poRabbitQuits view: 50949 loop: 0 cel: 0 init:)
				(ShortestWalk
					(poRabbitQuits approachX:)
					(poRabbitQuits approachY:)
					self
				)
			)
			(5
				(gEgo setHeading: 315 self)
			)
			(6
				(= cycles 3)
			)
			(7
				(if (not (< 1483 (oBackstageScrollPlane nCurPosX:) 1755))
					(oBackstageScrollPlane panTo: 1640 0 self)
				else
					(self cue:)
				)
			)
			(8
				(gEgo hide:)
				(poTorinWithHat init: setCycle: End self)
			)
			(9
				(poRabbitQuits dispose:)
				(poRabbitClimbsInHat init: setCycle: End self)
				(goSound1 playSound: 50924)
			)
			(10
				(poRabbitClimbsInHat dispose:)
				(poTorinWithHat
					posn: 2037 265
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(11
				(poTorinWithHat dispose:)
				(gEgo put: ((ScriptID 64001 0) get: 47)) ; oInvHandler, ioTopHat
				(gEgo get: ((ScriptID 64001 0) get: 48)) ; oInvHandler, ioRabbit
				((ScriptID 64017 0) set: 164) ; oFlags
				(gEgo posn: 2037 265 setLoop: 7 stopwalk: show:)
				(gMessager sayRange: 0 57 0 8 12 self 53100) ; "(FROM INSIDE HAT) I love it. I love it! Oh, it's me! Oh, it's definitely ME!! Waddaya think?"
			)
			(12
				(if ((ScriptID 64017 0) test: 205) ; oFlags
					(gMessager sayRange: 0 57 0 13 14 self 53100) ; "Now, wait a minute. We don't know if Zippy the Magnificent will accept you or not."
				else
					(self cue:)
				)
			)
			(13
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voSaw of View
	(properties
		approachX 1241
		approachY 245
		x 1256
		y 238
		view 50955
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(if ((ScriptID 64017 0) test: 209) ; oFlags
					(gEgo setScript: soTakeSaw)
				else
					(gEgo setScript: soTakeSawAttempt)
				)
			)
		)
	)
)

(instance soTakeSaw of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk (voSaw approachX:) (voSaw approachY:) self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(3
				(voSaw dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 55)) ; oInvHandler, ioSaw
				((ScriptID 64017 0) set: 171) ; oFlags
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeSawAttempt of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk (voSaw approachX:) (voSaw approachY:) self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(poCarpenter setCycle: End self)
			)
			(3
				(poCarpenter setCel: 0)
				(gMessager say: 11 1 0 0 self) ; "Hey! Cut it out!"
			)
			(4
				(poCarpenter setCycle: Fwd)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voBoard of View
	(properties
		x 1348
		y 273
		view 50954
	)

	(method (init)
		(super init: &rest)
		(self setPri: 271)
	)
)

(instance poCarpenter of Prop
	(properties
		case 18
		approachX 1400
		approachY 284
		x 1304
		y 263
		view 50917
	)

	(method (init)
		(super init: &rest)
		(self setPri: 265 addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(gEgo setScript: soTalkToCarpenter)
	)
)

(instance toCarpenterSaw of Talker
	(properties
		x 1282
		y 244
		view 50930
		loop 1
		priority 266
	)

	(method (init)
		(poCarpenter hide:)
		(voCarpenterSawBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(poCarpenter show:)
		(voCarpenterSawBody dispose:)
		(super dispose: &rest)
	)
)

(instance voCarpenterSawBody of View
	(properties
		x 1282
		y 244
		view 50930
	)

	(method (init)
		(super init: &rest)
		(self setPri: 265)
	)
)

(instance toCarpenterHammer of Talker
	(properties
		x 1529
		y 231
		view 50931
		loop 1
		priority 232
	)

	(method (init)
		(poCarpenter hide:)
		(voCarpenterHammerBody init:)
		(super init: &rest)
	)

	(method (dispose)
		(poCarpenter show:)
		(voCarpenterHammerBody dispose:)
		(super dispose: &rest)
	)
)

(instance voCarpenterHammerBody of View
	(properties
		x 1529
		y 231
		view 50931
	)
)

(instance soTalkToCarpenter of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(poCarpenter approachX:)
					(poCarpenter approachY:)
					self
				)
			)
			(1
				(if (OneOf (poCarpenter script:) soSawing soCarpenterSaws)
					(gEgo setHeading: 315 self)
				else
					(gEgo setHeading: 45 self)
				)
			)
			(2
				(gGame handsOff:)
				(if (not bCarpenterDoneMeasuring)
					(= state 1)
					(= ticks 20)
				else
					(= oCarpenterScript (poCarpenter script:))
					(poCarpenter setScript: 0)
					(poCarpenter setCycle: End self)
				)
			)
			(3
				(= ticks (poCarpenter cycleSpeed:))
			)
			(4
				(oCarpenterSound stop:)
				(poCarpenter setCel: 0)
				(gMessager say: 1 1 (poCarpenter case:) 0 self)
			)
			(5
				(poCarpenter setScript: oCarpenterScript)
				(if (< (poCarpenter case:) 21)
					(poCarpenter case: (+ 1 (poCarpenter case:)))
				else
					((ScriptID 64017 0) set: 206) ; oFlags
					(CheckSawCondition)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCarpenterSaws of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< 684 (oBackstageScrollPlane nCurPosX:) 1316)
					(poCarpenter setCel: 0 setCycle: End self)
				else
					(= ticks 30)
					(= state -1)
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(if (< 684 (oBackstageScrollPlane nCurPosX:) 1316)
					(poCarpenter setCel: 0 setCycle: End self)
				else
					(= ticks 30)
					(= state -1)
				)
			)
			(3
				(= ticks 60)
			)
			(4
				(if (< 684 (oBackstageScrollPlane nCurPosX:) 1316)
					(voSaw dispose:)
					(poCarpenter
						posn: 1282 244
						view: 50951
						setLoop: 0
						setCel: 0
						setCycle: CT 2 1 self
					)
				else
					(= ticks 30)
					(= state -1)
				)
			)
			(5
				(= ticks (poCarpenter cycleSpeed:))
			)
			(6
				(voBoard dispose:)
				(poCarpenter setCel: 3 setCycle: End self)
			)
			(7
				(poCarpenter
					posn: 1282 244
					view: 50952
					setLoop: 0
					setCel: 0
					setScript: soSawing
				)
				(= bCarpenterDoneMeasuring 1)
				(= gtCarpenter toCarpenterSaw)
				(gTheDoits add: oCarpenterActionCuer)
				(self dispose:)
			)
		)
	)
)

(instance soSawing of Script
	(properties)

	(method (changeState newState &tmp nX nVol)
		(switch (= state newState)
			(0
				(if (< (= nX (Abs (- (gEgo x:) (poCarpenter x:)))) 400)
					(= nVol (/ (- 400 nX) 4))
					(oCarpenterSound setRelVol: nVol playSound: 50910)
				)
				(poCarpenter setCel: 0 setCycle: End self)
			)
			(1
				(= ticks (poCarpenter cycleSpeed:))
				(= state -1)
			)
		)
	)
)

(instance soHammering of Script
	(properties)

	(method (changeState newState &tmp nX nVol)
		(switch (= state newState)
			(0
				(poCarpenter setCel: 0 setCycle: CT 2 1 self)
			)
			(1
				(if (< (= nX (Abs (- (gEgo x:) (poCarpenter x:)))) 400)
					(= nVol (/ (- 400 nX) 4))
					(oCarpenterSound setRelVol: nVol playSound: 50901)
				)
				(poCarpenter setCycle: End self)
			)
			(2
				(= ticks (poCarpenter cycleSpeed:))
				(= state -1)
			)
		)
	)
)

(instance poGirlAcrobat of Prop
	(properties
		noun 8
		case 14
		x 2115
		y 305
		view 50956
	)

	(method (init)
		(super init: &rest)
		(self setPri: 320)
		(|= signal $1000)
	)

	(method (doVerb)
		(gEgo setScript: soTalkToAcrobat 0 self)
	)
)

(instance poDust of Prop
	(properties
		x 2115
		y 305
		view 50975
	)

	(method (init)
		(super init: &rest)
		(self setPri: 321)
	)
)

(instance soGirlHitsPillow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poGirlAcrobat setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(poDust init: setCel: 0 setCycle: End self)
			)
			(2
				(if bWaitingForDustToClear
					(soTumbleAct cue:)
				)
				(poDust dispose:)
				(= ticks (Random 120 240))
				(= state -1)
			)
		)
	)
)

(instance poManAcrobat of Prop
	(properties
		noun 8
		case 14
		x 2292
		y 296
		view 50957
	)

	(method (init)
		(super init: &rest)
		(self setPri: 320)
		(|= signal $1000)
	)

	(method (doVerb)
		(gEgo setScript: soTalkToAcrobat 0 self)
	)
)

(instance poAcrobats of Prop
	(properties
		noun 8
		case 14
		x 2293
		y 294
		view 50926
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
		(self setPri: 320)
		(|= signal $1000)
	)

	(method (doVerb)
		(gEgo setScript: soTalkToAcrobat 0 self)
	)
)

(instance voAcrobatHead of View
	(properties
		x 2293
		y 294
		view 50926
	)

	(method (init)
		(super init: &rest)
		(self setPri: 321)
		(self addHotspotVerb: 1)
		(|= signal $1000)
	)

	(method (doVerb)
		(poAcrobats doVerb: &rest)
	)
)

(instance toAcrobat of Talker
	(properties
		x 2293
		y 294
		view 50933
		priority 321
	)

	(method (init)
		(voAcrobatHead hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voAcrobatHead show:)
		(super dispose: &rest)
	)
)

(instance soTalkToAcrobat of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk 2161 235 self)
			)
			(1
				(Face gEgo poAcrobats self)
			)
			(2
				(gMessager say: (register noun:) 1 (register case:) 0 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance oAcrobatWhirl of TPSound
	(properties)
)

(instance soTumbleAct of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poAcrobats hide:)
				(gEgo face: poAcrobats self)
				(gEgo bAutoScroll: 0)
				(oBackstageScrollPlane panTo: 1809 0 self 2)
			)
			(1)
			(2
				(= bWaitingForDustToClear 1)
			)
			(3
				(poDust dispose:)
				(poGirlAcrobat
					view: 50918
					setLoop: 7
					setCel: 0
					posn: 2115 305
					setScript: 0
					setCycle: End self
				)
			)
			(4
				(voRosin init:)
				(poManAcrobat
					view: 50918
					setLoop: 1
					setCel: 0
					show:
					setCycle: End self
				)
				(poGirlAcrobat
					posn: 2151 306
					setLoop: 5
					setCel: 0
					setCycle: End self
				)
			)
			(5)
			(6
				(= ticks 60)
			)
			(7
				(poGirlAcrobat
					posn: 1972 313
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(8
				(poGirlAcrobat dispose:)
				(poManAcrobat
					posn: 2293 294
					setLoop: 3
					setCel: 0
					show:
					setCycle: End self
				)
				(oAcrobatWhirl playSound: 50921)
			)
			(9
				(poManAcrobat dispose:)
				(poAcrobats setCel: 0 show: setCycle: Fwd setScript: soAcrobats)
				(voAcrobatHead init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soAcrobats of Script
	(properties)

	(method (changeState newState &tmp nX nVol)
		(switch (= state newState)
			(0
				(= state -1)
				(if (< (= nX (Abs (- (gEgo x:) (poAcrobats x:)))) 400)
					(= nVol (/ (- 400 nX) 4))
					(oAcrobatWhirl setRelVol: nVol)
					(if (not bWhirlPlaying)
						(oAcrobatWhirl setAmbient: 50922)
						(= bWhirlPlaying 1)
					)
					(= ticks 1)
				else
					(oAcrobatWhirl setAmbient: 0)
					(= bWhirlPlaying 0)
					(= ticks 40)
				)
			)
		)
	)
)

(instance poArchivist of Prop
	(properties
		case 1
		approachX 2766
		approachY 258
		x 2916
		y 261
		view 50924
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 setPri: 200)
	)

	(method (doVerb)
		(if (== case 8)
			(gCurRoom setScript: soDontTalkToArchivist)
		else
			(gCurRoom setScript: soTalkToArchivist 0 0)
		)
	)
)

(instance soArchivist of Script
	(properties)

	(method (changeState newState &tmp n)
		(switch (= state newState)
			(0
				(cond
					((<= (= n (Random 0 4)) 1)
						(poArchivist setCel: 0 setCycle: CT 10 1 self)
					)
					((== n 2)
						(poArchivist setCel: 0 setCycle: CT 12 1 self)
					)
					((== n 3)
						(poArchivist setCel: 0 setCycle: CT 2 1)
						(= ticks (Random 120 180))
					)
					((== n 4)
						(poArchivist setCycle: End self)
						(= state -1)
					)
				)
			)
			(1
				(poArchivist setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance voArchivistCU of View
	(properties
		x 375
		y 298
		view 50959
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gCurRoom setScript: soTalkToArchivist 0 1)
	)
)

(instance voArchivistCUMouth of View
	(properties
		x 375
		y 298
		view 50959
		loop 5
	)

	(method (init)
		(self setPri: 348)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(gCurRoom setScript: soTalkToArchivist 0 1)
	)
)

(instance toArchivistCU of Talker
	(properties
		x 375
		y 298
		view 50959
		loop 5
		priority 348
	)

	(method (init)
		(voArchivistCUMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voArchivistCUMouth show:)
		(super dispose: &rest)
	)
)

(instance voTorinWithArchivistMouth of View
	(properties
		x 125
		y 362
		view 50960
		loop 1
	)

	(method (init)
		(self setPri: 363)
		(super init: &rest)
	)
)

(instance voTorinWithArchivistBody of View
	(properties
		x 125
		y 362
		view 50960
	)
)

(instance toTorinWithArchivist of Talker
	(properties
		x 125
		y 362
		view 50960
		loop 1
		priority 363
	)

	(method (init)
		(voTorinWithArchivistMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voTorinWithArchivistMouth show:)
		(super dispose: &rest)
	)
)

(instance poArchivistStandsUp of Prop
	(properties
		x 461
		y 266
		view 50961
	)
)

(instance voArchivistChairCU of View
	(properties
		x 461
		y 266
		view 50959
		loop 6
	)
)

(instance soDontTalkToArchivist of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(poArchivist approachX:)
					(poArchivist approachY:)
					self
				)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gMessager say: 0 1 8 0 self 53200) ; "He's busy...and I have exactly what I needed from him!"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soTalkToArchivist of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= state 4)
				)
				(self cue:)
			)
			(1
				(ShortestWalk
					(poArchivist approachX:)
					(poArchivist approachY:)
					self
				)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gGame handsOff:)
				((ScriptID 64017 0) set: 208) ; oFlags
				(if (== (poArchivist case:) 1)
					(gMessager sayRange: 0 1 1 1 4 self 53200) ; "(QUIETLY) Excuse me. I'm looking for someone and no one's been able to help me. I was just wondering..."
				else
					(self cue:)
				)
			)
			(4
				(gCurRoom addRoomPlane: oArchivistCU)
				(poArchivistStandsUp init: setCycle: End self)
				(voTorinWithArchivistBody init:)
				(voTorinWithArchivistMouth init:)
			)
			(5
				(poArchivistStandsUp dispose:)
				(voArchivistChairCU init:)
				(voArchivistCU init:)
				(voArchivistCUMouth init:)
				(gGame handsOff:)
				(switch (poArchivist case:)
					(1
						(gMessager say: 0 1 1 5 self 53200) ; "There. Now what was it you were saying?"
					)
					(5
						(self setScript: soRecordingSession self)
					)
					(else
						(gMessager say: 0 1 (poArchivist case:) 0 self 53200)
					)
				)
			)
			(6
				(switch (poArchivist case:)
					(1
						(poArchivist case: 6)
						(gGame handsOn:)
						(self dispose:)
					)
					(6
						(poArchivist case: 2)
						(gGame handsOn:)
						(self dispose:)
					)
					(2
						(poArchivist case: 3)
						(gGame handsOn:)
						(self dispose:)
					)
					(3
						(poArchivist case: 4)
						(gGame handsOn:)
						(self dispose:)
					)
					(4
						(poArchivist case: 5)
						(gGame handsOn:)
						(self dispose:)
					)
					(5
						(poArchivist case: 7)
						(gGame handsOn:)
						(self dispose:)
					)
					(7
						(poArchivist case: 8)
						(voArchivistChairCU dispose:)
						(voArchivistCU dispose:)
						(voArchivistCUMouth dispose:)
						(poArchivistStandsUp
							setCel: (poArchivistStandsUp lastCel:)
							init:
							setCycle: Beg self
						)
					)
					(else
						(voArchivistChairCU dispose:)
						(voArchivistCU dispose:)
						(voArchivistCUMouth dispose:)
						(poArchivistStandsUp
							setCel: (poArchivistStandsUp lastCel:)
							init:
							setCycle: Beg self
						)
					)
				)
			)
			(7
				(gCurRoom deleteRoomPlane: oArchivistCU)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLeaveArchivistCU of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(voArchivistChairCU dispose:)
				(voArchivistCU dispose:)
				(voArchivistCUMouth dispose:)
				(poArchivistStandsUp
					setCel: (poArchivistStandsUp lastCel:)
					init:
					setCycle: Beg self
				)
			)
			(1
				(gCurRoom deleteRoomPlane: oArchivistCU)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soRecordingSession of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 0 1 5 1 10 self 53200) ; "What if you had a voice rarer than Lycentia's?"
			)
			(1
				(gCurRoom deleteRoomPlane: oArchivistCU)
				(oBackstageScrollPlane scrollTo: 2553 0)
				(= gtArchivist toArchivistRecords)
				(poArchivist hide:)
				(poEjectCrystal init: setCycle: CT 11 1 self)
				(gEgo setHeading: 90 self)
			)
			(2)
			(3
				(poEjectCrystal setCycle: End self)
				(goSound1 playSound: 50928)
			)
			(4
				(poEjectCrystal dispose:)
				(voArchivistRecordsBody init:)
				(voArchivistRecordsMouth init:)
				(gMessager say: 0 1 5 11 self 53200) ; "There. Ready when you are."
			)
			(5
				(goSound1 preload: 50918)
				(gMessager say: 0 0 9 1 self 53200) ; "Test. Test. Is this on?"
			)
			(6
				(poTorinRecords init: setCycle: CT 4 1 self)
				(gEgo hide:)
			)
			(7
				(goSound1 playSound: 50918)
				(poTorinRecords setCycle: End self)
			)
			(8
				(poTorinRecords hide:)
				(voTorinRecordsBody init:)
				(voTorinRecordsMouth init:)
				(= gtTorin toTorinRecords)
				(gMessager say: 0 0 9 2 self 53200) ; "Hello?"
			)
			(9
				(gMessager say: 0 1 5 12 self 53200) ; "My name is Torin. From the Fahrmann Valley. Near Crystal City. In The Lands Above. I've traveled through Escarpa, Pergola, and Asthenia to get to Tenebrous for only one reason: to find the evil sorceress Lycentia, force her to free my parents and my friend Boogle, and in the process teach her a lesson."
			)
			(10
				(poTorinRecords show: setCycle: Beg self)
				(voTorinRecordsBody dispose:)
				(voTorinRecordsMouth dispose:)
				(gMessager say: 0 1 5 13 self 53200) ; "That's enough. It's only a ten-meg crystal! Great. Now, let me find that audcryst with her voice."
			)
			(11)
			(12
				(poTorinRecords dispose:)
				(voArchivistRecordsBody dispose:)
				(voArchivistRecordsMouth dispose:)
				(gEgo show:)
				(poArchivistGivesCorder
					view: 50962
					loop: 2
					cel: 0
					init:
					setCycle: CT 13 1 self
				)
			)
			(13
				(poArchivistGivesCorder loop: 8 cel: 0 setCycle: End self)
			)
			(14
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(15
				(poArchivistGivesCorder loop: 9 cel: 0)
				(gEgo get: ((ScriptID 64001 0) get: 53)) ; oInvHandler, ioAudcryst
				((ScriptID 64017 0) set: 169) ; oFlags
			)
			(16
				(= gtArchivist 0)
				(gMessager say: 0 1 5 14 self 53200) ; "And here: I'll even throw in this old crystcorder so you can play it back."
				(poArchivistGivesCorder setCycle: End self)
			)
			(17)
			(18
				(= ticks (poArchivistGivesCorder cycleSpeed:))
			)
			(19
				(poArchivistGivesCorder loop: 2 cel: 13 setCycle: CT 15 1 self)
				(gEgo setHeading: 135 self)
			)
			(20)
			(21
				(voArchivistChair init:)
				(poArchivistGivesCorder setCycle: End self)
			)
			(22
				(gEgo hide:)
				(poTorinTakesCorder init: setCycle: CT 2 1 self)
			)
			(23
				(poArchivistGivesCorder loop: 11 cel: 0)
				(= ticks (poTorinTakesCorder cycleSpeed:))
			)
			(24
				(gEgo get: ((ScriptID 64001 0) get: 52)) ; oInvHandler, ioCrystcorder
				((ScriptID 64017 0) set: 168) ; oFlags
				(CheckSawCondition)
				(poTorinTakesCorder setCycle: End self)
			)
			(25
				(poTorinTakesCorder dispose:)
				(poArchivistGivesCorder dispose:)
				(voArchivistChair dispose:)
				(gEgo show:)
				(poArchivist show:)
				(gCurRoom addRoomPlane: oArchivistCU)
				(voTorinWithArchivistBody init:)
				(voTorinWithArchivistMouth init:)
				(voArchivistChairCU init:)
				(voArchivistCU init:)
				(voArchivistCUMouth init:)
				(self dispose:)
			)
		)
	)
)

(instance poEjectCrystal of Prop
	(properties
		x 2916
		y 257
		view 50925
	)
)

(instance poTorinRecords of Prop
	(properties
		x 2766
		y 258
		view 50925
		loop 1
	)

	(method (init)
		(self setScalePercent: 92)
		(super init: &rest)
	)
)

(instance voArchivistRecordsBody of View
	(properties
		x 2916
		y 257
		view 50925
		loop 4
	)
)

(instance voArchivistRecordsMouth of View
	(properties
		x 2916
		y 257
		view 50925
		loop 5
	)

	(method (init)
		(super init: &rest)
		(self setPri: 258)
	)
)

(instance toArchivistRecords of Talker
	(properties
		x 2916
		y 257
		view 50925
		loop 5
		priority 258
	)

	(method (init)
		(voArchivistRecordsMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voArchivistRecordsMouth show:)
		(super dispose: &rest)
	)
)

(instance voTorinRecordsBody of View
	(properties
		x 2766
		y 258
		view 50925
		loop 6
	)

	(method (init)
		(self setScalePercent: 92)
		(super init: &rest)
	)
)

(instance poTorinRecordsMouth of Prop
	(properties
		x 2766
		y 258
		view 50925
		loop 7
	)

	(method (init)
		(self setScalePercent: 92)
		(super init: &rest)
		(self setPri: 262)
	)
)

(instance voTorinRecordsMouth of View
	(properties
		x 2766
		y 258
		view 50925
		loop 7
	)

	(method (init)
		(self setScalePercent: 92)
		(super init: &rest)
		(self setPri: 262)
	)
)

(instance toTorinRecords of Talker
	(properties
		x 2766
		y 258
		view 50925
		loop 7
		priority 259
	)

	(method (init)
		(voTorinRecordsMouth hide:)
		(= mouth poTorinRecordsMouth)
		(super init: &rest)
	)

	(method (dispose)
		(voTorinRecordsMouth show:)
		(super dispose: &rest)
	)
)

(instance poArchivistGivesCorder of Prop
	(properties
		x 2916
		y 257
		view 50962
		loop 2
	)
)

(instance poTorinTakesCorder of Prop
	(properties
		x 2736
		y 261
		view 50962
		loop 3
	)

	(method (init)
		(self setScalePercent: 92)
		(super init: &rest)
		(self setPri: 270)
	)
)

(instance voArchivistChair of View
	(properties
		x 2916
		y 257
		view 50962
		loop 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 250)
	)
)

(instance poMagicianBody of Prop
	(properties
		x 293
		y 245
		view 50919
		loop 11
		cel 2
	)
)

(instance voMagicianMouth of View
	(properties
		x 328
		y 245
		view 50919
		loop 9
	)

	(method (init)
		(super init: &rest)
		(self setPri: 246)
	)
)

(instance toMagician of Talker
	(properties
		x 328
		y 245
		view 50919
		loop 9
		priority 246
	)

	(method (init)
		(voMagicianMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voMagicianMouth show:)
		(super dispose: &rest)
	)
)

(instance voFumbleHead of View
	(properties
		view 50937
	)

	(method (init)
		(= x (poMagicianBody x:))
		(= y (poMagicianBody y:))
		(super init: &rest)
		(self setPri: 243)
	)
)

(instance toMagicianLS of Talker
	(properties
		view 50940
		loop 5
	)

	(method (init)
		(= x (poMagician x:))
		(= y (poMagician y:))
		(= priority (- (poMagician priority:) 1))
		(voMagicianMouthLS hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voMagicianMouthLS show:)
		(super dispose: &rest)
	)
)

(instance voMagicianMouthLS of View
	(properties
		view 50940
		loop 5
	)

	(method (init)
		(= x (poMagician x:))
		(= y (poMagician y:))
		(super init: &rest)
		(self setPri: (- (poMagician priority:) 1))
	)
)

(instance poMagicianShufflesCards of Prop
	(properties
		x 293
		y 245
		view 50963
	)
)

(instance voCards of View
	(properties
		x 2540
		y 198
		view 50969
		loop 10
	)

	(method (init)
		(super init: &rest)
		(self setPri: 246)
	)
)

(instance poMagician of Prop
	(properties
		approachX 2569
		approachY 259
		x 2520
		y 200
		view 50941
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 setPri: 246)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(cond
					(
						(and
							((ScriptID 64017 0) test: 200) ; oFlags
							(not ((ScriptID 64017 0) test: 201)) ; oFlags
						)
						(= case 4)
						(gCurRoom setScript: soTalkToZippy 0 theVerb)
					)
					(
						(and
							((ScriptID 64017 0) test: 200) ; oFlags
							((ScriptID 64017 0) test: 201) ; oFlags
							(not ((ScriptID 64017 0) test: 202)) ; oFlags
						)
						(= case 3)
						(gCurRoom setScript: soTalkToZippy 0 theVerb)
					)
					(((ScriptID 64017 0) test: 205) ; oFlags
						(= case 7)
						(gCurRoom setScript: soTalkToZippy 0 theVerb)
					)
					(else
						(gCurRoom setScript: soMagicTrick)
					)
				)
			)
			(56 ; ioSilkHanky
				(if ((ScriptID 64017 0) test: 200) ; oFlags
					(= case 5)
				else
					(= case 2)
				)
				(gEgo setScript: soGiveKerchiefToZippy)
			)
			(58 ; ioRabbit
				(gEgo setScript: soGiveRabbitToZippy)
			)
			(57 ; ioTopHat
				(= case 0)
				(gEgo setScript: soTalkToZippy 0 theVerb)
			)
			(59 ; ioCane
				(gEgo setScript: soGiveCaneToZippy)
			)
			(60 ; ioWand
				(if ((ScriptID 64017 0) test: 200) ; oFlags
					(gEgo setScript: soGiveWandToZippy)
				else
					(= case 2)
					(gEgo setScript: soTalkToZippy 0 theVerb)
				)
			)
		)
	)
)

(instance soTalkToZippy of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame handsOff:)
				(if (not gtZippy)
					(gCurRoom addRoomPlane: oMagicianCU)
					(poTorinTakesCards init:)
					(poMagicianBody init:)
					(voMagicianMouth init:)
				)
				(gMessager say: 0 register (poMagician case:) 0 self 53000)
			)
			(4
				(if (not gtZippy)
					(gCurRoom deleteRoomPlane: oMagicianCU)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGiveCaneToZippy of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame handsOff:)
				(= gtZippy toMagicianLS)
				(gMessager sayRange: 0 59 0 1 2 self 53000) ; "Here, Zippy. Could you use this in your magic act?"
			)
			(4
				(ShortestWalk 2513 268 self)
			)
			(5
				(gEgo setHeading: 0 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(8
				(gMessager say: 0 59 0 3 self 53000) ; "Hey, what are you trying to pull here? This is no magic wand!"
			)
			(9)
			(10
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(11
				(gEgo setHeading: 315 self)
			)
			(12
				(= cycles 2)
			)
			(13
				(gMessager sayRange: 0 59 0 4 5 self 53000) ; "I know that."
			)
			(14
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soMagicTrick of TPScript
	(properties)

	(method (init)
		(= bHasFF 0)
		(super init: &rest)
	)

	(method (ff)
		((ScriptID 64017 0) set: 205) ; oFlags
		(if (== (gCurRoom plane:) oMagicianCU)
			(gCurRoom deleteRoomPlane: oMagicianCU)
		)
		(goSound1 stop:)
		(= gtTorin 0)
		(gEgo show:)
		(poMagician dispose:)
		(poMagician view: 50940 loop: 4 init:)
		(voMagicianMouthLS init:)
		(poTorinReturnsCards dispose:)
		(voCards init:)
		(poMagician addHotspotVerb: 56 58 57 60 59)
		(poTorinTakesCards view: 50973 loop: 0 cel: 0)
		(poMagicianBody view: 50919 loop: 11 cel: 0)
		(voMagicianMouth view: 50919 loop: 8 cel: 0 x: 293 setPri: 246)
		(toMagician view: 50919 loop: 8 cel: 0 x: 293 priority: 246)
		(gGame handsOn:)
		(self dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame handsOff:)
				(= bHasFF 1)
				(self setButtons:)
				((ScriptID 64017 0) set: 205) ; oFlags
				(poMagician dispose:)
				(gCurRoom addRoomPlane: oMagicianCU)
				(poTorinTakesCards init:)
				(poMagicianBody init:)
				(voMagicianMouth init:)
				(gMessager say: 0 1 1 1 self 53000) ; "Excuse me. Are you a magician?"
			)
			(4
				(gMessager sayRange: 0 1 1 2 3 self 53000) ; "Who? Where? Oh, me? Yes. Actually, I'm a magician. Well, no. I'm not just ANY magician. As of yesterday morning, I'm "Zippy the Magnificent!" And who are you?"
				(poMagicianBody setCycle: Beg)
			)
			(5
				(gMessager sayRange: 0 1 1 4 5 self 53000) ; "Well, Torin. Would you like to see a trick?"
				(poMagicianBody setCycle: End)
			)
			(6
				(gMessager say: 0 1 1 6 self 53000) ; "Splendid. All right. Here. Take this deck of cards."
				(poMagicianBody setCycle: End self)
			)
			(7)
			(8
				(poMagicianBody hide:)
				(voMagicianMouth hide:)
				(poMagicianShufflesCards init: setCycle: CT 21 1 self)
				(goSound1 playSound: 53003)
			)
			(9
				(poTorinTakesCards
					view: 50929
					loop: 0
					cel: 0
					setCycle: CT 6 1 self
				)
			)
			(10
				(= ticks (poTorinTakesCards cycleSpeed:))
			)
			(11
				(poMagicianShufflesCards setCycle: End self)
				(poTorinTakesCards setCycle: End self)
			)
			(12)
			(13
				(poTorinTakesCards view: 50974 loop: 0 cel: 0)
				(= gtTorin toTorinWithCards)
				(poMagicianShufflesCards dispose:)
				(voMagicianMouth loop: 8 cel: 0 x: 293 show:)
				(toMagician x: 293 loop: 8)
				(poMagicianBody cel: 0 show:)
				(gMessager sayRange: 0 1 1 7 9 self 53000) ; "Cut it anywhere."
			)
			(14
				(gMessager sayRange: 0 1 1 10 13 self 53000) ; "Good."
				(poMagicianBody setCycle: End)
			)
			(15
				(gMessager sayRange: 0 1 1 14 15 self 53000) ; "Now, if I could make your card appear from my sleeve, in spite of the fact that you're still holding that self same card in your very own hands...would you be impressed?"
				(poMagicianBody setCycle: Beg self)
			)
			(16)
			(17
				(voMagicianMouth hide:)
				(poMagicianBody view: 50964 setLoop: 0 setCycle: End self)
			)
			(18
				(= ticks (poMagicianBody cycleSpeed:))
			)
			(19
				(voMagicianMouth view: 50937 loop: 1 cel: 0 setPri: 244 show:)
				(toMagician view: 50937 loop: 1 cel: 0 priority: 244)
				(poMagicianBody
					view: 50937
					setLoop: 2
					setCel: 0
					setCycle: Blink 100
				)
				(voFumbleHead init:)
				(gMessager say: 0 1 1 16 self 53000) ; "(WHILE FUMBLING UP HIS SLEEVE) All I have to do is say the magic words, "Ali McGraw!" and, PRESTO!"
			)
			(20
				(poMagicianBody setCycle: End self)
			)
			(21
				(goSound1 playSound: 53001)
				(voFumbleHead dispose:)
				(poMagicianBody hide:)
				(voMagicianMouth hide:)
				(poPullsOutBouquet init: setCel: 0 setCycle: CT 6 1 self)
			)
			(22
				(poPullsOutBouquet hide:)
				(poMagicianBody view: 50936 loop: 0 cel: 0 show:)
				(voMagicianMouth view: 50936 loop: 1 cel: 0 setPri: 246 show:)
				(toMagician view: 50936 loop: 1 cel: 0 priority: 246)
				(gMessager sayRange: 0 1 1 17 19 self 53000) ; "Here's your card."
			)
			(23
				(poMagicianBody hide:)
				(voMagicianMouth hide:)
				(poPullsOutBouquet show: setCycle: CT 20 1 self)
			)
			(24
				(goSound1 playSound: 53002)
				(poPullsOutBouquet setCycle: End self)
			)
			(25
				(poPullsOutBouquet dispose:)
				(poMagicianBody
					view: 50964
					loop: 0
					cel: 2
					show:
					setCycle: Beg self
				)
			)
			(26
				(voMagicianMouth view: 50919 loop: 8 cel: 0 setPri: 246 show:)
				(toMagician view: 50919 loop: 8 cel: 0 priority: 246)
				(poMagicianBody view: 50919 loop: 11 cel: 0)
				(gMessager sayRange: 0 1 1 20 22 self 53000) ; "Okay. Now, let's see. Where was I? Oh, yes."
			)
			(27
				(voMagicianMouth hide:)
				(poMagicianBody view: 50964 setLoop: 0 setCycle: End self)
			)
			(28
				(= ticks (poMagicianBody cycleSpeed:))
			)
			(29
				(voMagicianMouth view: 50937 loop: 1 cel: 0 setPri: 244 show:)
				(toMagician view: 50937 loop: 1 cel: 0 priority: 244)
				(poMagicianBody
					view: 50937
					setLoop: 2
					setCel: 0
					setCycle: Blink 100
				)
				(voFumbleHead init:)
				(gMessager say: 0 1 1 23 self 53000) ; "(FUMBLING UP SLEEVE) And...here...it is...right....HERE!"
			)
			(30
				(poMagicianBody setCycle: End self)
			)
			(31
				(goSound1 playSound: 53001)
				(poMagicianBody hide:)
				(voMagicianMouth hide:)
				(voFumbleHead dispose:)
				(poPullsOutDove init: setCel: 0 setCycle: CT 2 1 self)
			)
			(32
				(poPullsOutDove hide:)
				(poMagicianBody view: 50935 loop: 0 cel: 0 show:)
				(voMagicianMouth view: 50935 loop: 1 cel: 0 setPri: 246 show:)
				(toMagician view: 50935 loop: 1 cel: 0 priority: 246)
				(gMessager sayRange: 0 1 1 24 27 self 53000) ; "No. That's not my card either."
			)
			(33
				(goSound1 playSound: 53004)
				(poPullsOutDove show: setCycle: End self)
				(poDoveFlysAway setCel: 0 init: setCycle: End self)
				(poMagicianBody hide:)
				(voMagicianMouth hide:)
			)
			(34)
			(35
				(poPullsOutDove dispose:)
				(poDoveFlysAway dispose:)
				(poMagicianBody
					view: 50937
					loop: 2
					cel: 1
					show:
					setCycle: Blink 100
				)
				(voMagicianMouth view: 50937 loop: 1 cel: 0 setPri: 244 show:)
				(toMagician view: 50937 loop: 1 cel: 0 priority: 244)
				(voFumbleHead init:)
				(gMessager say: 0 1 1 28 self 53000) ; "(TO SELF) Oh, do I need a better act! (TO TORIN) Okay, is THIS your card?"
			)
			(36
				(poMagicianBody setCycle: End self)
			)
			(37
				(goSound1 playSound: 53001)
				(poMagicianBody hide:)
				(voMagicianMouth hide:)
				(voFumbleHead dispose:)
				(poPullsOutBook setCel: 0 init: setCycle: CT 2 1 self)
			)
			(38
				(poPullsOutBook hide:)
				(poMagicianBody view: 50934 loop: 0 cel: 0 show:)
				(voMagicianMouth view: 50934 loop: 1 cel: 0 setPri: 246 show:)
				(toMagician view: 50934 loop: 1 cel: 0 priority: 246)
				(gMessager sayRange: 0 1 1 29 31 self 53000) ; "No. That's a book."
			)
			(39
				(goSound1 playSound: 53002)
				(poMagicianBody hide:)
				(voMagicianMouth hide:)
				(poPullsOutBook show: setCycle: End self)
			)
			(40
				(= ticks (poPullsOutBook cycleSpeed:))
			)
			(41
				(poPullsOutBook dispose:)
				(poMagicianBody view: 50919 loop: 11 cel: 0 show:)
				(voMagicianMouth view: 50919 loop: 8 cel: 0 setPri: 246 show:)
				(toMagician view: 50919 loop: 8 cel: 0 priority: 246)
				(gMessager sayRange: 0 1 1 32 33 self 53000) ; "All right, then. Give me back my cards! You can keep your lousy two of diamonds!"
			)
			(42
				(poMagicianBody setCycle: End)
				(gMessager say: 0 1 1 34 self 53000) ; "It's too late now to sweet talk me. (DISGUSTED) If only I had one good trick!"
			)
			(43
				(gCurRoom deleteRoomPlane: oMagicianCU)
				(= gtTorin 0)
				(gEgo hide:)
				(poMagician view: 50940 loop: 4 init:)
				(voMagicianMouthLS init:)
				(poTorinTakesCards view: 50973 loop: 0 cel: 0)
				(poTorinReturnsCards init: setCycle: End self)
			)
			(44
				(poTorinReturnsCards dispose:)
				(voCards init:)
				(gEgo show:)
				(poMagician addHotspotVerb: 56 58 57 60 59)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTorinTakesCards of Prop
	(properties
		x 460
		y 313
		view 50973
	)
)

(instance toTorinWithCards of Talker
	(properties
		x 460
		y 313
		view 50971
		priority 314
	)
)

(instance poPullsOutBouquet of Prop
	(properties
		x 293
		y 245
		view 50965
	)
)

(instance poPullsOutDove of Prop
	(properties
		x 293
		y 245
		view 50966
	)
)

(instance poDoveFlysAway of Prop
	(properties
		x 293
		y 245
		view 50967
	)
)

(instance poPullsOutBook of Prop
	(properties
		x 293
		y 245
		view 50968
	)
)

(instance poTorinReturnsCards of Prop
	(properties
		x 2571
		y 261
		view 50972
	)
)

(instance soGiveRabbitToZippy of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame handsOff:)
				(= gtZippy toMagicianLS)
				(gMessager sayRange: 0 72 0 1 3 self 53000) ; "You'll never guess what I've got for you, Zippy."
			)
			(4
				(ShortestWalk 2513 268 self)
			)
			(5
				(gEgo setHeading: 0 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(8
				(gEgo put: ((ScriptID 64001 0) get: 48)) ; oInvHandler, ioRabbit
				((ScriptID 64017 0) set: 200) ; oFlags
				(poMagician view: 50940 setCel: 0)
				(if ((ScriptID 64017 0) test: 202) ; oFlags
					(poMagician loop: 0)
				else
					(poMagician loop: 2)
				)
			)
			(9
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(10
				(gEgo setHeading: 315 self)
			)
			(11
				(gMessager sayRange: 0 72 0 4 14 self 53000) ; "Let me see."
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGiveWandToZippy of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame handsOff:)
				(= gtZippy toMagicianLS)
				(gMessager say: 0 60 0 1 self 53000) ; "Here ya go, Zippy. I found your wand."
			)
			(4
				(ShortestWalk 2513 268 self)
			)
			(5
				(gEgo setHeading: 0 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(8
				(gEgo put: ((ScriptID 64001 0) get: 50)) ; oInvHandler, ioWand
				((ScriptID 64017 0) set: 201) ; oFlags
				(poMagician view: 50940 cel: 0)
				(if ((ScriptID 64017 0) test: 202) ; oFlags
					(poMagician loop: 3)
				else
					(poMagician loop: 1)
				)
			)
			(9
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(10
				(gEgo setHeading: 315 self)
			)
			(11
				(gMessager sayRange: 0 60 0 2 7 self 53000) ; "Oh, thank you, Torin. (PAUSE) Say, this isn't my wand! What are you trying to pull here?"
			)
			(12
				(if ((ScriptID 64017 0) test: 202) ; oFlags
					(self setScript: soMagicianGivesBook self)
				else
					(gMessager say: 0 60 3 0 self 53000) ; "Uh, well, now. That's another problem."
				)
			)
			(13
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGiveKerchiefToZippy of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame handsOff:)
				(= gtZippy toMagicianLS)
				(gMessager say: 0 56 (poMagician case:) 1 self 53000)
			)
			(4
				(ShortestWalk 2513 268 self)
			)
			(5
				(gEgo setHeading: 0 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(8
				(gEgo put: ((ScriptID 64001 0) get: 58)) ; oInvHandler, ioSilkHanky
				((ScriptID 64017 0) set: 202) ; oFlags
				(poMagician view: 50940 setCel: 0)
				(cond
					(
						(and
							((ScriptID 64017 0) test: 200) ; oFlags
							((ScriptID 64017 0) test: 201) ; oFlags
						)
						(poMagician loop: 3)
					)
					(((ScriptID 64017 0) test: 200) ; oFlags
						(poMagician loop: 0)
					)
					(else
						(poMagician loop: 4)
					)
				)
			)
			(9
				(ShortestWalk
					(poMagician approachX:)
					(poMagician approachY:)
					self
				)
			)
			(10
				(gEgo setHeading: 315 self)
			)
			(11
				(if (== (poMagician case:) 5)
					(gMessager sayRange: 0 56 5 2 3 self 53000) ; "Why, thank you. It feels lovely. So smooth. I just don't know what I'll do with it. Perhaps stuff it in my breast pocket. I don't know."
				else
					(gMessager sayRange: 0 56 2 2 6 self 53000) ; "Why, thank you, Torin. A magician can never have too many silks."
				)
			)
			(12
				(if
					(and
						(== (poMagician case:) 5)
						((ScriptID 64017 0) test: 201) ; oFlags
					)
					(gMessager sayRange: 0 56 5 4 6 self 53000) ; "That's good, too."
				else
					(self cue:)
				)
			)
			(13
				(if
					(and
						(== (poMagician case:) 5)
						((ScriptID 64017 0) test: 201) ; oFlags
					)
					(self setScript: soMagicianGivesBook self)
				else
					(self cue:)
				)
			)
			(14
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soMagicianGivesBook of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager sayRange: 0 0 6 1 2 self 53000) ; "All right, I will. Thanks to you, Torin! You know, you've been so nice to me...would you like this book of magic spells? It should get you past any sorcerers you find in these parts!"
			)
			(1
				(poMagician dispose:)
				(voMagicianMouthLS dispose:)
				(gEgo hide:)
				(poMagicianGivesBook init: setCycle: CT 4 1 self)
				(poTorinGetsBook init: setCycle: CT 1 1)
			)
			(2
				(= ticks (poMagicianGivesBook cycleSpeed:))
			)
			(3
				(poMagicianGivesBook setCel: 5 setCycle: End self)
				(poTorinGetsBook setCel: 2 setCycle: End self)
				(gEgo get: ((ScriptID 64001 0) get: 51)) ; oInvHandler, ioMagicBook
				((ScriptID 64017 0) set: 167) ; oFlags
				(CheckRosinCondition)
			)
			(4)
			(5
				(gMessager say: 0 0 6 3 self 53000) ; "Thanks, Zippy. And good luck with your act!"
			)
			(6
				(gEgo show:)
				(poTorinGetsBook dispose:)
				(poMagicianGivesBook dispose:)
				(poHappyMagician init: setScript: soHappyMagician)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poMagicianGivesBook of Prop
	(properties
		x 2520
		y 200
		view 50920
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: (poMagician priority:))
	)
)

(instance poTorinGetsBook of Prop
	(properties
		x 2574
		y 250
		view 50920
		loop 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: (poMagician priority:))
	)
)

(instance poHappyMagician of Prop
	(properties
		x 2511
		y 212
		view 50970
	)

	(method (init)
		(super init: &rest)
		(self setPri: 246)
	)
)

(instance soHappyMagician of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poHappyMagician setCel: 0 setCycle: End self)
			)
			(1
				(= ticks (poHappyMagician cycleSpeed:))
			)
			(2
				(poHappyMagician setCel: 0)
				(= state -1)
				(= ticks (Random 300 1200))
			)
		)
	)
)

(instance aoStageManager of Actor
	(properties
		case 9
		x 765
		y 268
		view 50921
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self
			setStep: 5 -1
			ignoreActors: 0
			addHotspotVerb: 1
			setScript: soStageManagerPaces
		)
	)

	(method (doVerb)
		(gEgo setScript: soTalkToStageManager)
		(self setScript: soStageManagerStopsToTalk)
	)
)

(instance soStageManagerPaces of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= bStageManagerStopped 0)
				(oClearThroat stop:)
				(aoStageManager view: 50921 setLoop: bStageManagerFacingRight 1 setCycle: Walk)
				(if bStageManagerFacingRight
					(aoStageManager setMotion: PolyPath 1151 257 self)
				else
					(aoStageManager setMotion: PolyPath 765 268 self)
				)
			)
			(1
				(= bStageManagerFacingRight (- 1 bStageManagerFacingRight))
				(aoStageManager setScript: self)
			)
		)
	)
)

(instance soStageManagerReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aoStageManager deleteHotspotVerb: 1)
				(soStageActs dispose:)
				(= ticks 300)
			)
			(1
				(foLeftCurtain init:)
				(foRightCurtain init:)
				(aoStageManager
					view: 50958
					setMotion: 0
					setLoop: (+ 2 bStageManagerFacingRight) 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(= ticks (aoStageManager cycleSpeed:))
				(oClearThroat playSound: 50917)
			)
			(3
				(aoStageManager setCycle: End self)
			)
			(4
				(gMessager say: 0 0 1 0 self) ; "Mr. Torin. One minute, Mr. Torin. Mr. Torin. On stage in one minute, Mr. Torin."
			)
			(5
				(= seconds 30)
			)
			(6
				(-= state 2)
				(gMessager say: 0 0 8 0 self) ; "Mr. Torin. On stage, Mr. Torin. Now, Mr. Torin!"
			)
		)
	)
)

(instance oClearThroat of TPSound
	(properties)
)

(instance soStageManagerStopsToTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aoStageManager
					view: 50958
					setMotion: 0
					setLoop: (+ 2 bStageManagerFacingRight) 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				(= ticks (aoStageManager cycleSpeed:))
				(oClearThroat playSound: 50917)
			)
			(2
				(aoStageManager setCycle: End self)
			)
			(3
				(= bStageManagerStopped 1)
			)
		)
	)
)

(instance soTalkToStageManager of TPScript
	(properties)

	(method (dispose)
		(aoStageManager setScript: soStageManagerPaces)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (<= 0 (- (gEgo x:) (aoStageManager x:)) 1580)
					(= bStageManagerFacingRight 1)
				else
					(= bStageManagerFacingRight 0)
				)
				(if bStageManagerFacingRight
					(ShortestWalk
						(+ (aoStageManager x:) 100)
						(aoStageManager y:)
						self
					)
				else
					(ShortestWalk
						(- (aoStageManager x:) 100)
						(aoStageManager y:)
						self
					)
				)
			)
			(1
				(if bStageManagerFacingRight
					(gEgo setHeading: 270 self)
				else
					(gEgo setHeading: 90 self)
				)
			)
			(2
				(if bStageManagerStopped
					(self cue:)
				else
					(= cycles 2)
					(-- state)
				)
			)
			(3
				(if (gMessager bActive:)
					(= cycles 2)
					(-- state)
				else
					(self cue:)
				)
			)
			(4
				(gGame handsOff:)
				(gMessager say: 3 1 (aoStageManager case:) 0 self)
			)
			(5
				(switch (aoStageManager case:)
					(9
						(aoStageManager case: 10)
					)
					(10
						(aoStageManager case: 11)
						(gTheDoits add: oStageManagerCuer)
						((ScriptID 64017 0) set: 207) ; oFlags
					)
					(11
						(aoStageManager case: 12)
					)
					(12
						(aoStageManager case: 13)
					)
					(13
						(aoStageManager case: 22)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voStageManagerBody of View
	(properties
		view 50958
		loop 4
	)

	(method (init)
		(= x (aoStageManager x:))
		(= y (aoStageManager y:))
		(= loop (+ 4 bStageManagerFacingRight))
		(super init: &rest)
	)
)

(instance toStageManager of Talker
	(properties
		view 50958
		loop 6
		priority 269
	)

	(method (init)
		(= x (aoStageManager x:))
		(= y (aoStageManager y:))
		(= loop (+ 6 bStageManagerFacingRight))
		(aoStageManager hide:)
		(voStageManagerBody init:)
		(= priority (+ 1 (voStageManagerBody priority:)))
		(super init: &rest)
	)

	(method (dispose)
		(aoStageManager show:)
		(voStageManagerBody dispose:)
		(super dispose: &rest)
	)
)

(instance voPoster of View
	(properties
		approachX 2475
		approachY 221
		x 2486
		y 78
		view 50900
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTakePoster)
			)
		)
	)
)

(instance soTakePoster of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk (voPoster approachX:) (voPoster approachY:) self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame handsOff:)
				(gEgo hide:)
				(poTakePoster init: setCycle: CT 2 1 self)
			)
			(4
				(= ticks (poTakePoster cycleSpeed:))
			)
			(5
				(voPoster dispose:)
				(goSound1 playSound: 50923)
				(poTakePoster setCel: 3 setCycle: CT 13 1 self)
			)
			(6
				(= ticks (poTakePoster cycleSpeed:))
			)
			(7
				(poTakePoster setCel: 14)
				(poSpinningPoster
					setCel: 0
					init:
					setCycle: ForwardCounter 3 self
				)
			)
			(8
				(poSpinningPoster dispose:)
				(poTakePoster setLoop: 2 setCel: 0 setCycle: End self)
			)
			(9
				(poTakePoster dispose:)
				(gEgo show:)
				(gEgo get: ((ScriptID 64001 0) get: 45)) ; oInvHandler, ioPlaybill
				((ScriptID 64017 0) set: 161) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTakePoster of Prop
	(properties
		x 2475
		y 221
		view 50923
	)
)

(instance poSpinningPoster of Prop
	(properties
		x 2475
		y 221
		view 50923
		loop 1
	)
)

(instance voBagpipes of View
	(properties
		approachX 2620
		approachY 220
		x 2603
		y 153
		view 50901
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTakeBagpipes)
			)
		)
	)
)

(instance soTakeBagpipes of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk
					(voBagpipes approachX:)
					(voBagpipes approachY:)
					self
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(3
				(goSound1 playSound: 50908)
				(voBagpipes dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 46)) ; oInvHandler, ioBagpipes
				((ScriptID 64017 0) set: 162) ; oFlags
				(CheckSawCondition)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voHat of View
	(properties
		approachX 2193
		approachY 240
		x 2183
		y 166
		view 50902
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTakeHat)
			)
		)
	)
)

(instance soTakeHat of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk (voHat approachX:) (voHat approachY:) self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(3
				(voHat dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 47)) ; oInvHandler, ioTopHat
				((ScriptID 64017 0) set: 163) ; oFlags
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voCane of View
	(properties
		approachX 2177
		approachY 240
		x 2183
		y 165
		view 50904
	)

	(method (init)
		(super init: &rest)
		(self setPri: 167)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTakeCane)
			)
		)
	)
)

(instance soTakeCane of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk (voCane approachX:) (voCane approachY:) self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGame handsOff:)
				(self setScript: (ScriptID 64007 2) self self) ; soEgoGetMed
			)
			(3
				(voCane dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 49)) ; oInvHandler, ioCane
				((ScriptID 64017 0) set: 165) ; oFlags
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voBow of View
	(properties
		approachX 1927
		approachY 262
		x 1725
		y 289
		view 50910
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
		(self addHotspotVerb: 1)
		(self setPri: 250)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTakeBow)
			)
		)
	)
)

(instance poBowFalls of Prop
	(properties
		x 1725
		y 289
		view 50938
	)
)

(instance soTakeBow of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk (voBow approachX:) (voBow approachY:) self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gGame handsOff:)
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(3
				(voBow dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 56)) ; oInvHandler, ioBow
				((ScriptID 64017 0) set: 172) ; oFlags
				(CheckRosinCondition)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance voRosin of View
	(properties
		approachX 2177
		approachY 275
		x 2115
		y 305
		view 50911
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(if ((ScriptID 64017 0) test: 210) ; oFlags
					(gEgo setScript: soTakeRosin)
				else
					(gEgo setScript: soTakeRosinAttempt)
				)
			)
		)
	)
)

(instance soTakeRosin of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk (voRosin approachX:) (voRosin approachY:) self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gGame handsOff:)
				(self setScript: (ScriptID 64007 1) self self) ; soEgoGetLow
			)
			(3
				(voRosin dispose:)
				(gEgo get: ((ScriptID 64001 0) get: 57)) ; oInvHandler, ioRosin
				((ScriptID 64017 0) set: 173) ; oFlags
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeRosinAttempt of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShortestWalk (voRosin approachX:) (voRosin approachY:) self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gMessager say: 12 1 0 0 self) ; "No, they need that rosin more than I!"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance oStageActs of TPSound
	(properties)
)

(instance soStageActs of Script
	(properties)

	(method (changeState newState &tmp nX)
		(switch (= state newState)
			(0
				(= ticks 300)
			)
			(1
				(if (< (= nX (mod (gEgo x:) 3160)) 800)
					(oStageActs setRelVol: (/ (- 400 (Abs (- nX 400))) 4))
					(oStageActs
						playSound:
							(switch (Random 0 5)
								(0 50911)
								(1 50912)
								(2 50913)
								(3 50914)
								(4 50919)
								(5 50920)
							)
					)
					(= cycles 3)
				else
					(-- state)
					(= ticks 60)
				)
			)
			(2
				(= nX (mod (gEgo x:) 3160))
				(if (oStageActs isPlaying:)
					(if (< nX 800)
						(oStageActs
							setRelVol: (/ (- 400 (Abs (- nX 400))) 4)
						)
					else
						(oStageActs setRelVol: 0)
					)
					(-- state)
					(= cycles 3)
				else
					(= state -1)
					(self cue:)
				)
			)
		)
	)

	(method (dispose)
		(if (oStageActs isPlaying:)
			(oStageActs fadeOut:)
		)
		(super dispose: &rest)
	)
)

(instance roBackstageAmp of TPRoom
	(properties
		purge 2500
	)

	(method (init)
		(super init: &rest)
		((ScriptID 64017 0) set: 203) ; oFlags
		(gOEventHandler
			unregisterGlobalHandler: (ScriptID 64010 1) ; oRightClickHandler
			registerGlobalHandler: oRightClickHandler
		)
		(gGame handsOff:)
		(= plane
			(oBackstageScrollPlane init: 3792 (gThePlane getHeight:) yourself:)
		)
		(goMusic1 setMusic: 50900)
		(gGame setScript: soStageActs)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 257 0 0 3791 0 3791 257 3020 257 2960 280 2825 280 2810 263 2650 250 2660 210 2597 219 2563 267 2400 268 2375 221 2475 222 2475 221 2375 220 2265 220 2265 235 2152 235 2129 207 2000 207 1960 250 1804 259 1750 229 1683 264 1525 267 1456 266 1367 293 1229 290 1220 215 962 215 821 272 768 232 740 257
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 1442 316 1448 287 1502 289 1547 316 1509 335
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 1795 335 1795 294 1935 283 2184 275 2376 275 2382 335
					yourself:
				)
		)
		(voDoor init:)
		(voSaw init:)
		(voBoard init:)
		(voPoster init:)
		(voBagpipes init:)
		(poRabbit init: setCycle: RandCycle)
		(poArcher init:)
		(poCarpenter init:)
		(poArchivist init: setScript: soArchivist)
		(poMagician init:)
		(aoStageManager init:)
		(gEgo posn: 2069 207)
		(gCurRoom setScript: soEgoEntrance)
	)

	(method (dispose)
		(gOEventHandler
			unregisterGlobalHandler: oRightClickHandler
			registerGlobalHandler: (ScriptID 64010 1) ; oRightClickHandler
		)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 44)) ; oInvHandler, ioSilkWorms
		(oBackstageScrollPlane scrollTo: 3160 0)
	)
)

(instance oArcheryCU of Plane
	(properties
		picture 53101
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

(instance oMagicianCU of Plane
	(properties
		picture 53000
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 161) ; oFlags
			(= picture 53001)
		)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
	)
)

(instance foArchivistCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom setScript: soLeaveArchivistCU)
	)
)

(instance oArchivistCU of Plane
	(properties
		picture 53200
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(foArchivistCUExit init:)
		(= gtArchivist toArchivistCU)
		(= gtTorin toTorinWithArchivist)
	)

	(method (dispose)
		(= gtArchivist 0)
		(= gtTorin 0)
		(super dispose: &rest)
	)
)

(instance oRabbitCU of Plane
	(properties
		picture 53100
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(voRabbitBody init: self)
		(voRabbitMouth init: self)
		(= gnRabbitTalker 1)
	)

	(method (dispose)
		(= gnRabbitTalker 0)
		(super dispose: &rest)
	)
)

(instance oBackstageHandle of TorScrollHandle
	(properties
		view 60004
		loop 18
		nLowBound 20
		nHighBound 620
	)

	(method (init)
		(super init: &rest)
		(= nLowBound (+ (gThePlane left:) 10))
		(= nHighBound (- (gThePlane right:) (+ 10 (CelWide view loop cel))))
	)

	(method (reSynch &tmp nPos nMax nRange)
		(if (not oMyScrollPlane)
			(PrintDebug
				{Attempt to resynch scroll handle with no scroll plane. DJM torscrol.sc}
			)
			(return)
		)
		(= nRange (- nHighBound nLowBound))
		(if bXAxis
			(= nPos
				(mod
					(+
						(/ (= nMax (oMyScrollPlane nScrollMaxX:)) 2)
						(- (oMyScrollPlane nCurPosX:) (- (gEgo x:) 316))
					)
					3160
				)
			)
			(plane
				moveTo: (+ (MulDiv nPos nRange nMax) nLowBound) (plane top:)
			)
			(UpdatePlane plane)
		)
	)

	(method (handleEvent event &tmp nPos nMax nRange nScroll)
		(if (not oMyScrollPlane)
			(PrintDebug
				{Attempt to handleEvent scroll handle with no scroll plane. MLE 50900.sc}
			)
			(return)
		)
		(if (and (self onMe: event) (== (event type:) evMOUSEBUTTON))
			(= bImAHog 1)
			(gOEventHandler registerEventHog: self)
			(event globalize:)
			(gEgo bAutoScroll: 0)
			(= nMouseStartX (event x:))
			(= nMouseStartY (event y:))
			(= nHandleStartX (plane left:))
			(= nHandleStartY (plane top:))
		)
		(if bImAHog
			(if (== (event type:) evMOUSERELEASE)
				(self stopHogging:)
			)
			(event globalize:)
			(if bXAxis
				(if
					(<
						(= nPos (+ (- (event x:) nMouseStartX) nHandleStartX))
						nLowBound
					)
					(= nPos nHighBound)
					(gTheCursor
						posn:
							(+ nPos (- nMouseStartX nHandleStartX))
							nHandleStartY
					)
				)
				(if (> nPos nHighBound)
					(= nPos nLowBound)
					(gTheCursor
						posn:
							(+ nPos (- nMouseStartX nHandleStartX))
							nHandleStartY
					)
				)
				(plane moveTo: nPos nHandleStartY)
				(UpdatePlane plane)
				(= nRange (- nHighBound nLowBound))
				(-= nPos nLowBound)
				(= nMax (oMyScrollPlane nScrollMaxX:))
				(= nScroll
					(+
						(gEgo x:)
						-316
						(- (MulDiv nPos nMax nRange) (/ nMax 2))
					)
				)
				(oMyScrollPlane scrollTo: nScroll (oMyScrollPlane nCurPosY:))
			)
			(event claimed: 1)
			(return 1)
		)
		(super handleEvent: event &rest)
	)
)

(instance oBackstageScrollPlane of TorScrollPlane
	(properties
		priority 20
	)

	(method (init)
		(= oHorizHandle oBackstageHandle)
		(= oEScrollExit foEBackstageScroll)
		(= oWScrollExit foWBackstageScroll)
		(super init: &rest)
		(oBackstageHandle oMyScrollPlane: self init: yourself:)
		(oEScrollExit init: (ScriptID 0 1)) ; oBackgroundPlane
		(oWScrollExit init: (ScriptID 0 1)) ; oBackgroundPlane
	)

	(method (addPics)
		(AddPicAt self 50905 0 0)
		(AddPicAt self 50900 632 0)
		(AddPicAt self 50901 1264 0)
		(AddPicAt self 50902 1896 0)
		(AddPicAt self 50903 2528 0)
		(AddPicAt self 50904 3160 0 0 0)
	)

	(method (canScrollLeft)
		(return 1)
	)

	(method (canScrollRight)
		(return 1)
	)

	(method (scrollTo nArgX nArgY &tmp nX nY objNode selNode oTmp selTmp nWidth nHeight)
		(if argc
			(= nX nArgX)
		else
			(= nX 0)
		)
		(if (> argc 1)
			(= nY nArgY)
		else
			(= nY 0)
		)
		(if (or (> nX nScrollMaxX) (< nX 0))
			(= nX (mod nX nScrollMaxX))
			(if (gEgo bAutoScroll:)
				(cond
					(
						(<=
							(gEgo x:)
							(+
								632
								(CelWide
									(gEgo view:)
									(gEgo loop:)
									(gEgo cel:)
								)
							)
						)
						(WrapEgoLeft)
					)
					(
						(>=
							(gEgo x:)
							(-
								3160
								(CelWide
									(gEgo view:)
									(gEgo loop:)
									(gEgo cel:)
								)
							)
						)
						(WrapEgoRight)
					)
				)
				(if (gEgo isNotHidden:)
					(UpdateScreenItem gEgo)
				)
			)
		)
		(if (> nY nScrollMaxY)
			(= nY nScrollMaxY)
		)
		(if (< nY 0)
			(= nY 0)
		)
		(if (and (== nCurPosX nX) (== nCurPosY nY))
			(return)
		)
		(= nCurPosX nX)
		(= nCurPosY nY)
		(= nWidth (self getWidth:))
		(= nHeight (self getHeight:))
		(= top (- nScreenOrgY nCurPosY))
		(= left (- nScreenOrgX nCurPosX))
		(self setRect: left top (- (+ left nWidth) 1) (- (+ top nHeight) 1))
		(if oMyScrollViews
			(oMyScrollViews eachElementDo: #reposition)
		)
		(UpdatePlane self)
		(if (or (not oMyNotifyObjs) (not oMyNotifySelectors))
			(return)
		)
		(= objNode (oMyNotifyObjs first:))
		(for
			((= selNode (oMyNotifySelectors first:)))
			(and objNode selNode)
			((= selNode (oMyNotifyObjs next: selNode)))
			
			(= oTmp (KList 8 objNode)) ; NodeValue
			(= selTmp (KList 8 selNode)) ; NodeValue
			(if (and oTmp selTmp)
				(Eval oTmp selTmp)
			)
			(= objNode (oMyNotifyObjs next: objNode))
		)
	)
)

(instance foEBackstageScroll of InfiniteScrollExit
	(properties
		nScrollDir 2
	)
)

(instance foWBackstageScroll of InfiniteScrollExit
	(properties
		nScrollDir 4
	)
)

(instance poEgoDouble of Prop
	(properties)

	(method (init &tmp oHotspotVerbList i verb)
		(= view (gEgo view:))
		(= loop (gEgo loop:))
		(= cel (gEgo cel:))
		(= y (gEgo y:))
		(self setScale:)
		(= scaleX (gEgo scaleX:))
		(= scaleY (gEgo scaleY:))
		(if (>= (gEgo x:) 1580)
			(= x (- (gEgo x:) 3160))
		else
			(= x (+ (gEgo x:) 3160))
		)
		(super init: &rest)
		(if (= oHotspotVerbList (gEgo getHotspotVerbList:))
			(for ((= i 0)) (= verb (oHotspotVerbList at: i)) ((++ i))
				(self addHotspotVerb: verb)
			)
		)
	)

	(method (doVerb)
		(gEgo doVerb: &rest)
	)

	(method (doit &tmp nEgoX)
		(= view (gEgo view:))
		(= loop (gEgo loop:))
		(= cel (gEgo cel:))
		(= y (gEgo y:))
		(= scaleX (gEgo scaleX:))
		(= scaleY (gEgo scaleY:))
		(if (!= (= nEgoX (gEgo x:)) lastEgoX)
			(if (>= nEgoX 1580)
				(= x (- nEgoX 3160))
			else
				(= x (+ nEgoX 3160))
			)
			(= lastEgoX nEgoX)
			(oBackstageHandle reSynch:)
		)
		(super doit: &rest)
	)
)

(instance oEgoCode of Code
	(properties)

	(method (doit)
		(if (not (gEgo bAutoScroll:))
			(cond
				((< (gEgo x:) 316)
					(WrapEgoLeft)
				)
				((> (gEgo x:) 3476)
					(WrapEgoRight)
				)
			)
		)
	)
)

(instance oScrollerWalkHandler of Code
	(properties)

	(method (doit nX nY)
		(if (== (aoStageManager script:) soStageManagerStopsToTalk)
			(aoStageManager setScript: soStageManagerPaces)
		)
		(ShortestWalk nX nY)
	)
)

(instance oRightClickHandler of EventCode
	(properties)

	(method (handleEvent event &tmp ppDest)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(& (event modifiers:) emSHIFT)
				(gUser canControl:)
				(gEgo bIsInitialized:)
				(gEgo isNotHidden:)
				(gEgo plane:)
				((gEgo plane:) isEnabled:)
				((gEgo plane:) onMe: (event globalize: yourself:))
			)
			(if (== (aoStageManager script:) soStageManagerStopsToTalk)
				(aoStageManager setScript: soStageManagerPaces)
			)
			(event localize: (gEgo plane:))
			(= ppDest (GetDestLoc gEgo (event x:) (event y:)))
			(gEgo setMotion: 0)
			(cond
				((and (not bSeenArchery) (< 1735 (ppDest at: 0) 1960))
					(gEgo setLoop: 8 setCel: 1 posn: 1949 251)
				)
				((and (not bSeenArchery) (< 1640 (ppDest at: 0) 1736))
					(gEgo setLoop: 8 setCel: 0 posn: 1667 265)
				)
				(else
					(gEgo
						setLoop:
							[trans2
								(/
									(umod
										(+
											(GetAngle
												(gEgo x:)
												(gEgo y:)
												(ppDest at: 0)
												(ppDest at: 1)
											)
											22
										)
										360
									)
									45
								)
							]
					)
					(gEgo posn: (ppDest at: 0) (ppDest at: 1))
				)
			)
			(ppDest dispose:)
			(event claimed: 1)
		)
		(event claimed:)
	)
)

