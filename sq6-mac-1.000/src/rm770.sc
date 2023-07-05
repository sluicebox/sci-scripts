;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 770)
(include sci.sh)
(use Main)
(use SQRoom)
(use n666)
(use Styler)
(use Talker)
(use ROsc)
(use Osc)
(use RandCycle)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use WalkieTalkie)
(use DPath)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm770 0
	Sharpei 1
)

(local
	local0
)

(instance rm770 of SQRoom
	(properties
		noun 1
		picture 770
	)

	(method (updateRect)
		(return
			(if (IsFlag 202)
				(super updateRect:)
			else
				0
			)
		)
	)

	(method (init)
		(Load rsSCRIPT 64939)
		(Load rsHEAP 64939)
		(gEgo setScale: 0 normalize: 1 posn: 188 51 init:)
		(gGSound1 number: 7701 setLoop: -1 play:)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 281 257 225 270 196 270 139 257 126 260 165 276 311 276 311 246
					yourself:
				)
			setScript: sTumbleDown
		)
		(sharpe init:)
		(headsection init:)
		(drill init:)
		(shovel init:)
		(turret init:)
		(pile init:)
		(cart init:)
		(nerves init: approachVerbs: 140) ; Paperclip
		(nervesFX init: setCycle: RandCycle)
		(nerves2FX init: setCycle: RandCycle)
		(nerves3FX init: setCycle: RandCycle)
		(belt init: approachVerbs: 4) ; Do
		(laserFire init:)
		(if (not (IsFlag 202))
			((gCurRoom plane:) setRect: 0 -138 319 222)
			(UpdatePlane plane)
		)
	)

	(method (cue)
		(if (not script)
			(gEgo setSpeed: global158 setMotion: 0 setCycle: 0 normalize: 1)
			(gGame handsOn:)
		else
			(gEgo view: 775 setLoop: 1 setCel: 0)
			(if
				(or
					(== (sTumbleDown state:) 10)
					(== (sTumbleDown state:) 13)
					(== (sTumbleDown state:) 16)
					(and
						(== (gCurRoom script:) sGrabAndShoot)
						(== (sGrabAndShoot state:) 16)
					)
				)
				(gEgo setSpeed: 6 setCycle: RandCycle)
			)
		)
	)

	(method (dispose)
		((gCurRoom plane:) setRect: 0 0 319 138)
		(super dispose: &rest)
	)
)

(instance sTumbleDown of Script
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(if (and (IsFlag 202) (< state 11))
			(= temp0 ((gCurRoom plane:) left:))
			(= temp1 ((gCurRoom plane:) top:))
			(= temp2 ((gCurRoom plane:) right:))
			(= temp3 ((gCurRoom plane:) bottom:))
			(cond
				((< state 3)
					((gCurRoom plane:)
						setRect: temp0 (- temp1 2) temp2 (- (+ temp1 360) 2)
					)
				)
				((>= temp1 -136)
					((gCurRoom plane:)
						setRect: temp0 (- temp1 3) temp2 (- (+ temp1 360) 3)
					)
				)
				(else
					((gCurRoom plane:) setRect: temp0 -138 temp2 222)
				)
			)
			(UpdatePlane (gCurRoom plane:))
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(Load 140 265) ; WAVE
				(Load 140 441) ; WAVE
				(gEgo
					view: 770
					setLoop: 0 1
					setCel: 0
					setSpeed: 6
					setCycle: CT 1 1 self
				)
			)
			(1
				1
				(sfx number: 441 setLoop: 1 play:)
				(gEgo setCycle: CT 8 1 self)
			)
			(2
				2
				(sfx number: 441 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				3
				(sfx number: 441 setLoop: 1 play:)
				(gEgo setLoop: 1 1 x: 225 y: 92 setCel: 0 setCycle: End self)
			)
			(4
				4
				(sfx number: 441 setLoop: 1 play:)
				(gEgo
					setLoop: 2 1
					x: 228
					y: 145
					setCel: 0
					setCycle: CT 1 1 self
				)
			)
			(5
				5
				(gEgo setStep: 3 5 1 setMotion: MoveTo 228 145 self)
			)
			(6
				6
				(gMessager say: 0 0 1 1) ; "Oooofff!! (SOUNDS THAT WOULD BE GENERATED DURING A TUMBLE)"
				(gEgo
					setLoop: 3 1
					x: 211
					y: 218
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(7
				7
				(gEgo setCycle: End self)
				(sfx number: 265 setLoop: 1 play:)
			)
			(8
				8
				(ShakePlane gThePlane 2 6 2)
				(= cycles 1)
				(motorSound setLoop: -1 play:)
				(drill setScript: sDrillActions)
			)
			(9
				9
				(= seconds 4)
			)
			(10
				10
				(gEgo
					setLoop: 4 1
					x: 209
					y: 277
					setCel: 0
					cycleSpeed: (* (gEgo cycleSpeed:) 2)
					setCycle: End gCurRoom
				)
				(gMessager say: 0 0 1 2 self) ; "Owww!!! Even in this suit, that hurts like a ... (REALIZATION) Geez. What's going on here and what's with that big robot?!"
			)
			(11
				11
				(if (!= (gEgo loop:) 770)
					(gEgo
						setSpeed: global158
						setMotion: 0
						setCycle: 0
						normalize: 1
					)
				)
				(gMessager sayRange: 0 0 1 3 7 self) ; "Well, well, Mr. Wilco. I must confess to being impressed that you made it this far. You are either a very lucky man or the classic case of how looks can be deceiving."
			)
			(12
				12
				(gEgo view: 775 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(13
				13
				(gEgo setLoop: 1 setSpeed: 6 setCycle: RandCycle)
				(gMessager say: 0 0 1 8 self) ; "(TO HIMSELF) Geez, what a bit ...(INTERRUTED BY SHARPEI)"
			)
			(14
				14
				(gEgo setCycle: 0 setCel: 0)
				(gMessager say: 0 0 1 9 self) ; "I'm sorry, what was that you were saying?!"
			)
			(15
				15
				(gEgo view: 775 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(16
				16
				(gEgo setLoop: 1 setSpeed: 6 setCycle: RandCycle)
				(gMessager say: 0 0 1 10 self) ; "Me? Uh, I was, uh, I was saying, uh, "What a bite." Yeah, I had a little trouble with some parasites a while ago down in the digestive tract. That's all it was."
			)
			(17
				17
				(gEgo
					setSpeed: global158
					setMotion: 0
					setCycle: 0
					setSpeed: global158
					normalize: 1
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRogerOffersFish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fishTimer client: 0)
				(gGame handsOff:)
				(Load rsVIEW 7781 779 7782 7782 7790)
				(Load 140 265) ; WAVE
				(= cycles 1)
			)
			(1
				(sharpe
					view: 7781
					loop: 0
					cel: 0
					posn: 44 214
					setCycle: End self
				)
			)
			(2
				(gMessager say: 0 0 6 1 self) ; "Fish! That's brain food!"
			)
			(3
				(sharpe view: 7782 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(ClearFlag 208)
				(sharpe view: 779 loop: 0 cel: 0)
				(gEgo
					view: 7782
					loop: 1
					cel: 0
					posn: 236 250
					setSpeed: 8
					show:
					setCycle: CT 2 1 self
				)
			)
			(5
				(gEgo setCycle: End self)
				(sfx number: 265 setLoop: 1 play:)
			)
			(6
				(gEgo normalize: 7 posn: 281 272)
				(sharpe setCycle: End self)
			)
			(7
				(gGame points: 5 487)
				(gMessager say: 0 0 6 2) ; "(MOANING IN AGONY AS SHE DIES) Ahhhhhhhh!"
				(sharpe
					view: 7790
					loop: 0
					cel: 0
					posn: 43 217
					signal: (| $0800 (sharpe signal:))
					setCycle: CT 12 1 self
				)
			)
			(8
				(sharpe setCycle: End setMotion: MoveTo 43 365 self)
				(gGSound1 number: 7702 setLoop: -1 play:)
				(gEgo setHeading: 225)
			)
			(9
				(gEgo view: 775 setLoop: 3 setCycle: RandCycle)
				(gMessager say: 0 0 6 3 self) ; "All right! She actually chowed down on that rancid fish!"
			)
			(10
				(gMessager say: 0 0 6 5 self) ; "I thought I'd never get rid of that fish."
			)
			(11
				(gEgo normalize: 5 setMotion: MoveTo 350 280 self)
			)
			(12
				(gEgo setSpeed: global158)
				(gGSound1 fade:)
				(gCurRoom newRoom: 600)
				(self dispose:)
			)
		)
	)
)

(instance sGrabAndShoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(Load rsVIEW 773 774 7740)
				(Load 140 777) ; WAVE
				(Load 140 922) ; WAVE
				(Load 140 7703) ; WAVE
				(= cycles 1)
			)
			(1
				1
				(gEgo
					view: 773
					loop: 0
					cel: 0
					posn: 301 267
					setSpeed: 8
					setCycle: CT 12 1 self
				)
				(headsection setCycle: End)
				(turret setCycle: End)
				(drill setScript: 0 setCycle: End)
				(shovel setCycle: End)
			)
			(2
				2
				(gEgo setCycle: End self)
				(sfx number: 776 setLoop: 1 play:)
				(laserFire posn: 266 223 setCel: 0 setCycle: End laserFire z: 0)
			)
			(3
				3
				(gEgo
					view: 774
					loop: 0
					cel: 0
					posn: 189 277
					setCycle: End self
				)
				(sfx number: 777 play:)
				(laserFire posn: 200 200 setCel: 0 setCycle: End z: 0)
			)
			(4
				4
				(gGame points: 5 486)
				(headsection dispose:)
				(turret dispose:)
				(drill dispose:)
				(shovel dispose:)
				(sharpe
					view: 7740
					loop: 0
					cel: 0
					posn: 10 278
					setCycle: RandCycle
				)
				(sfx number: 922 play:)
				(motorSound stop:)
				(= cycles 1)
			)
			(5
				5
				(= ticks 90)
			)
			(6
				6
				(= local0 1)
				(gEgo
					put: 76 ; Paperclip
					posn: 290 262
					setLoop: 1 1
					cel: 0
					setCycle: End
				)
				(= gAutoRobot
					((WalkieTalkie new:)
						init: 0 7741 self
						x: -18
						y: 126
						priority: 200
						start:
						yourself:
					)
				)
				(sharpe hide: view: (gEgo view:))
			)
			(7
				7
				(gEgo loop: 2 cel: 0 setCycle: End self)
				(gGSound1 number: 7702 setLoop: -1 play:)
				(sfx number: 7703 setLoop: 1 play:)
			)
			(8
				8
				(gEgo
					normalize: 1
					posn: 292 266
					setMotion: DPath 219 275 147 268 self
				)
			)
			(9
				9
				(gEgo setHeading: 270 self)
			)
			(10
				10
				(gEgo
					view: 780
					setSpeed: 6
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(11
				11
				(gEgo setLoop: 1 setCel: 0 setCycle: ForwardCounter 3 self)
			)
			(12
				12
				(Load rsVIEW 7760 7761)
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(13
				13
				(gMessager say: 12 0 0 1 self) ; "Wow! That was actually a great idea! Go figure."
			)
			(14
				(gEgo view: 775 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(15
				15
				(gEgo setLoop: 3 setSpeed: 6 setCycle: RandCycle)
				(gMessager sayRange: 12 0 0 2 5 self) ; "Yeah, I kicked her butt. Just look at me. MacGyver wishes he could be me."
			)
			(16
				16
				(gGSound1 number: 7704 setLoop: -1 play:)
				(gMessager say: 12 0 0 6) ; "Ahhh! What? But I thought I took care of you!"
				(gEgo
					view: 902
					setLoop: 5 1
					setCel: 11
					setCycle: Beg
					setMotion:
						MoveTo
						(+ (gEgo x:) 10)
						(- (gEgo y:) 5)
						gCurRoom
				)
				(= gAutoRobot
					((WalkieTalkie new:)
						init: 0 776 self
						x: 36
						y: 121
						priority: 200
						start:
						yourself:
					)
				)
			)
			(17
				17
				(sharpe
					view: 7760
					show:
					setLoop: 0 1
					setCel: 0
					x: 37
					y: 170
					cycleSpeed: 6
					doit:
					setCycle: Fwd
				)
				(gEgo normalize: 7)
				(gMessager say: 12 0 0 7 self) ; "Well, it appears you thought wrong, now doesn't it, Roger?"
			)
			(18
				18
				(gMessager say: 13 0 0 0 self) ; "Wilco! I haven't survived this long without taking precautions. The robot was just hardware. My mind still exists."
			)
			(19
				19
				(sharpe
					view: 7761
					setLoop: 0 1
					setCel: 1
					posn: 44 203
					setCycle: CT 7 1 self
				)
			)
			(20
				20
				(gMessager say: 12 0 0 8) ; "(SHE SNAGS ROGER WITH HER TENTACLES) Oooooff!!!"
				(gEgo hide: doit:)
				(SetFlag 208)
				(sharpe setCel: 8 doit: setCycle: End self)
			)
			(21
				21
				(gMessager say: 0 0 5 0 self) ; "Ahhhh! (SOUND OF BEING SQUEEZED TIGHTLY BY A TENTACLE)"
				(sharpe loop: 1 posn: 43 214 cel: 0 setCycle: Fwd)
			)
			(22
				22
				(gEgo setSpeed: global158)
				(fishTimer setReal: fishTimer 10)
				(gTheIconBar disable: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fishTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers isEmpty:)
			(gCurRoom setScript: sKillRog)
		else
			(self setReal: self 2)
		)
	)
)

(instance sKillRog of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sharpe view: 778 setLoop: 0 1 setCel: 0 setCycle: End self)
				(sfx number: 778 setLoop: 1 play:)
			)
			(1
				(proc666_0 17 self)
			)
			(2
				(sharpe
					view: 7761
					setLoop: 1 1
					posn: 43 214
					cel: 0
					setCycle: Fwd
				)
				(gGame handsOn:)
				(fishTimer setReal: fishTimer 10)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sTurretRetract of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(turret setLoop: 0 1 setCel: 3 setCycle: Beg self)
			)
			(1
				(turret view: 7711 loop: 0)
				(turret cel: (turret lastCel:) setCycle: Beg)
				(= cycles 5)
			)
			(2
				(drill setScript: sDrillActions)
				(headsection setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sAttemptGetaway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 7701 7711 7712)
				(= cycles 1)
			)
			(1
				(headsection setCycle: End)
				(gEgo
					view: 7701
					loop: 0
					cel: 0
					posn: 221 260
					setSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(2
				(gEgo setCycle: End)
				(turret setCycle: End self)
			)
			(3
				(turret view: 7712 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(gEgo loop: 1 cel: 0 posn: 262 215 setCycle: CT 1 1 self)
			)
			(5
				(turret setScript: sTurretShoot)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					view: 775
					posn: 296 259
					setLoop: 0
					setCel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(7
				(gEgo setLoop: 1 setCel: 0 setCycle: RandCycle)
				(gMessager say: 0 0 3 0 self) ; "Yeow! Guess she wasn't kidding about escape being a futile thing!"
			)
			(8
				(gMessager say: 0 0 4 0 self) ; "Hey! You could hurt me doing that!"
			)
			(9
				(gEgo normalize: 5 setSpeed: global158)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTurretShoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drill setScript: 0)
				(turret setLoop: 1 1 setCel: 0)
				(laserFire posn: 266 223 setCel: 0 setCycle: End laserFire z: 0)
				(laserSFX play:)
				(= cycles 6)
			)
			(1
				(turret setCycle: End self)
			)
			(2
				(turret setLoop: 2 1 setCel: 0 setCycle: CT 5 1 self)
			)
			(3
				(turret setCycle: End self)
				(laserFire posn: 230 172 setCel: 0 z: 0 setCycle: End laserFire)
				(laserSFX play:)
			)
			(4
				(turret setScript: sTurretRetract)
			)
		)
	)
)

(instance sDrillActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(drillSound stop:)
				(client setCel: 0 setCycle: CT (proc0_8 3 6) 1 self)
				(headsection setCel: 0 setCycle: End self)
			)
			(1
				(client setCycle: ROsc (proc0_8 3 10) 9 14 self)
				(drillSound setLoop: -1 play:)
			)
			(2
				(headsection setCycle: Beg self)
				(client setCycle: CT (proc0_8 5 7) -1 self)
			)
			(3
				(if (== (client cel:) 5)
					(shovel setCycle: Osc 1 self)
				else
					(self changeState: 0)
				)
			)
			(4
				(self changeState: 0)
			)
		)
	)

	(method (dispose)
		(drillSound stop:)
		(motorSound stop:)
		(super dispose: &rest)
	)
)

(instance sharpe of Actor
	(properties
		noun 3
		x 12
		y 252
		view 771
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local0
					(gMessager say: 2 1) ; "My, she has a different look now. I don't know which I like better!"
				else
					(gMessager say: 3 1) ; "It's the robot Sharpei is using -- just as Dr. Beleauxs told you about!"
				)
			)
			(74 ; Dead_Fish
				(if (== (sharpe view:) 771)
					(super doVerb: theVerb)
				else
					(gEgo put: 30) ; Dead_Fish3
					(gEgo setScript: sRogerOffersFish)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance headsection of Prop
	(properties
		noun 6
		x 21
		y 189
		view 771
		loop 1
		signal 20513
	)
)

(instance drill of Prop
	(properties
		noun 4
		x 9
		y 254
		z 2
		view 7710
		signal 20513
	)
)

(instance shovel of Prop
	(properties
		noun 5
		x 13
		y 254
		z 2
		view 7710
		loop 1
		signal 20513
	)
)

(instance turret of Prop
	(properties
		noun 7
		x 64
		y 253
		z 52
		view 7711
		signal 20513
	)
)

(instance belt of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 264
		approachY 270
		x 204
		y 227
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 198 139 222 139 212 231 185 228
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== (sharpe view:) 771)
					(gEgo setScript: sAttemptGetaway)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cart of Feature
	(properties
		noun 9
		sightAngle 40
		x 192
		y 101
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 214 230 218 231 221 231 223 222 220 219 214 219 215 218 220 218 224 221 224 239 227 242 228 246 226 251 220 251 221 258 218 264 215 265 208 263 207 257 205 258 194 257 190 260 176 259 175 257 175 254 169 253 166 255 159 255 157 251 158 245 164 243 164 241 175 234 174 231 176 219 182 215 186 215 185 217 182 217 179 220 178 231 184 228
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance nerves of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 266
		approachY 266
		x 308
		y 266
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 298 202 319 195 319 240 298 230
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 140) ; Paperclip
			(if (== (sharpe view:) 771)
				(gCurRoom setScript: sGrabAndShoot)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pile of Feature
	(properties
		noun 11
		sightAngle 40
		x 230
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 141 222 158 224 164 231 173 234 227 254 233 259 248 258 257 251 270 251 295 239 319 238 319 139 176 139 176 145 169 149 168 152 157 159 156 171 159 173 157 178 157 186 162 190 161 194 157 197 155 202 158 206 149 210 147 218
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance laserFire of Prop
	(properties
		z 1000
		view 7713
		cycleSpeed 12
	)

	(method (cue)
		(= z 1000)
	)
)

(instance sfx of Sound
	(properties)
)

(instance laserSFX of Sound
	(properties
		number 224
	)
)

(instance Sharpei of Talker
	(properties)

	(method (init)
		(super init: 0 0 0)
	)
)

(instance motorSound of Sound
	(properties
		number 771
	)
)

(instance drillSound of Sound
	(properties
		number 774
	)
)

(instance nervesFX of Prop
	(properties
		x 148
		y 211
		view 7720
		loop 1
		cel 3
	)
)

(instance nerves2FX of Actor
	(properties
		x 318
		y 202
		view 7720
		loop 2
		cel 1
	)
)

(instance nerves3FX of Actor
	(properties
		x 316
		y 197
		view 7720
		loop 3
		cel 4
	)
)

