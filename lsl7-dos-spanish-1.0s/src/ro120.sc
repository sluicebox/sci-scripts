;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use foEExit)
(use Talker)
(use ROsc)
(use RandCycle)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	ro120 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance ro120 of L7Room
	(properties
		picture 12000
	)

	(method (init)
		(poEgo init: hide:)
		(super init: &rest)
		(Load 140 12001) ; WAVE
		(Load rsVIEW 12000 12005)
		(gOMusic1 setMusic: 12000)
		(oAmbientFire setAmbient: 10124)
		(= global330 0)
		(voChair init:)
		(poBubbles init:)
		(foWindow init:)
		(foLamp init:)
		(foAquarium init:)
		(foRose1 init:)
		(foRose2 init:)
		(foRose3 init:)
		(foExitEast init:)
		(oFireTimer setReal: oFireTimer 60)
		(self setScript: soEgoEnters)
	)

	(method (dispose)
		(if (gTimers contains: oChiefTimer)
			(oChiefTimer dispose: delete:)
		)
		(if (gTimers contains: oFireTimer)
			(oFireTimer dispose: delete:)
		)
		(super dispose: &rest)
	)
)

(instance soEgoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(= ticks 60)
			)
			(2
				(poEgo
					view: 12000
					setLoop: 0 1
					cel: 0
					posn: 28 -3
					show:
					setPri: 400
					setCycle: End self 3 999
				)
			)
			(3
				(gOSound1 playSound: 12001)
			)
			(4
				(poEgo
					view: 12005
					setLoop: 0 1
					cel: 0
					posn: 240 305
					setPri: -1
					setCycle: Fwd
					setScript: soEgoPanics
				)
				(= local0 0)
				(oChiefTimer setReal: oChiefTimer 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soEgoPanics of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 180))
			)
			(1
				(if (== (Random 1 3) 2)
					(oSFX playSound: 10123)
					(poEgo setCycle: 0 loop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (poEgo loop:)
					(poEgo loop: 0 cel: 0 setCycle: Fwd)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance soFireChief of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oChiefSFX playSubtitledSound: 11041 0 0 3 1 self 120)
			)
			(1
				(poEgo setScript: 0 setCycle: 0 loop: 0 setCycle: End self)
			)
			(2
				(poEgo view: 12006 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 0 0 3 2 self) ; "(LOUD) Are you crazy? This is the fortieth floor!"
			)
			(4
				(oChiefSFX playSubtitledSound: 11042 0 0 3 3 self 120)
			)
			(5
				(poEgo loop: 1 cel: 0 posn: 241 308 setCycle: End self)
			)
			(6
				(= local0 1)
				(= local5 1)
				(oChiefTimer setReal: oChiefTimer 0 2)
				(if (and local2 local3 local4 (not local6))
					(= local6 1)
					(oChiefTimer setReal: oChiefTimer 10)
				)
				(poEgo
					view: 12005
					loop: 0
					cel: 0
					posn: 240 305
					setCycle: Fwd
					setScript: soEgoPanics
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soThrowChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 10133) ; WAVE
				(poEgo
					setScript: 0
					view: 12020
					setLoop: 0 1
					cel: 0
					setPri: 400
					cycleSpeed: 8
					setCycle: End self 16 54 67
				)
			)
			(1
				(voChair dispose:)
				(poEgo doit:)
				(gMessager say: 2 60 0 1) ; "(CARRY HEAVY CHAIR FOR 4 SECONDS) Groan."
			)
			(2
				(gOSound1 playSound: 10133)
				(poEgo setPri: -1)
			)
			(3
				(poEgo setCycle: CT 69 1)
				(gMessager say: 2 60 0 2 self) ; "(Sigh.) Hotel furniture just ain't what it used to be!"
			)
			(4
				(poEgo setCycle: End self)
			)
			(5
				((View new:) view: 12020 loop: 1 cel: 0 x: 240 y: 305 init:)
				(poEgo
					view: 12005
					setLoop: 0 1
					cel: 0
					setCycle: Fwd
					setScript: soEgoPanics
				)
				(if (and local2 local3 local4 (not local6) local5)
					(= local6 1)
					(oChiefTimer setReal: oChiefTimer 10)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soThrowLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poEgo
					setScript: 0
					view: 12025
					setLoop: 0 1
					cel: 0
					cycleSpeed: 8
					setCycle: End self 31 999
				)
			)
			(1
				(gMessager say: 3 60 0 1 self) ; "(4" OF STRUGGLE & STRAIN; YOU CAN'T LIFT IT) Ungh, ogh, oh, ugh."
			)
			(2 0)
			(3
				(gMessager say: 3 60 0 2 self) ; "You can't lift that, Larry; it must weigh all of 20 pounds!"
				(poEgo
					view: 12005
					setLoop: 0 1
					cel: 0
					setCycle: Fwd
					setScript: soEgoPanics
				)
			)
			(4
				(if (and local2 local3 local4 (not local6) local5)
					(= local6 1)
					(oChiefTimer setReal: oChiefTimer 10)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTryDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 10132 10134 10136) ; WAVE
				(poEgo
					setScript: 0
					view: 12015
					setLoop: 0 1
					cel: 0
					cycleSpeed: 11
					setCycle: End self 8 12 15
				)
			)
			(1
				(gOSound1 playSound: 10132)
			)
			(2
				(gOSound1 playSound: 10134)
			)
			(3
				(poEgo setCycle: ROsc 20 13 15)
				(poSmoke view: 12015 loop: 1 cel: 0 init: setCycle: End self)
			)
			(4
				(= register 2)
				(poSmoke dispose:)
				(poEgo setCycle: CT 18 1 self)
			)
			(5
				(gOSound1 playSound: 10136)
				(= ticks 30)
			)
			(6
				(-- register)
				(poEgo setCycle: CT 19 1 self)
			)
			(7
				(poEgo setCycle: CT 18 -1 self)
			)
			(8
				(gOSound1 playSound: 10136)
				(if register
					(-= state 3)
				)
				(= ticks 30)
			)
			(9
				(poEgo setCycle: End self)
			)
			(10
				(poEgo view: 12005 setLoop: 0 1 cel: 0 doit:)
				(gMessager say: 1 61 0 0 self) ; "Our night of passionate love-making must have overheated the frame!"
			)
			(11
				(gGame handsOn:)
				(poEgo setCycle: Fwd setScript: soEgoPanics)
				(self dispose:)
			)
		)
	)
)

(instance soUpInFlames of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 10135 12002) ; WAVE
				(poEastFlames init: cel: 0 setCycle: End self)
				(oSFX2 playSound: 10135)
			)
			(1
				(poEastFlames
					setLoop: 1
					cel: 0
					posn: 639 412
					setCycle: RandCycle
				)
				(= ticks 60)
			)
			(2
				(oSFX2 playSound: 12002)
				(poRightFlowerFlame init: cel: 0 setCycle: End self)
			)
			(3
				(foRose1 case: 5)
				(poRightFlowerFlame setLoop: 3 cel: 0 setCycle: RandCycle)
				(oSFX2 playSound: 12002)
				(poMiddleFlowerFlame init: cel: 0 setCycle: End self)
			)
			(4
				(foRose2 case: 5)
				(poMiddleFlowerFlame setLoop: 3 cel: 0 setCycle: RandCycle)
				(= ticks 60)
			)
			(5
				(oSFX2 playSound: 12002)
				(poLeftFlowerFlame init: cel: 0 setCycle: End self)
			)
			(6
				(foRose3 case: 5)
				(poLeftFlowerFlame setLoop: 3 cel: 0 setCycle: RandCycle)
				(self dispose:)
			)
		)
	)
)

(instance soFinishOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: oChiefTimer)
					(oChiefTimer dispose: delete:)
				)
				(if (gTimers contains: oFireTimer)
					(oFireTimer dispose: delete:)
				)
				(gCurRoom drawPic: 12100)
				(Palette 1 121) ; PalLoad
				(((gCurRoom plane:) oMyFeatures:) eachElementDo: #dispose)
				(gCast eachElementDo: #dispose)
				(oAmbientFire fadeOut:)
				(gOMusic1 playSound: 12100)
				(poWindow init: doit:)
				(Load 140 10140 12101 12102 12103) ; WAVE
				(Load rsVIEW 12100)
				(= ticks 60)
			)
			(1
				(gOSound1 stop:)
				(oSFX2 playSound: 12101 self)
			)
			(2
				(gOSound1 playSound: 10140)
				(= ticks 20)
			)
			(3
				(poEgo
					view: 12100
					setLoop: 0
					cel: 0
					posn: 639 406
					setPri: 480
					init:
					cycleSpeed: 7
					doit:
					setCycle: End self 2 10
				)
				(poWindow setCycle: End poWindow)
			)
			(4
				(oSFX2 playSound: 12102)
			)
			(5
				(oSFX2 playSound: 12103 self)
			)
			(6
				(gMessager say: 1 64 0 2 self) ; "(DISCOVERING SOMETHING IMPORTANT) Hey...what's this!?"
			)
			(7
				(gCurRoom drawPic: 12200)
				(Palette 1 122) ; PalLoad
				(poWindow dispose:)
				(poEgo view: 12200 loop: 0 cel: 0 posn: 54 409 doit:)
				(Load 140 10150) ; WAVE
				(= ticks 30)
			)
			(8
				(poEgo setCycle: End self 8 46 9999)
			)
			(9
				(gOSound1 playSound: 10150)
				(gMessager say: 1 64 0 3) ; "(WHINE ABOUT CUT FINGERTIP) Ow! I hate paper cuts!"
			)
			(10
				(gOSound1 playSound: 10150)
				(gMessager say: 1 64 0 4 self) ; "(AFTER INSERTING IN UNDERPANTS) Ow! I HATE paper cuts!"
			)
			(11 0)
			(12
				(gCurRoom drawPic: 12300)
				(Palette 1 123) ; PalLoad
				(poEgo
					view: 12300
					setLoop: 0 1
					cel: 0
					posn: 0 0
					setPri: 480
					doit:
				)
				(= ticks 30)
			)
			(13
				(poEgo setCycle: CT 11 1 self)
			)
			(14
				(poEgo setCycle: RangeRandCycle -1 6 11)
				(gMessager sayRange: 1 64 0 5 6 self) ; "(ALWAYS THROUGH BULLHORN) Jump!"
			)
			(15
				(poEgo setCycle: End self)
			)
			(16
				(poEgo hide:)
				(gMessager say: 1 64 0 7 self) ; "I wish I had a dollar for every time I've heard that!"
			)
			(17
				(self setScript: soFinishOpening2)
			)
		)
	)
)

(instance soFinishOpening2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 12400)
				(Palette 1 124) ; PalLoad
				(poEgo
					view: 12400
					setLoop: 0 1
					cel: 0
					posn: 301 180
					cycleSpeed: 24
					show:
					doit:
				)
				(Load 140 12401) ; WAVE
				(= ticks 30)
			)
			(1
				(poEgo setCycle: End self 3 8 13 999)
			)
			(2
				(gOSound1 playSound: 12401)
				(poExplosion init: setScript: soExplode)
				(= cycles 30)
			)
			(3
				(gMessager say: 1 64 0 8) ; "(EXTREME SLO-MO, DOWN 2 OCTAVES; DO SEVERAL TAKES OF VARIED LENGTHS) Oh, shi..."
			)
			(4
				(poEgo setPri: 500)
			)
			(5 0)
			(6
				(poEgo hide:)
				(= ticks 60)
			)
			(7
				(poExplosion dispose:)
				(gCurRoom drawPic: 12500)
				(Palette 1 125) ; PalLoad
				(voBystanders init:)
				(poFiremen init:)
				(poOperaSinger init:)
				(poDivingBoard init:)
				(poFireman init:)
				(poChief init:)
				(Load 140 10180 10182 10183 10184 10185 10187) ; WAVE
				(Load rsVIEW 12500)
				(= cycles 3)
			)
			(8
				(oSFX playSound: 10180)
				(= ticks 120)
			)
			(9
				(poFiremen setCycle: End)
				(= cycles 3)
			)
			(10
				(poEgo
					view: 12500
					setLoop: 0 1
					cel: 0
					posn: 451 51
					setPri: 480
					show:
					cycleSpeed: 8
					setCycle: End self 1 4 6 13 15 17 22
				)
			)
			(11
				(oSFX stop:)
				(gOSound1 playSound: 10182)
				(poFiremen hide:)
			)
			(12
				(poChief setLoop: 1 cel: 0 setCycle: End)
				(poFiremen show: loop: 1 cel: 0 setCycle: End)
			)
			(13
				(gOSound1 playSound: 10183)
			)
			(14
				(poFiremen loop: 2 cel: 0 setCycle: CT 4 1)
				(oSFX playSound: 10184)
				(poSingerBoobs setCycle: End)
			)
			(15
				(poSingerBoobs
					setCycle: 0
					loop: 2
					cel: 0
					setScript: soBoobsAlive
				)
			)
			(16
				(poFiremen setCycle: CT 9 1)
				(gOSound1 playSound: 10185)
				(poDivingBoard hide:)
			)
			(17
				(poFiremen setCycle: End)
				(poFiremanHead setCycle: End)
				(poDivingBoard show: loop: 1 setCycle: End self)
				(oSFX2 playSound: 10187 self 0)
			)
			(18
				(if (> (poFiremen cel:) 10)
					(poFiremen setCycle: CT 10 -1 self)
				else
					(= cycles 1)
				)
				(poDivingBoard loop: 0 cel: 0)
			)
			(19
				(Load rsVIEW 12600 12601 12602 12603 12605)
				(Load rsPIC 12600)
				(Load 140 12601 12602 12603 32205) ; WAVE
			)
			(20
				(gCurRoom drawPic: 12600)
				(Palette 1 126) ; PalLoad
				(poFireman dispose:)
				(gCast eachElementDo: #dispose)
				(poLarry init:)
				(poLarryLeg init:)
				(gOMusic1 playSound: 12600)
				(gOAmbience setAmbient: 32205)
				(= cycles 3)
			)
			(21
				(poLarry setCycle: End self)
				(gOSound1 playSound: 12603)
			)
			(22
				(gMessager say: 1 64 0 10) ; "(RAPIDLY, WITH MUCH ENERGY, LIKE A SUPERBOWL DISNEYLAND PLUG) Leisure Suit Larry, you just leapt from the 40th floor of a burning building! What are you gonna do next?"
				(poLarry view: 12601 cel: 0 setCycle: End self 12 38 999)
				(poLarryLeg view: 12601 cel: 0 setCycle: End)
			)
			(23
				(gOSound1 playSound: 12601)
			)
			(24
				(gOSound1 playSound: 12602)
			)
			(25
				(poLarry view: 12602 cel: 0 setCycle: CT 1 1 self)
				(poLarryLeg view: 12602 cel: 0 setCycle: CT 1 1)
			)
			(26
				(if (gTalkers isEmpty:)
					(= cycles 1)
				else
					(-- state)
					(= cycles 10)
				)
			)
			(27
				(poMicrophone init: setCycle: End)
				(voLarryLeg
					view: 12602
					loop: 1
					cel: 0
					posn: 303 275
					setPri: (- (poLarry priority:) 10)
					init:
				)
				(poLarry setCycle: End self 8 999)
				(poLarryLeg setCycle: End)
			)
			(28
				(voLarryLeg dispose:)
			)
			(29
				(= global330 toLarry)
				(gMessager say: 1 64 0 11 self) ; "(HESITANTLY) I'm going to... (EXAMINE TICKET)"
			)
			(30
				(poMicrophone setCycle: Beg coMicDone)
				(poLarry view: 12605 cel: 0 setCycle: End self)
				(gOAmbience fadeOut:)
			)
			(31
				(= global330 0)
				(gCurRoom drawPic: 12650)
				(gCast eachElementDo: #dispose)
				(= cycles 1)
			)
			(32
				(gMessager say: 1 64 0 12 self) ; "(POSITIVELY) ...take a cruise!"
			)
			(33
				(gEgo
					put: ((ScriptID 64037 0) get: 1) ; oInvHandler, ioLockpick
					put: ((ScriptID 64037 0) get: 51) ; oInvHandler, ioViceGrips
				)
				(gOMusic1 fadeOut:)
				(= ticks 60)
			)
			(34
				(gCurRoom newRoom: 130) ; ro130
				(self dispose:)
			)
		)
	)
)

(instance soExplode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client setCycle: ROsc 50 16 19)
				(self dispose:)
			)
		)
	)
)

(instance soBoobsAlive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client loop: 1 cel: 0 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance poEgo of Prop
	(properties
		noun 7
		view 12000
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance poBubbles of Prop
	(properties
		x 450
		y 200
		view 12099
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance voChair of View
	(properties
		noun 2
		x 92
		y 388
		view 12050
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8 60)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; Throw
				(= local3 1)
				(gCurRoom setScript: soThrowChair)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poSmoke of Prop
	(properties
		x 240
		y 305
		loop 1
		view 12015
	)

	(method (init)
		(super init:)
		(self setPri: 400)
	)
)

(instance poEastFlames of Prop
	(properties
		noun 6
		x 639
		y 427
		view 12030
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self setPri: 500)
	)
)

(instance poRightFlowerFlame of Prop
	(properties
		noun 5
		x 251
		y 479
		case 5
		loop 2
		view 12030
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance poMiddleFlowerFlame of Prop
	(properties
		noun 5
		x 135
		y 479
		case 5
		loop 2
		view 12030
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance poLeftFlowerFlame of Prop
	(properties
		noun 5
		x 26
		y 479
		case 5
		loop 2
		view 12030
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance poExplosion of Prop
	(properties
		x 639
		y 397
		cycleSpeed 24
		loop 1
		cel 3
		view 12400
	)
)

(instance poWindow of Prop
	(properties
		x 639
		y 453
		loop 1
		view 12100
	)

	(method (cue)
		(self setPri: 479)
	)
)

(instance voBystanders of View
	(properties
		x 321
		y 392
		view 12530
	)
)

(instance poFiremen of Prop
	(properties
		x 548
		y 459
		view 12505
	)
)

(instance poOperaSinger of Prop
	(properties
		x 353
		y 74
		view 12510
	)

	(method (init)
		(super init: &rest)
		(poSingerBoobs init:)
	)
)

(instance poSingerBoobs of Prop
	(properties
		x 353
		y 74
		loop 1
		view 12510
	)

	(method (init)
		(self setPri: (+ (poOperaSinger priority:) 5))
		(super init: &rest)
	)
)

(instance poDivingBoard of Prop
	(properties
		x 267
		y 467
		view 12515
	)
)

(instance poFireman of Prop
	(properties
		x 161
		y 62
		loop 1
		view 12520
	)

	(method (init)
		(poFiremanHead init:)
		(poFiremanWater init:)
		(super init: &rest)
	)
)

(instance poFiremanHead of Prop
	(properties
		x 161
		y 62
		view 12520
	)
)

(instance poFiremanWater of Prop
	(properties
		x 161
		y 62
		loop 2
		view 12520
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poChief of Prop
	(properties
		x 76
		y 448
		view 12525
	)
)

(instance poLarry of Prop
	(properties
		x 303
		y 275
		view 12600
	)
)

(instance poLarryLeg of Prop
	(properties
		priority 200
		x 303
		y 275
		loop 1
		view 12600
		fixPriority 1
	)
)

(instance poMicrophone of Prop
	(properties
		priority 480
		x 468
		y 479
		view 12603
		fixPriority 1
	)
)

(instance poTicketToLife of Prop ; UNUSED
	(properties
		priority 480
		x 42
		y 416
		loop 1
		view 12605
		fixPriority 1
	)
)

(instance voLarryLeg of View
	(properties)
)

(instance foWindow of Feature
	(properties
		noun 1
		x 150
		y 192
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 43 341 1 78 5 44 169 55 298 87 300 89 282 183 284 270 160 298
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb theVerb)
		(= local4 1)
		(if (and local2 local3 (not local6) local5)
			(= local6 1)
			(oChiefTimer setReal: oChiefTimer 10)
		)
		(switch theVerb
			(64 ; Break
				((ScriptID 64017 0) set: 22) ; oFlags
				(oChiefTimer dispose: delete:)
				(Load rsPIC 12100)
				(gCurRoom setScript: soFinishOpening)
			)
			(61 ; Open
				(gCurRoom setScript: soTryDoor)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foLamp of Feature
	(properties
		noun 3
		x 320
		y 212
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 364 296 353 304 321 308 302 301 286 294 286 281 317 271 327 149 307 139 311 125 336 126 338 118 349 119 352 127 376 138 374 150 342 152 342 160 372 185 351 200 344 195 342 187 333 195 330 272 363 280
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8 60 62 63)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; Throw
				(= local2 1)
				(gCurRoom setScript: soThrowLamp)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foAquarium of Feature
	(properties
		noun 4
		x 446
		y 156
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 384 218 379 157 383 111 456 91 514 84 493 229 453 228
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 64 67)
	)
)

(instance foRose1 of Feature
	(properties
		noun 5
		x 30
		y 442
		case 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 4 411 16 406 41 408 59 423 52 437 47 463 56 472 39 479 1 479 1 440
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foRose2 of Feature
	(properties
		noun 5
		x 135
		y 443
		case 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 97 464 107 454 115 412 133 407 163 412 173 424 159 460 161 478 109 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foRose3 of Feature
	(properties
		noun 5
		x 250
		y 443
		case 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 217 478 216 460 233 407 263 407 285 421 270 459 280 465 279 477 259 479
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foExitEast of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 638 374 588 374 588 1 638 1
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 3)) ; oEastCursor
	)

	(method (doVerb)
		(oFireTimer dispose: delete:)
		(poEastFlames setScript: soUpInFlames)
		(self dispose:)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super init: poLarryMouth poLarryBody)
		(poLarry hide:)
	)

	(method (dispose)
		(poLarry show:)
		(super dispose:)
	)
)

(instance poLarryMouth of Prop
	(properties
		loop 1
		view 12604
	)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super init: &rest)
		(self setPri: (+ (poLarry priority:) 2))
	)
)

(instance poLarryBody of Prop
	(properties
		view 12604
	)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super init: &rest)
		(self setPri: (+ (poLarry priority:) 1))
	)
)

(instance oAmbientFire of TPSound
	(properties)
)

(instance oSFX of TPSound
	(properties)
)

(instance oSFX2 of TPSound
	(properties)
)

(instance oHintSFX of TPSound
	(properties)
)

(instance oChiefSFX of TPSound
	(properties)
)

(instance coMicDone of CueMe
	(properties)

	(method (cue)
		(poMicrophone dispose:)
	)
)

(instance oChiefTimer of Timer
	(properties)

	(method (cue)
		(cond
			((or (gCurRoom script:) (not (gTalkers isEmpty:)))
				(self setReal: self 3)
			)
			((== local0 0)
				(gCurRoom setScript: soFireChief)
			)
			((and local1 (== local0 1))
				(= local1 0)
				(++ local0)
				(self setReal: self 20)
			)
			((== local0 1)
				(= local6 1)
				(= local1 1)
				(oHintSFX playSubtitledSound: 11043 0 0 10 1 self 120)
			)
			((and local1 (== local0 2))
				(= local1 0)
				(++ local0)
				(self setReal: self 15)
			)
			((== local0 2)
				(= local1 1)
				(oHintSFX playSubtitledSound: 11044 0 0 10 2 self 120)
			)
			(local1
				(= local1 0)
				(self setReal: self 15)
			)
			(else
				(= local1 1)
				(oHintSFX playSubtitledSound: 11045 0 0 10 3 self 120)
			)
		)
	)
)

(instance oFireTimer of Timer
	(properties)

	(method (cue)
		(foExitEast doVerb:)
	)
)

