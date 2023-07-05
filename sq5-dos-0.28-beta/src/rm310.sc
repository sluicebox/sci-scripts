;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm310 0
)

(instance rm310 of Rm
	(properties
		noun 7
		picture 61
	)

	(method (init)
		(self setRegions: 350) ; kiz
		(LoadMany rsVIEW 419 402 401)
		(NormalEgo 0)
		(gEgo actions: (ScriptID 350 1)) ; yoFlo
		(switch gPrevRoomNum
			(300
				(= style -32758)
				(gCurRoom setScript: sEnterFromTunnelA)
			)
			(305
				(= style 11)
				(gEgo
					setScale: Scaler 100 48 172 123
					init:
					edgeHit: 0
					posn: 308 159
				)
				(gGame handsOn:)
			)
			(else
				(= style -32758)
				(gCurRoom setScript: sEnterFromTunnelB)
			)
		)
		(tunnelA init: setOnMeCheck: 1 2)
		(tunnelB init: setOnMeCheck: 1 4)
		(bush init: setOnMeCheck: 1 32)
		(fern init: setOnMeCheck: 1 64)
		(outcrop init: setOnMeCheck: 1 128)
		(path init: setOnMeCheck: 1 256)
		(wd40 init:)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 180 122 164 129 146 148 146 176 227 182 290 173 319 149 319 138 307 145 269 125 253 132 276 147 278 150 269 154 244 159 215 159 205 150 204 135 197 127 186 123 185 98 176 105
					yourself:
				)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			(
				(and
					(== (= temp0 (gEgo onControl: 1)) 8)
					(not (wd40 script:))
					(not (== gPrevRoomNum 315))
					(or (not (IsFlag 14)) (IsFlag 15))
				)
				(wd40 setScript: sWD40Appear)
			)
			((and (== temp0 2) (not (gCurRoom script:)))
				(gCurRoom setScript: sExitViaTunnelB)
			)
			((and (== temp0 4) (not (gCurRoom script:)))
				(gCurRoom setScript: sExitViaTunnelA)
			)
			((and (== temp0 16384) (not (gCurRoom script:)))
				(gCurRoom setScript: sExitViaScroll)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 16)
					(gMessager say: noun theVerb 2 0) ; "Sunlight shines down warmly from above on this little alcove."
				else
					(gMessager say: noun theVerb 1 0) ; "This shady little alcove looks like it would be a nice place to stop, pitch a tent, and camp out for awhile--if only you weren't running for you life at the moment."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sEnterFromTunnelA of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 255
					y: 125
					setScale: Scaler 100 48 172 123
					init:
					setMotion: MoveTo 298 152 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitViaTunnelA of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 255 135 self)
			)
			(1
				(gCurRoom newRoom: 300)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromTunnelB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					x: 178
					y: 110
					setScale: Scaler 100 48 172 123
					init:
					setMotion: MoveTo 186 131 self
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitViaTunnelB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 182 109 self)
			)
			(1
				(gCurRoom newRoom: 315)
				(self dispose:)
			)
		)
	)
)

(instance sExitViaScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 335 144 self)
			)
			(1
				(gCurRoom newRoom: 305)
			)
		)
	)
)

(instance sWD40Appear of Script
	(properties)

	(method (doit)
		(if (> (gEgo y:) 144)
			(cond
				((< 2 state 6)
					(= ticks (= seconds 0))
					(= state 5)
					(self cue:)
				)
				((== state 0)
					(self dispose:)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 7)
			)
			(1
				(gGame handsOff:)
				(gSq5Music1 number: 35 loop: -1 play:)
				(if (IsFlag 15)
					(wd40
						view: 419
						cel: 5
						x: 253
						y: 0
						setLoop: -1
						setLoop: 0
						setCycle: 0
						setMotion: MoveTo 255 43 self
					)
				else
					(gSq5Music2 number: 404 setLoop: 1 play:)
					(wd40 loop: 0 cel: 0 setCycle: CT 5 1 self)
				)
			)
			(2
				(wd40 setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(if (== (gCurRoom script:) sExitViaTunnelB)
					(self dispose:)
				else
					(SetFlag 66)
					(gSq5Music2 number: 402 setLoop: 1 play:)
					(fireBall
						view: 402
						loop: 0
						cel: 0
						x: 245
						y: 19
						setStep: 15 5
						moveSpeed: 0
						init:
						setMotion:
							MoveTo
							(+ (gEgo x:) 7)
							(- (gEgo y:) 10)
							self
					)
				)
			)
			(4
				(gSq5Music2 number: 4021 setLoop: 1 play:)
				(fireBall view: 401 loop: 4 cel: 0 setCycle: End self)
			)
			(5
				(fireBall dispose:)
				(= seconds 7)
			)
			(6
				(if (== (gCurRoom script:) sExitViaTunnelB)
					(self dispose:)
				else
					(gSq5Music2 number: 402 setLoop: 1 play:)
					(fireBall
						view: 402
						loop: 0
						cel: 0
						x: 245
						y: 19
						setStep: 15 5
						moveSpeed: 0
						init:
						setMotion:
							MoveTo
							(+ (gEgo x:) 2)
							(- (gEgo y:) 18)
							self
					)
				)
			)
			(7
				(fireBall dispose:)
				(cond
					((<= 45 (gEgo heading:) 135)
						(gEgo loop: 3)
					)
					((<= 136 (gEgo heading:) 225)
						(gEgo loop: 0)
					)
					((<= 226 (gEgo heading:) 315)
						(gEgo loop: 2)
					)
					(else
						(gEgo loop: 1)
					)
				)
				(gEgo view: 401 cel: 0 setCycle: End self)
			)
			(8
				(EgoDead 17) ; "Nice reflexes. We'll mail your remains home in an envelope."
				(self dispose:)
			)
		)
	)
)

(instance wd40 of Actor
	(properties
		x 257
		y 43
		yStep 6
		view 419
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(if
			(not
				(and
					(== (self view:) 419)
					(== (self loop:) 0)
					(== (self cel:) 0)
				)
			)
			(gMessager say: 4 theVerb 0 0 0 301)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fireBall of Actor
	(properties
		x 245
		y 19
		view 402
	)
)

(instance tunnelA of Feature
	(properties
		x 303
		y 128
		noun 3
		onMeCheck 2
	)
)

(instance tunnelB of Feature
	(properties
		x 186
		y 114
		noun 2
		onMeCheck 4
	)
)

(instance bush of Feature
	(properties
		x 174
		y 54
		noun 1
		onMeCheck 32
	)
)

(instance fern of Feature
	(properties
		x 267
		y 166
		noun 4
		onMeCheck 64
	)
)

(instance outcrop of Feature
	(properties
		x 259
		y 41
		noun 5
		onMeCheck 128
	)
)

(instance path of Feature
	(properties
		x 206
		y 161
		noun 6
		onMeCheck 256
	)
)

