;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use Str)
(use Array)
(use Inset)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm400 0
	Ptooie 1
)

(local
	local0
	local1
	local2 = 1
	local3 = 400
	local4 = 9
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
)

(instance rm400 of SQRoom
	(properties
		noun 1
		picture 400
	)

	(method (init)
		(Load rsVIEW 900)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 21 136 312 136 312 117 240 95 105 95
					yourself:
				)
		)
		(PalVary 0 400 0 100 64 79) ; PalVaryStart
		(gEgo normalize: 0 setScaler: Scaler 105 63 126 95 setSpeed: local4)
		(if (== gPrevRoomNum 410)
			(= style 0)
		)
		(cond
			((and (== gPrevRoomNum 460) (or (== gComPostNextRoomNum 0) (== gComPostNextRoomNum 400)))
				(gEgo posn: 39 131 setHeading: 270 init:)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 460)
				(gEgo setScript: sExitThruComPost init:)
			)
			((== gPrevRoomNum 410)
				(gGame handsOn:)
				(gEgo init:)
			)
			(else
				(gCurRoom setScript: sEnterRoom)
			)
		)
		(holoControls init: approachVerbs: 4) ; Do
		(compost init: approachVerbs: 4) ; Do
		(tubeTop init:)
		(tubeBottom init:)
		(lights1 init:)
		(lights2 init:)
		(lights3 init:)
		(lights4 init:)
		(lights5 init:)
		(floor init:)
		(wall init:)
		(victim init:)
		(ptooie init:)
		(projector init:)
		(= local10 (Str with: {5551212}))
		(Load 140 355) ; WAVE
		(Load 140 406) ; WAVE
		(Load 140 407) ; WAVE
		(Load rsVIEW 402)
		(Load 140 941) ; WAVE
		(Load rsVIEW 364)
		(Load rsVIEW 3630)
		(PalCycle 0 111 114 -1 5) ; Start
		(super init:)
	)

	(method (doit)
		(if
			(and
				(== (gEgo cel:) 8)
				(== (gEgo view:) 900)
				(== local11 local12 (gEgo loop:))
			)
			(sfxSound number: 406 play:)
		)
		(if
			(and
				(== (gEgo cel:) 2)
				(== (gEgo view:) 900)
				(== local11 local12 (gEgo loop:))
			)
			(sfxSound number: 407 play:)
		)
		(= local12 (= local11 (gEgo loop:)))
		(super doit:)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(PalVary 0 400 0 0 64 79) ; PalVaryStart
		(sfxSound dispose:)
		(super dispose:)
	)
)

(instance sLookControls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo holoControls self)
			)
			(1
				(gMessager say: 3 1 0 0 self) ; "These are the HoloDeck programming controls."
			)
			(2
				(gMessager say: 55 1 0 0 self 510) ; "Those buttons seem to be self-explanatory. I wonder what they do."
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance Ptooie of SmallTalker
	(properties)

	(method (init)
		(= client ptooie)
		(self talkView: local3 talkLoop: local2)
		(super init:)
	)
)

(instance sRunProgram of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(projector init:)
				(ptooie init:)
				(victim init:)
				(gGame handsOff:)
				(gEgo setHeading: 45)
				(enterButton setCel: 0)
				(= cycles 10)
			)
			(1
				(sfxSound number: 401 setLoop: 0 play: self)
				(projector
					show:
					setLoop: 0
					setCel: 0
					cycleSpeed: local4
					setCycle: End self
				)
			)
			(2)
			(3
				(sfxSound number: 923 setLoop: 0 play:)
				(ptooie
					setLoop: 1
					setCel: 0
					cycleSpeed: local4
					show:
					setCycle: End self
				)
			)
			(4
				(= local2 2)
				(= local3 400)
				(gMessager sayRange: 0 0 1 1 2 self) ; "Welcome to HoloSuite program #5551212 -- The Vulgar Nerve Pinch"
			)
			(5
				(sfxSound number: 923 setLoop: 0 play:)
				(ptooie
					setLoop: 4
					setCel: 0
					cycleSpeed: local4
					setCycle: End self
				)
			)
			(6
				(ptooie view: 401 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(7
				(= local2 1)
				(= local3 401)
				(gMessager say: 0 0 1 3 self) ; "This is a tactile/aural maneuver in which the applier pinches the bundle of nerve fibers at the base of the neck while whispering into the victim's ear dialogue from either "Tango & Cash" or "Hudson Hawk.""
			)
			(8
				(ptooie view: 401 setLoop: 0 setCel: 3)
				(gMessager sayRange: 0 0 1 4 5 self) ; "This particular combination of nerve stimuli and loss of cerebral control due to the torturous mantra of movie dialog results in a searing flash of pain, and then unconsciousness."
			)
			(9
				(ptooie
					view: 401
					setLoop: 0
					setCel: 3
					cycleSpeed: local4
					setCycle: Beg self
				)
			)
			(10
				(= local2 2)
				(= local3 400)
				(gMessager sayRange: 0 0 1 6 7 self) ; "When they awaken, they will remember nothing of how they came to be unconscious -- if they are extremely lucky. I shall demonstrate on my most eager volunteer."
			)
			(11
				(ptooie view: 400 setLoop: 2)
				(sfxSound number: 923 setLoop: 0 play:)
				(victim
					view: 402
					setLoop: 0
					setCel: 0
					show:
					cycleSpeed: local4
					setCycle: End self
				)
			)
			(12
				(victim
					setLoop: 1
					setCel: 0
					posn: (- (victim x:) 15) (victim y:)
					cycleSpeed: local4
					setCycle: End self
				)
			)
			(13
				(victim hide:)
				(ptooie
					view: 402
					setLoop: 2
					setCel: 0
					posn: (+ (victim x:) 15) (victim y:)
					cycleSpeed: local4
					setCycle: End self
					show:
				)
			)
			(14
				(= local2 3)
				(= local3 402)
				(ptooie
					view: 402
					setLoop: 4
					setCel: 0
					posn: (+ (victim x:) 35) (- (victim y:) 2)
				)
				(gMessager say: 0 0 2 0 self) ; "Address the subject in this manner:"
			)
			(15
				(gMessager say: 0 0 3 0 self) ; "Please to notice the location of my hand as I begin the narcotic chant of cinematic morphine."
			)
			(16
				(gMessager say: 0 0 4 0 self) ; "So, as you can see, it is very effective. If you can apply a proper grip to the neck, it will disable nine out of ten neck-bearing species."
			)
			(17
				(ptooie setCel: 0 cycleSpeed: local4 setCycle: CT 5 1 self)
			)
			(18
				(sfxSound number: 408 setLoop: 0 play:)
				(ptooie cycleSpeed: local4 setCycle: CT 9 1 self)
			)
			(19
				(sfxSound number: 404 setLoop: 0 play:)
				(ptooie cycleSpeed: local4 setCycle: End self)
			)
			(20
				(victim
					hide:
					view: 403
					setPri: 300
					setLoop: 0
					setCel: 0
					posn: (+ (victim x:) 15) (victim y:)
				)
				(= ticks 20)
			)
			(21
				(if (sfxSound handle:)
					(sfxSound stop:)
				)
				(= local2 2)
				(= local3 400)
				(ptooie view: 400)
				(victim show:)
				(gMessager say: 0 0 5 0 self) ; "This completes our program. Thank you."
			)
			(22
				(= ticks 30)
			)
			(23
				(sfxSound number: 923 setLoop: 0 play:)
				(victim cycleSpeed: local4 setCycle: End self)
				(ptooie
					view: 400
					setLoop: 1
					setCel: 100
					cycleSpeed: local4
					setCycle: Beg self
				)
			)
			(24)
			(25
				(sfxSound number: 403 setLoop: 0 play: self)
				(ptooie hide:)
				(victim hide:)
				(projector
					setLoop: 0
					setCel: 100
					cycleSpeed: local4
					setCycle: Beg self
				)
			)
			(26)
			(27
				(projector hide:)
				(if (not (IsFlag 141))
					(gGame points: 3)
				)
				(SetFlag 141)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 5)
			)
			(1
				(sfxSound number: 941 loop: 1 play:)
				(= ticks 55)
			)
			(2
				(gEgo
					view: 364
					loop: 0
					cel: 0
					posn: 39 127
					setSpeed: local4
					setCycle: End self
					init:
				)
			)
			(3
				(gEgo normalize: loop: 2)
				(= local9 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitThruComPost of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180)
				(= ticks 170)
			)
			(1
				(sfxSound number: 926 loop: 1 play:)
				(= ticks 60)
			)
			(2
				(gEgo
					view: 3630
					loop: 0
					cel: 0
					posn: 39 131
					setSpeed: local4
					setCycle: End self
					init:
				)
			)
			(3
				(gCurRoom newRoom: gComPostNextRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance projector of Prop
	(properties
		view 400
	)

	(method (init)
		(super init:)
		(self hide: posn: 175 36 setPri: 350)
	)
)

(instance ptooie of Prop
	(properties
		noun 26
		view 400
	)

	(method (init)
		(super init:)
		(self hide: posn: 198 108)
	)
)

(instance victim of Prop
	(properties
		view 402
	)

	(method (init)
		(super init:)
		(self hide: posn: 178 110)
	)
)

(instance holoControls of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 55
		approachY 122
		x 40
		y 84
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 32 70 49 70 49 95 32 99 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo setHeading: 270)
				(holoControlPanel init: rm400 rm400)
			)
			(1 ; Look
				(gEgo setScript: sLookControls)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance compost of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 39
		approachY 131
		x 38
		y 131
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 18 85 30 83 30 93 18 95 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 460)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tubeTop of Feature
	(properties
		noun 6
		sightAngle 40
		x 37
		y 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 20 0 55 0 55 15 44 17 29 17 20 15
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tubeBottom of Feature
	(properties
		noun 5
		sightAngle 40
		x 37
		y 129
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 23 132 28 132 43 132 51 132 56 129 52 127 47 126 31 126 25 126 19 129
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lights1 of Feature
	(properties
		noun 4
		sightAngle 40
		x 77
		y 98
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 54 105 98 88 101 91 57 109
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lights2 of Feature
	(properties
		noun 4
		sightAngle 40
		x 152
		y 14
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 150 0 150 28 154 28 154 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lights3 of Feature
	(properties
		noun 4
		sightAngle 40
		x 276
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 32 274 90 278 90 278 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lights4 of Feature
	(properties
		noun 4
		sightAngle 40
		x 116
		y 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 102 5 113 10 121 9 128 6 131 0 124 0 123 2 118 5 112 4 105 2
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lights5 of Feature
	(properties
		noun 4
		sightAngle 40
		x 225
		y 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 222 5 226 8 229 5 225 2 yourself:)
		)
		(super init: &rest)
	)
)

(instance floor of Feature
	(properties
		noun 9
		sightAngle 40
		x 182
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 105 93 105 93 48 122 64 129 53 136 316 136 316 115 241 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wall of Feature
	(properties
		noun 7
		sightAngle 40
		x 172
		y 59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 97 40 109 28 236 28 249 39 249 85 242 91 105 91 96 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance holoControlPanel of Inset
	(properties
		view 820
		x 100
		y 5
		disposeNotOnMe 1
		noun 3
	)

	(method (init)
		(super init: &rest)
		(b1 init:)
		(b2 init:)
		(b3 init:)
		(b4 init:)
		(b5 init:)
		(b6 init:)
		(b7 init:)
		(b8 init:)
		(b9 init:)
		(b0 init:)
		(enterButton init:)
		(clearButton init:)
		(onButton init:)
		(offButton init:)
		(deleteButton init:)
		(= local7 (Str new:))
		(= local6 (IntArray new:))
		(if local5
			(screen init: show:)
		else
			(screen init: hide:)
		)
	)

	(method (dispose)
		(if local5
			(while (> local8 0)
				((local6 at: (- local8 1)) dispose:)
				(-- local8)
			)
		)
		(local6 dispose:)
		(local7 dispose:)
		(super dispose: &rest)
	)
)

(instance sInvalid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 20)
			)
			(1
				(gGame handsOff:)
				(screen setCel: 1)
				(sfxSound number: 356 loop: 0 play: self)
			)
			(2
				(screen setCel: 0)
				(= ticks 10)
			)
			(3
				(screen setCel: 1)
				(sfxSound play: self)
			)
			(4
				(screen setCel: 0)
				(= ticks 10)
			)
			(5
				(screen setCel: 1)
				(sfxSound play:)
				(= ticks 100)
			)
			(6
				(screen setCel: 0)
				(enterButton setCel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPushButton of Script
	(properties)

	(method (init)
		(if (and (> local1 -1) (< local8 11))
			(addANumber doit: local1)
		)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfxSound number: 355 play:)
				(client setCel: 1)
				(= ticks 15)
			)
			(1
				(client setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance addANumber of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(++ local8)
		(= temp0 (Str format: {%d} param1))
		(local7 cat: temp0)
		(temp0 dispose:)
		(local6
			at:
				(- local8 1)
				((View new:)
					view: 820
					setLoop: 1
					setCel: param1
					init:
					posn: (+ (* (- local8 1) 4) 27) 50
					setPri: 400
					yourself:
				)
		)
	)
)

(instance screen of Prop
	(properties
		noun 25
		view 820
	)

	(method (init)
		(super init:)
		(self posn: 28 28 setPri: 301 setLoop: 2 setCel: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "You are looking at two computer screens. Yes two, the computer screen of your wimpy PC and the screen of our far superior holocabana that can "render" your PC worthless."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b1 of Prop
	(properties
		noun 11
		view 821
	)

	(method (init)
		(super init:)
		(self posn: 21 76 setPri: 300 setLoop: 1 setCel: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 1)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b2 of Prop
	(properties
		noun 12
		view 821
	)

	(method (init)
		(self posn: 29 76 setPri: 300 setLoop: 2)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 2)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b3 of Prop
	(properties
		noun 13
		view 821
	)

	(method (init)
		(self posn: 36 76 setPri: 300 setLoop: 3)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 3)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b4 of Prop
	(properties
		noun 14
		view 821
	)

	(method (init)
		(self posn: 21 83 setPri: 300 setLoop: 4)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 4)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b5 of Prop
	(properties
		noun 15
		view 821
	)

	(method (init)
		(self posn: 29 83 setPri: 300 setLoop: 5)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 5)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b6 of Prop
	(properties
		noun 16
		view 821
	)

	(method (init)
		(self posn: 36 83 setPri: 300 setLoop: 6)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 6)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b7 of Prop
	(properties
		noun 17
		view 821
	)

	(method (init)
		(self posn: 21 90 setPri: 300 setLoop: 7)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 7)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b8 of Prop
	(properties
		noun 18
		view 821
	)

	(method (init)
		(self posn: 29 90 setPri: 300 setLoop: 8)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 8)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b9 of Prop
	(properties
		noun 19
		view 821
	)

	(method (init)
		(self posn: 36 90 setPri: 300 setLoop: 9)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 9)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance b0 of Prop
	(properties
		noun 10
		view 821
	)

	(method (init)
		(self posn: 29 96 setPri: 300 setLoop: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This is one of the number keys, as indicated by the strategically placed numbers on it. I can see where you'd be confused."
			)
			(4 ; Do
				(if local5
					(= local1 0)
					(self setScript: sPushButton 0)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clearButton of Prop
	(properties
		noun 21
		view 821
	)

	(method (init)
		(self posn: 46 79 setPri: 300 setLoop: 10)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This clears the previous entry."
			)
			(4 ; Do
				(if local5
					(= local1 -1)
					(while (> local8 0)
						((local6 at: (- local8 1)) dispose:)
						(-- local8)
					)
					(local7 dispose:)
					(= local7 (Str new:))
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance deleteButton of Prop
	(properties
		noun 22
		view 821
	)

	(method (init)
		(self posn: 44 83 setPri: 300 setLoop: 11)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This deletes the entry."
			)
			(4 ; Do
				(if local5
					(= local1 -1)
					(if (> local8 0)
						((local6 at: (- local8 1)) dispose:)
						(-- local8)
					)
					(= local7 (local7 subStr: 0 local8))
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance enterButton of Prop
	(properties
		noun 20
		view 821
	)

	(method (init)
		(self posn: 44 90 setPri: 300 setLoop: 12)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "This begins execution of your entry."
			)
			(4 ; Do
				(if local5
					(= local1 -1)
					(self setScript: sPushButton)
					(if (local7 compare: local10)
						(holoControlPanel dispose:)
						(gEgo setScript: sRunProgram)
					else
						(self setScript: sInvalid)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance onButton of Prop
	(properties
		noun 23
		view 821
	)

	(method (init)
		(self posn: 90 41 setPri: 300 setLoop: 13)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "No real mystery as to what this does -- at least there'd better not be!"
			)
			(4 ; Do
				(if (not local5)
					(= local1 -1)
					(if (> local8 0)
						((local6 at: (- local8 1)) dispose:)
						(-- local8)
					)
					(= local7 (local7 subStr: 0 local8))
					(= local5 1)
					(screen show:)
					(= local1 -1)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance offButton of Prop
	(properties
		noun 24
		view 821
	)

	(method (init)
		(self posn: 88 55 setPri: 300 setLoop: 14)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb) ; "No real mystery as to what this does -- at least there'd better not be!"
			)
			(4 ; Do
				(if local5
					(= local5 0)
					(while (> local8 0)
						((local6 at: (- local8 1)) dispose:)
						(-- local8)
					)
					(local7 dispose:)
					(= local7 (Str new:))
					(screen hide:)
					(= local1 -1)
					(self setScript: sPushButton)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sfxSound of Sound
	(properties
		loop 0
	)
)

