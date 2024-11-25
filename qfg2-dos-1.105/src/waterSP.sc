;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use TargActor)
(use Full)
(use rm220)
(use Motion)
(use Actor)
(use System)

(public
	waterSP 0
	fireSP 1
)

(local
	iceR
	[leftXY 9] = [20 27 14 17 21 32 25 38 -1]
	[rightXY 9] = [15 47 21 16 17 34 18 25 -1]
	bounceLeftCnt
	bounceRightCnt
)

(procedure (ReassignStatus)
	(if (> (gCurRoom notify: 6) 13)
		(gCurRoom notify: 6 (if (door cel:) 13 else 12))
	)
)

(instance waterSP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 15)
				(Load rsSOUND 16)
				(bullseye init: view: 224 setLoop: 3 hide:)
				(iceL
					posn: 139 108
					view: 224
					setLoop: 2
					cel: 0
					setStep: 2 1
					palette: 3
					init:
					setMotion: MoveTo 143 109 self
				)
			)
			(1
				(iceL cel: 1 setMotion: MoveTo 151 110 self)
			)
			(2
				(iceL cel: 2 setMotion: MoveTo 159 111 self)
			)
			(3
				(iceL cel: 3 setMotion: MoveTo 170 113 self)
			)
			(4
				(NormalEgo)
				(gEgo setMotion: 0)
				(iceL
					setLoop: 0
					setCel: 0
					posn: 151 114
					setPri: 8
					palette: 1
					stopUpd:
				)
				((= iceR (Clone iceL))
					view: 224
					setLoop: 1
					setCel: 0
					posn: 189 114
					init:
					setPri: 8
					stopUpd:
				)
				(stopPath)
				(gCurRoom notify: 6 7)
				(NormalEgo)
				(gEgo illegalBits: $c000)
				(HandsOn 1)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'climb,climb')
				(self setScript: (ScriptID 220 2)) ; climbSP
			)
		)
	)
)

(instance fireSP of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			((== (gCurRoom notify: 6) 16))
			((!= (gEgo onControl: 1) 16384))
			((== (door cel:) (door lastCel:))
				(client setScript: fryEgoSP)
			)
			((== (gCurRoom notify: 6) 5)
				(self changeState: 8)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door
					posn: 144 108
					view: 227
					setLoop: 11
					cel: 0
					setStep: 2 1
					init:
					setCycle: End
					setMotion: MoveTo 152 111 self
				)
			)
			(1
				(door setMotion: MoveTo 164 115 self)
			)
			(2
				(NormalEgo)
				(gEgo setMotion: 0)
				(door setPri: 8 setLoop: 0 cel: 0 stopUpd:)
				(gSpareSound number: 140 loop: -1 priority: 5 init: play:)
				(fire
					view: 227
					loop: 7
					posn: 172 114
					setPri: 7
					init:
					cycleSpeed: 0
					setCycle: Fwd
				)
				(gCurRoom notify: 6 12)
				(stopPath)
				(HandsOn)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'feel/door')
				(self setScript: doorSP self 2)
			)
			((Said 'knock/door')
				(self setScript: doorSP self 1)
			)
			((Said 'force/door')
				(self setScript: doorSP self 3)
			)
			((Said 'climb,climb')
				(LowPrint 222 0) ; "The door is much too hot to climb."
			)
		)
	)
)

(instance meltIceSP of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(NormalEgo)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(iceL forceUpd: palette: 2 stopUpd:)
				(iceR forceUpd: palette: 2 stopUpd:)
				(= cycles 1)
			)
			(1
				(iceL forceUpd: palette: 3)
				(iceR forceUpd: palette: 3)
				(= cycles 2)
			)
			(2
				(iceL forceUpd: palette: 4)
				(iceR forceUpd: palette: 4)
				(if (== (gCurRoom notify: 6) 7)
					(iceL setMotion: MoveTo 149 114)
					(iceR setMotion: MoveTo 191 114)
				)
				(= cycles 2)
			)
			(3
				(iceL forceUpd: palette: 5)
				(iceR forceUpd: palette: 5)
				(= cycles 2)
			)
			(4
				(atU
					init:
					posn: 176 118
					view: 226
					loop: 0
					cel: 0
					cycleSpeed: (- 6 (gCurRoom notify: 6))
					setCycle: CT 3 1 self
				)
			)
			(5
				(iceL forceUpd: palette: 2)
				(iceR forceUpd: palette: 2)
				(gEgo
					setLoop: (gEgo loop:)
					setCel: (gEgo cel:)
					setStep: 1 1
					setMotion: MoveTo (+ (gEgo x:) 4) (+ (gEgo y:) 3)
				)
				((ScriptID 220 9) ; sparkleP
					show:
					view: 226
					posn: 238 148
					loop: 1
					cel: 0
					cycleSpeed: (- 10 (gCurRoom notify: 6))
					setCycle: End self
				)
				(atU setCycle: End)
				(if (>= (gCurRoom notify: 6) 9)
					(client setScript: washAwaySP)
				)
			)
			(6
				(switch (gCurRoom notify: 6)
					(7
						(gCurRoom notify: 6 8)
						(bullseye show:)
						(HighPrint 222 1) ; "You seem to have melted the hoarfrost. Now you can see that the Iceberg is fractured."
					)
					(8
						(gCurRoom notify: 6 9)
						(HighPrint 222 2) ; "You seem to just be melting some of the massive Iceberg."
					)
				)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance washAwaySP of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 225
					setLoop: 8
					setCel: 0
					setStep: 4 4
					setMotion: MoveTo 310 280
				)
			)
		)
	)
)

(instance breakIceSP of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(HandsOn 1)
		(NormalEgo)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bolt show: posn: (client hitX:) (client hitY:))
				(= bounceLeftCnt 0)
				(= bounceRightCnt 0)
				(iceL setStep: 1 1 moveSpeed: 10)
				(iceR setStep: 1 1 moveSpeed: 10)
				(switch (gCurRoom notify: 6)
					(8
						(iceL setMotion: MoveTo 147 114)
						(iceR setMotion: MoveTo 193 114 self)
						(bolt setScript: bounceBoltS init:)
						(gCurRoom notify: 6 10)
					)
					(9
						(iceL setMotion: MoveTo 147 114)
						(iceR setMotion: MoveTo 193 114 self)
						(bolt setScript: bounceBoltS)
						(gCurRoom notify: 6 10)
					)
					(10
						(iceL setMotion: MoveTo 145 114)
						(iceR setMotion: MoveTo 195 114 self)
						(bolt setScript: bounceBoltS)
						(gCurRoom notify: 6 11)
					)
					(11
						(bolt dispose:)
						(client setScript: iceFallSP)
					)
				)
			)
			(1
				(iceL stopUpd:)
				(iceR stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance iceFallSP of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(iceL moveSpeed: 0 setMotion: MoveTo 139 114 self)
				(iceR moveSpeed: 0 setMotion: MoveTo 201 114)
			)
			(1
				(iceL setStep: 3 8 setMotion: MoveTo 131 152 self)
				(iceR setStep: 3 8 setPri: 1 setMotion: MoveTo 209 152)
			)
			(2
				(iceL setStep: 2 12 setMotion: MoveTo 127 274 self)
				(iceR setStep: 2 12 setMotion: MoveTo 213 274)
			)
			(3
				(HandsOff)
				(gEgo setMotion: MoveTo 246 141 self)
			)
			(4
				(gEgo setHeading: 315 self)
			)
			(5
				(iceL dispose:)
				(iceR dispose:)
				(SolvePuzzle 690 7 1)
				(SetFlag 69) ; fPassedWater
				(HandsOn)
				(gCurRoom setScript: (ScriptID 220 3)) ; zapInSP
				(client dispose:)
			)
		)
	)
)

(instance bounceBoltS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bolt
					setLoop: 6
					setCycle: Fwd
					setMotion:
						MoveTo
						(+ (iceL x:) [leftXY bounceLeftCnt])
						(- (iceL y:) [leftXY (++ bounceLeftCnt)])
						self
				)
			)
			(1
				(bolt setLoop: 7 cel: 0 setCycle: End self)
			)
			(2
				(bolt
					setLoop: 6
					setCycle: Fwd
					setMotion:
						MoveTo
						(- (iceR x:) [rightXY bounceRightCnt])
						(- (iceR y:) [rightXY (++ bounceRightCnt)])
						self
				)
			)
			(3
				(bolt setLoop: 7 cel: 0 setCycle: End self)
			)
			(4
				(if (!= [leftXY (++ bounceLeftCnt)] -1)
					(++ bounceRightCnt)
					(self changeState: 0)
				else
					(bolt
						setLoop: 6
						setCycle: Fwd
						setMotion: MoveTo (Random 50 80) (Random 40 76) self
					)
				)
			)
			(5
				(bolt hide:)
				(self dispose:)
			)
		)
	)
)

(instance doorSP of HandsOffScript
	(properties)

	(method (dispose)
		(NormalEgo)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 198 122 self)
			)
			(1
				(gEgo
					view: 225
					setLoop: 3
					cel: 0
					cycleSpeed: 1
					setCycle: CT 3 1
					setMotion: MoveTo 208 123 self
				)
				(if (== register 0)
					(door cel: 0 cycleSpeed: 1 setCycle: End)
				)
			)
			(2
				(switch register
					(1
						(HighPrint 222 3) ; "Knock knock, who's there?"
						(LowPrint 222 4) ; "Heat."
						(HighPrint 222 5) ; "Heat who?"
						(LowPrint 222 6) ; "Heat who hesitates is lost!"
						(HighPrint 222 7) ; "Now stop wasting time."
						(self dispose:)
					)
					(2
						(HighPrint 222 8) ; "Eee-ouch! It feels pretty hot!"
						(self dispose:)
					)
					(3
						((ScriptID 220 8) setPri: 0 init:) ; wizP
						(Say (ScriptID 220 8) self 222 9) ; "The door will not respond to physical force. You must use only magic to solve my test correctly.", wizP
					)
					(0
						(if (<= (gCurRoom notify: 6) 13)
							(gCurRoom setScript: fryEgoSP)
						else
							(self dispose:)
						)
					)
				)
			)
			(3
				((ScriptID 220 8) dispose:) ; wizP
				(self dispose:)
			)
		)
	)
)

(instance burnDoorSP of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setLoop: 1 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(1
				(door setLoop: 9 cel: 0 setCycle: End self)
			)
			(2
				(door setLoop: 3 setCycle: Fwd)
				(= cycles 12)
			)
			(3
				(LowPrint 222 10) ; "This doesn't look good. The fire is just getting hotter."
				(atU
					view: 227
					init:
					loop: 10
					cel: 0
					posn: 192 115
					cycleSpeed: 2
					setCycle: Full 3 self
				)
			)
			(4
				(client setScript: fryEgoSP)
			)
		)
	)
)

(instance walkOverDoorSP of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door setLoop: 1 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(1
				(gEgo
					ignoreActors:
					illegalBits: 0
					setLoop: 7
					setPri: 9
					setMotion: MoveTo 191 120 self
				)
				(door setPri: 8 setCel: 3)
				(gSpareSound loop: 1 fade:)
				(fire dispose:)
			)
			(2
				(startPath)
				(gEgo cycleSpeed: 0 setCycle: Fwd)
				(door setMotion: MoveTo 212 130 self)
			)
			(3
				(door
					setLoop: 1
					setCel: 2
					setStep: 6 9
					setMotion: MoveTo 235 142 self
				)
			)
			(4
				(door setCycle: CT 2 -1 self setMotion: MoveTo 290 220 self)
			)
			(5
				(SolvePuzzle 689 15 1)
				(SetFlag 65) ; fPassedTest
				(SkillUsed 14 100) ; honor
				(door setLoop: 11 setCel: 0)
				(RedrawCast)
				(HighPrint 222 11) ; "You did it! You're at WIT's end."
				(= cycles 10)
			)
			(6
				((ScriptID 220 9) ; sparkleP
					view: 220
					loop: 5
					cel: 0
					setPri: 15
					posn: (+ (gEgo x:) 2) (- (gEgo y:) 20)
					setCycle: CT 2 1 self
				)
			)
			(7
				(gEgo hide:)
				((ScriptID 220 9) setCycle: End self) ; sparkleP
			)
			(8
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance calmFireSP of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fire setLoop: 7 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(1
				(fire setLoop: 8 cycleSpeed: 1 setCycle: Fwd)
				(= cycles 22)
			)
			(2
				(fire posn: 166 116 setLoop: 6 cycleSpeed: 0)
				(= cycles 18)
			)
			(3
				(LowPrint 222 12) ; "The flames have died down, only to reveal a hole burned into the pathway."
				(gCurRoom notify: 6 14)
				(self dispose:)
			)
		)
	)
)

(instance fryEgoSP of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(atU
					view: 227
					init:
					loop: 10
					cel: 0
					posn: 192 115
					cycleSpeed: 2
					setCycle: Full 4
				)
				(gEgo view: 225 setLoop: 3 setCycle: End self)
			)
			(1
				((ScriptID 220 9) ; sparkleP
					view: 220
					loop: 5
					setPri: 15
					cel: 0
					posn: (+ (gEgo x:) 14) (- (gEgo y:) 22)
					setCycle: CT 2 1 self
				)
				(atU dispose:)
			)
			(2
				(gEgo dispose:)
				((ScriptID 220 9) setCycle: End self) ; sparkleP
			)
			(3
				(= gRoomExitDir 3)
				(gCurRoom newRoom: 229)
			)
		)
	)
)

(instance atU of Prop
	(properties
		view 227
		priority 8
		signal 16400
	)
)

(instance iceL of TargActor
	(properties
		noun '/ice,ice'
		description {the iceberg}
		lookStr {It is a gigantic piece of ice blocking the path.}
		view 226
		priority 9
		signal 16400
		illegalBits 0
	)

	(method (handleEvent event)
		(if (Said 'climb,climb')
			(event claimed: 0)
		else
			(super handleEvent: event)
		)
	)

	(method (dazzleMe)
		(LowPrint 222 13) ; "It seems to have no effect."
		(return 1)
	)

	(method (detectMe)
		(HighPrint 222 14) ; "It has a vague aura of magic."
		(return 1)
	)

	(method (fetchMe)
		(LowPrint 222 15) ; "You don't have the ability to move such a huge object."
		(return 0)
	)

	(method (triggerMe)
		(LowPrint 222 13) ; "It seems to have no effect."
		(return 0)
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(cond
			((== (whatHurt type:) 25)
				(self setScript: meltIceSP)
			)
			((!= (whatHurt type:) 27))
			((!= (gCurRoom notify: 6) 7)
				(gCurRoom
					setScript:
						delayPrintS
						0
						{You need to target your spell better to use the Iceberg's weakness against it.}
				)
			)
			(else
				(gCurRoom
					setScript:
						delayPrintS
						0
						{The Force Bolt has no effect against such a solid mass of ice.}
				)
			)
		)
		(return 1)
	)
)

(instance bullseye of TargActor
	(properties
		x 172
		y 114
		noun '/crack'
		description {the fissure in the ice}
		lookStr {The fissure in the ice seems to be its weakest spot}
		view 224
		loop 3
		signal 16384
		illegalBits 0
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(switch (whatHurt type:)
			(27
				(self setScript: breakIceSP)
				(return 1)
			)
			(25
				(self setScript: meltIceSP)
			)
		)
		(return 0)
	)

	(method (fetchMe)
		(LowPrint 222 13) ; "It seems to have no effect."
		(return 0)
	)

	(method (openMe)
		(if (< (gCurRoom notify: 6) 9)
			(LowPrint 222 16) ; "The Ice is too solid. You will need to break the fissure first."
		else
			(self setScript: iceFallSP)
			(return 1)
		)
		(return 0)
	)

	(method (calmMe)
		(HighPrint 222 17) ; "The Ice is now very relaxed."
		(return 1)
	)
)

(instance door of TargActor
	(properties
		noun '/door'
		description {the door}
		lookStr {There is a door blocking the pathway.}
		priority 9
		signal 16400
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(if (<= 13 (gCurRoom notify: 6) 14)
					(LowPrint 222 18) ; "The door has swung out too far. You can't reach it from the pathway."
				else
					(LowPrint 222 19) ; "The door is already closed."
				)
			)
			(2
				(self setScript: doorSP self 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (calmMe)
		(switch (gCurRoom notify: 6)
			(12
				(self
					setScript:
						delayPrintS
						0
						{The door seems to have absorbed your spell.}
				)
			)
			(13
				(self setScript: calmFireSP)
			)
			(14
				(self
					setScript:
						delayPrintS
						0
						{The flames are as calm as they're going to get.}
				)
			)
		)
		(return 1)
	)

	(method (dazzleMe)
		(LowPrint 222 13) ; "It seems to have no effect."
		(return 1)
	)

	(method (detectMe)
		(HighPrint 222 20) ; "The door does not seem to be magic, but there is a glow behind it."
		(return 1)
	)

	(method (fetchMe)
		(switch (gCurRoom notify: 6)
			(14
				(if (< hitX 173)
					(self setCycle: Beg)
					(gCurRoom notify: 6 15)
					(self
						setScript:
							delayPrintS
							0
							{Say, have you figured this out, or are you just playing it by ear?}
					)
				else
					(LowPrint 222 21) ; "There's nothing worth fetching."
				)
			)
			(13
				(if (< hitX 173)
					(self setCycle: Beg)
					(gCurRoom notify: 6 12)
					(self
						setScript:
							delayPrintS
							0
							{That turned down the heat, but the flames are burning through the door again. }
					)
				else
					(LowPrint 222 21) ; "There's nothing worth fetching."
				)
			)
			(else
				(LowPrint 222 22) ; "It seems to have no effect on the closed door."
			)
		)
		(return 0)
	)

	(method (openMe)
		(if (OneOf (gCurRoom notify: 6) 12 15)
			(self cycleSpeed: 1 setCycle: End)
			(fire setLoop: 3)
			(gCurRoom notify: 6 13)
			(self
				setScript:
					delayPrintS
					0
					{With the door open, the fire's heat is more intense.}
			)
		else
			(LowPrint 222 23) ; "The door is already open."
		)
		(return 0)
	)

	(method (triggerMe)
		(LowPrint 222 13) ; "It seems to have no effect."
		(return 0)
	)

	(method (hurtMe amount whatHurt &tmp moveScript)
		(switch (whatHurt type:)
			(25
				(switch (gCurRoom notify: 6)
					(12
						(self
							setScript:
								delayPrintS
								0
								{The door resists your flame.}
						)
					)
					(15
						(ReassignStatus)
						(fire setLoop: 3)
						(self
							setScript:
								delayPrintS
								0
								{The flames seem to burn more intensely.}
						)
					)
					(else
						(self
							setScript:
								delayPrintS
								0
								{The flames seem to burn more intensely.}
						)
					)
				)
			)
			(27
				(switch (gCurRoom notify: 6)
					(12
						(if (< hitY 84)
							(self setScript: burnDoorSP)
						)
					)
					(15
						(if (< hitY 84)
							(gCurRoom notify: 6 16)
							(self setScript: walkOverDoorSP)
						)
					)
					(else
						(self
							setScript:
								delayPrintS
								0
								{The flames seem to burn more intensely.}
						)
					)
				)
			)
		)
		(return 1)
	)
)

(instance fire of TargActor
	(properties
		noun '/fire,flame'
		description {the flames}
		lookStr {There are some flames behind the door}
		priority 9
		signal 16400
		illegalBits 0
	)

	(method (openMe)
		(LowPrint 222 13) ; "It seems to have no effect."
		(return 0)
	)

	(method (calmMe)
		(switch (gCurRoom notify: 6)
			(12
				(self
					setScript:
						delayPrintS
						0
						{The door seems to have absorbed your spell.}
				)
			)
			(13
				(self setLoop: 7)
				(gCurRoom notify: 6 14)
				(return 1)
			)
			(14
				(self
					setScript:
						delayPrintS
						0
						{The flames are as calm as they're going to get.}
				)
			)
		)
		(return 0)
	)

	(method (fetchMe)
		(LowPrint 222 13) ; "It seems to have no effect."
		(return 0)
	)

	(method (hurtMe &tmp temp0)
		(ReassignStatus)
		(fire setLoop: 3)
		(self
			setScript: delayPrintS 0 {The flames seem to burn more intensely.}
		)
		(return 1)
	)
)

(instance bolt of Actor
	(properties
		noun '/bolt'
		description {the force bolt}
		lookStr {The force bolt bounces within the iceberg}
		yStep 10
		view 32
		priority 9
		signal 16400
		illegalBits 0
		xStep 10
	)
)

(instance delayPrintS of Script
	(properties)

	(method (doit)
		(if (and (not (IsFlag 87)) register) ; fCastingSpell
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(LowPrint register)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

