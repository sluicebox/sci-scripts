;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	rm720 0
)

(local
	local0 = 7
	local1
	local2
	local3
	local4
)

(instance rm720 of SQRoom
	(properties
		noun 1
		picture 720
	)

	(method (init)
		(gGSound1 number: 600 setLoop: -1 play: setVol: 127)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 316 12 274 74 250 87 224 110 208 118 167 131 135 134 102 134 76 129 48 118 16 95 7 95 7 136 316 136 316 117
					yourself:
				)
		)
		(super init:)
		(gEgo init: setScript: sEnterRoom)
		(Load 140 692) ; WAVE
		(Load 140 691) ; WAVE
		(Load 140 702) ; WAVE
		(Load 140 701) ; WAVE
		(bubbles1 init:)
		(bubbles2 init:)
		(bubbles3 init:)
		(drip1 init:)
		(drip2 init:)
		(drip3 init:)
		(drip4 init:)
		(drip5 init:)
		(drip6 init:)
		(wave1 init:)
		(wave2 init:)
		(pool init:)
		(mucosa init:)
		(vessel init: hide:)
		(vessel2 init:)
		(if (not (IsFlag 105))
			(vessel2 hide:)
		)
		(exit700 init: gTheExitECursor)
		(gWalkHandler addToFront: gCurRoom)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 3) ; Walk
			(super doVerb: theVerb)
		else
			(self setScript: sDoNothing)
		)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(gGSound1 fade: 0 3 1 1)
		(super dispose:)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance sPumpBile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 723
					posn: 220 128
					setCel: 0
					setLoop: 0
					cycleSpeed: local0
				)
				(if (IsFlag 104)
					(gEgo setLoop: 1)
				)
				(gEgo setCycle: End self)
			)
			(1
				(helmet init: setCel: 0 setLoop: 0)
				(if (IsFlag 104)
					(helmet setLoop: 5)
				else
					(helmet setLoop: 4)
				)
				(gEgo
					view: 724
					setCel: 0
					setLoop: 0
					cycleSpeed: local0 1
					put: 88 ; Pump_With_Hose
					setCycle: CT 23 1 self
				)
			)
			(2
				(= local2 1)
				(gGSound2 number: 702 setLoop: 0 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gMessager say: 2 138 0 0 self) ; "You chuck one of the taped capillaries over the muscular ledge. It drops into the pool."
			)
			(4
				(vessel2 show:)
				(gEgo view: 725 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(5
				(gGSound2 number: 701 setLoop: -1 play:)
				(gEgo view: 725 setLoop: 1 setCel: 0 setCycle: Fwd)
				(vessel
					show:
					view: 725
					setCel: 0
					setLoop: 3
					posn: 130 124
					setPri: 200
					cycleSpeed: (- local0 3)
					setCycle: End self
				)
			)
			(6
				(vessel cycleSpeed: (- local0 4) setCycle: Fwd)
				(helmet cycleSpeed: 55 setPri: 129 setCel: 0 setCycle: End self)
			)
			(7
				(vessel setCycle: End self)
			)
			(8
				(vessel hide:)
				(gGSound2 setLoop: 0 number: 701 play:)
				(= local2 0)
				(gEgo setCycle: End self)
			)
			(9
				(gEgo setLoop: 0 setCel: 100 setCycle: Beg self)
			)
			(10
				(gMessager say: 4 4 0 0 self) ; "You give the pump a stroke or two, and in the process gather a nice helmet-load of bile. I guess congratulations are in order."
			)
			(11
				(gEgo
					view: 7230
					posn: 220 128
					setCel: 0
					setLoop: 0
					cycleSpeed: local0
				)
				(if (IsFlag 104)
					(gEgo setLoop: 1)
				)
				(helmet hide:)
				(vessel2 view: 726 setCel: 0 setLoop: 0)
				(gEgo setCycle: End self)
			)
			(12
				(vessel dispose:)
				(SetFlag 105)
				(if (IsFlag 104)
					(gEgo put: 44) ; Eva_Full_Enz
					(gEgo get: 43) ; Eva_Full_Both
				else
					(gEgo put: 45) ; Eva_Helmet
					(gEgo get: 42) ; Eva_Full
				)
				(gGame points: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoNothing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 5)
			)
			(1
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
				(gEgo setStep: 1 1 0)
				(= ticks 1)
			)
			(1
				(= local4 (gEgo moveSpeed:))
				(gEgo
					view: 722
					posn: 300 204
					setLoop: 0 1
					setCycle: Walk
					setSpeed: 3
					setMotion: MoveTo 211 103 self
				)
			)
			(2
				(gEgo
					posn: 220 128
					setLoop: 1
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3
				(gEgo setSpeed: local4)
				(gCurRoom cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setStep: 1 1 0)
				(= ticks 1)
			)
			(1
				(= local4 (gEgo moveSpeed:))
				(gEgo
					view: 722
					posn: 211 103
					setPri: 300
					setLoop: 0 1
					cycleSpeed: 4
					setSpeed: 4
					setCycle: Rev
					setMotion: MoveTo 300 204 self
				)
			)
			(2
				(gEgo setSpeed: local4)
				(gCurRoom newRoom: 700)
				(self dispose:)
			)
		)
	)
)

(instance sDripScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client hide:)
				(= ticks (RandomNumber 100 400))
			)
			(1
				(if (== (client loop:) 0)
					(client show: cycleSpeed: local0 setCycle: CT 10 1 self)
				else
					(client show: cycleSpeed: local0 setCycle: CT 13 1 self)
				)
			)
			(2
				(client cycleSpeed: local0 setCycle: End self)
			)
			(3
				(client setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sBubbleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client hide:)
				(= ticks (RandomNumber 100 400))
			)
			(1
				(switch (client loop:)
					(1
						(client show: cycleSpeed: local0 setCycle: CT 8 1 self)
					)
					(2
						(client show: cycleSpeed: local0 setCycle: CT 10 1 self)
					)
					(3
						(client show: cycleSpeed: local0 setCycle: CT 12 1 self)
					)
				)
			)
			(2
				(if (and (not local2) (not local3))
					(= local3 1)
					(gGSound2 setLoop: 0 number: 691 play:)
				)
				(client cycleSpeed: local0 setCycle: End self)
			)
			(3
				(= ticks 20)
			)
			(4
				(= local3 0)
				(client setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sWaveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client hide:)
				(= ticks (RandomNumber 150 300))
			)
			(1
				(client show: cycleSpeed: (- local0 2) setCycle: End self)
			)
			(2
				(client setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sLowerCap of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 221 121 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance vessel of Prop
	(properties
		x 130
		y 124
		view 725
		loop 2
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 2 115 1 1 0 690) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
			)
			(1 ; Look
				(gMessager say: 4 theVerb) ; "It's the same pump you've been carrying around. Now it just happens to be attached to a bunch of duct-taped segments of capillaries."
			)
		)
	)
)

(instance vessel2 of Prop
	(properties
		noun 4
		x 130
		y 124
		view 725
		loop 3
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 2 115 1 1 0 690) ; "You've got plenty of that stuff, or did you want to take some home to Mom?"
			)
			(1 ; Look
				(gMessager say: 4 theVerb) ; "It's the same pump you've been carrying around. Now it just happens to be attached to a bunch of duct-taped segments of capillaries."
			)
		)
	)
)

(instance helmet of Prop
	(properties
		view 725
		loop 4
		signal 20513
	)

	(method (init)
		(super init:)
		(self posn: 193 128)
	)
)

(instance bubbles1 of Prop
	(properties
		noun 5
		view 721
	)

	(method (init)
		(super init:)
		(self setLoop: 1 setCel: 0 posn: 165 65 setScript: (sBubbleScript new:))
	)
)

(instance bubbles2 of Prop
	(properties
		noun 5
		view 721
	)

	(method (init)
		(super init:)
		(self setLoop: 2 setCel: 0 posn: 70 90 setScript: (sBubbleScript new:))
	)
)

(instance bubbles3 of Prop
	(properties
		noun 5
		view 721
	)

	(method (init)
		(super init:)
		(self setLoop: 3 setCel: 0 posn: 237 76 setScript: (sBubbleScript new:))
	)
)

(instance drip1 of Prop
	(properties
		noun 5
		view 720
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 posn: 29 64 setScript: (sDripScript new:))
	)
)

(instance drip2 of Prop
	(properties
		noun 5
		view 720
	)

	(method (init)
		(super init:)
		(self setLoop: 1 setCel: 0 posn: 49 14 setScript: (sDripScript new:))
	)
)

(instance drip3 of Prop
	(properties
		noun 5
		view 720
	)

	(method (init)
		(super init:)
		(self setLoop: 2 setCel: 0 posn: 89 14 setScript: (sDripScript new:))
	)
)

(instance drip4 of Prop
	(properties
		noun 5
		view 720
	)

	(method (init)
		(super init:)
		(self setLoop: 3 setCel: 0 posn: 103 22 setScript: (sDripScript new:))
	)
)

(instance drip5 of Prop
	(properties
		noun 5
		view 720
	)

	(method (init)
		(super init:)
		(self setLoop: 4 setCel: 0 posn: 144 15 setScript: (sDripScript new:))
	)
)

(instance drip6 of Prop
	(properties
		noun 5
		view 720
	)

	(method (init)
		(super init:)
		(self setLoop: 5 setCel: 0 posn: 246 45 setScript: (sDripScript new:))
	)
)

(instance wave1 of Prop
	(properties
		noun 6
		view 721
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 posn: 141 47 setScript: (sWaveScript new:))
	)
)

(instance wave2 of Prop
	(properties
		noun 6
		view 721
	)

	(method (init)
		(super init:)
		(self setLoop: 0 setCel: 0 posn: 141 47 setScript: (sWaveScript new:))
	)
)

(instance mucosa of Feature
	(properties
		noun 3
		sightAngle 40
		x 138
		y 38
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 0 71 6 77 13 76 42 62 43 57 51 59 70 53 71 50 81 50 94 47 96 44 105 46 113 44 124 43 133 42 136 40 144 42 153 42 158 40 162 41 171 38 179 41 186 41 191 40 194 42 213 43 220 43 225 45 230 43 233 47 238 48 242 48 243 51 251 53 254 53 257 55 268 60 272 60 273 63 276 59 270 47 257 35 246 25 237 17 224 9 209 2 203 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "If you're feeling froggy, swim on over there."
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "If I'm not mistaken -- and I seldom am -- that's the mucosa, or inner lining of the gall bladder. It helps make the bile even more vile by absorbing spare water content."
			)
			(26 ; ???
				(gMessager say: noun theVerb) ; "Naw, that's not a good idea."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pool of Feature
	(properties
		noun 2
		sightAngle 40
		x 138
		y 85
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 14 79 24 72 43 63 43 60 52 60 73 53 73 52 82 52 96 49 97 46 100 46 105 47 113 47 114 44 121 44 124 45 135 43 136 42 143 42 149 43 158 42 165 42 170 40 179 42 187 42 190 41 195 43 214 44 218 43 220 46 226 47 229 44 231 45 231 48 239 50 241 50 252 55 254 54 269 62 271 64 268 67 265 70 253 75 242 82 231 91 221 100 218 104 206 111 182 117 164 124 141 129 115 130 104 129 80 123 55 112 36 100 20 89 11 85 6 80
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: noun theVerb) ; "You have no need to touch the bile."
			)
			(1 ; Look
				(gMessager say: noun theVerb) ; "Wow, check out all that bile. Looks like her liver's been doing just fine. That's a pool of bile any liver would be proud of. You sure can't speak highly of its aroma."
			)
			(138 ; Attach_Caps
				(gMessager say: 0 0 12 0 0 98) ; "So close, and yet so far away."
			)
			(159 ; Pump_With_Hose
				(cond
					((not (or (gEgo has: 44) (gEgo has: 45))) ; Eva_Full_Enz, Eva_Helmet
						(gMessager say: 4 4 1) ; "Now, if you just had something to collect the bile in, you'd be all set."
					)
					((not (IsFlag 105))
						(gEgo setScript: sPumpBile)
					)
					(else
						(gMessager say: 0 0 0) ; "You already have plenty of that -- or did you want to take some back to Mom?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit700jnk of ExitFeature ; UNUSED
	(properties
		approachX 305
		approachY 73
		nextRoom 700
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 319 114 319 138 244 138 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; ExitRight
			(gEgo setScript: sLeaveRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance exit700 of ExitFeature
	(properties
		approachX 305
		approachY 73
		nextRoom 700
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 319 114 319 138 173 138 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; ExitRight
			(gEgo setScript: sLeaveRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance notAnExit of Feature ; UNUSED
	(properties
		x 159
		y 269
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 115 319 0 0 0 0 138 188 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

