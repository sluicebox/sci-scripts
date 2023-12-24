;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Talker)
(use n065)
(use Interface)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm220 0
	fallSP 1
	climbSP 2
	zapInSP 3
	startPath 4
	stopPath 5
	stopEgo 6
	startEgo 7
	wizP 8
	sparkleP 9
)

(local
	wizColor
	[sharedVars 8]
	zapRepeat
	whichTest
	backAgain
	oldControl
)

(procedure (stopPath)
	(pathTop setCycle: 0 stopUpd:)
	(pathMid setCycle: 0 stopUpd:)
	(pathEnd setCycle: 0 loop: 9)
)

(procedure (startPath)
	(pathTop setCycle: Fwd)
	(pathMid setCycle: Fwd)
	(pathEnd loop: 7 setCycle: Fwd)
)

(procedure (startEgo)
	(gEgo view: 0 posn: 246 141 setLoop: 7 init: setCycle: Fwd)
)

(procedure (stopEgo)
	(NormalEgo)
	(gEgo setMotion: 0)
)

(instance rm220 of Rm
	(properties
		picture 220
		style 15
	)

	(method (notify locVar varVal)
		(if (== argc 1)
			(return [sharedVars locVar])
		else
			(return (= [sharedVars locVar] varVal))
		)
	)

	(method (dispose)
		(ClearFlag 67) ; fPassedAir
		(ClearFlag 68) ; fPassedEarth
		(ClearFlag 69) ; fPassedWater
		(SetFlag 163) ; fWITAgain
		(DisposeScript 221)
		(DisposeScript 222)
		(gCSound fade:)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 6 7 32 31 62 220 221 222 224 225 226 227)
		(LoadMany rsSCRIPT 221 222)
		(LoadMany rsSOUND 221 222 223)
		(= gLevScript (ScriptID 221 1)) ; levitateSP
		(= gLevHighY 88)
		(= backAgain (IsFlag 163)) ; fWITAgain
		(super init:)
		(gMouseDownHandler add: self)
		(= gSpellChecker gAllChecker)
		(self setScript: zapInSP)
		(gCSound number: 220 loop: -1 playBed:)
	)

	(method (doit &tmp thisControl)
		(cond
			((and ((ScriptID 62 0) client:) (not (gCurRoom notify: 2)))) ; levitate
			((== script fallSP))
			((== (= thisControl (gEgo onControl: 1)) oldControl))
			((& thisControl $2810)
				(self setScript: fallSP 0 (= oldControl thisControl))
			)
			(else
				(= oldControl thisControl)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp spellNum)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(Print 220 0) ; "You find yourself trapped between a second and infinity. In this place, there is neither time nor space."
			)
			((and (== (event type:) evMOUSEBUTTON) (& (event modifiers:) emSHIFT))
				(event claimed: 1)
				(switch (Random 1 18)
					(2
						(HighPrint 220 1) ; "That's almost halfway to Cleveland."
					)
					(3
						(HighPrint 220 2) ; "There used to be nothing here. But not any more."
					)
					(4
						(HighPrint 220 3) ; "That's neither here nor there."
					)
					(5
						(HighPrint 220 4) ; "A dimensionless, endless void, trapped between space, time, and the restroom of a cheap diner."
					)
					(6
						(HighPrint 220 5) ; "You've just managed to click on Roger Wilco, who is still floating around, lost in space, time, sequels, and every other dimension, waiting for you to purchase his latest adventure and help him out of his latest bind."
					)
					(7
						(HighPrint 220 6) ; "You've clicked on a speck of dimensionless void dust."
					)
					(8
						(HighPrint 220 7) ; "The last time you were in a dimensionless void, it was vast. But this one's only half vast."
					)
					(9
						(HighPrint 220 8) ; "You've never seen a dimensionless void this big before. Not dimension this other void over here."
					)
					(else
						(HighPrint 220 9) ; "The scenery is awe-inspiring, but unchanging."
					)
				)
			)
			((Said 'cast>')
				(cond
					((< [gEgoStats 18] [gSpCostOpen gSpCostForce]) ; mana
						(event claimed: 1)
						(self setScript: outaGasS)
					)
					(
						(and
							(== (gCurRoom notify: 6) 6)
							(= spellNum (SaidSpell event))
							(TrySpell spellNum)
						)
						(switch spellNum
							(21
								(gEgo view: 32)
								((ScriptID 221 3) changeState: 21) ; triggerWallSP
								(gMiscSound number: 31)
							)
							(22
								(LowPrint 220 10) ; "You can't dazzle the creature if it isn't facing you."
							)
							(24
								(gEgo view: 31)
								(gMiscSound number: 21)
								((ScriptID 221 3) changeState: 21) ; triggerWallSP
							)
							(else
								(LowPrint 220 11) ; "You lack the concentration to cast that spell."
							)
						)
					)
				)
			)
			((Said 'crawl,duck')
				(if (== (gCurRoom notify: 6) 2)
					(HighPrint 220 12) ; "Carefully judging the distance between the approaching staff and the path, you decide there isn't enough room for a good-sized hero such as yourself."
				else
					(HighPrint 220 13) ; "Why would you want to do that?"
				)
			)
			((Said 'use,force,pull,move')
				(HighPrint 220 14) ; "In this place, you must rely upon only your magic."
			)
		)
	)
)

(instance zapInSP of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not zapRepeat)
					(pathEnd init:)
					(pathMid init:)
					(pathTop init:)
					(sparkleP init: posn: 245 116 setCycle: CT 2 1 self)
				else
					(wizFrame cel: 0 loop: 1 posn: 177 112)
					(= cycles 4)
				)
				(startPath)
			)
			(1
				(gEgo posn: 246 141 init:)
				(startEgo)
				(if (not zapRepeat)
					(sparkleP setCycle: End)
				)
				(= cycles 18)
			)
			(2
				(if (or zapRepeat backAgain)
					(= cycles 18)
				else
					(HighPrint 220 15) ; "You find yourself walking on a narrow pathway leading to the edge of infinity. You hear only your own footsteps."
					(= cycles 25)
				)
				(= zapRepeat 1)
			)
			(3
				(stopPath)
				(stopEgo)
				(= whichTest
					(cond
						((IsFlag 69) ; fPassedWater
							(= wizColor 3)
							(wizP title: {Fire Wizard:} color: 4 back: 14)
							(ScriptID 222 1) ; fireSP
						)
						((IsFlag 68) ; fPassedEarth
							(= wizColor 2)
							(wizP title: {Water Wizard:} color: 15 back: 1)
							(ScriptID 222 0) ; waterSP
						)
						((IsFlag 67) ; fPassedAir
							(= wizColor 4)
							(wizP title: {Earth Wizard:} color: 14 back: 6)
							(ScriptID 221 2) ; earthSP
						)
						(else
							(= wizColor 1)
							(wizP title: {Air Wizard:} color: 0 back: 11)
							(ScriptID 221 0) ; airSP
						)
					)
				)
				(wizP
					init:
					posn: 177 112
					loop: 0
					cel: 0
					palette: wizColor
					cycleSpeed: 1
					setCycle: CT 3 1 self
				)
			)
			(4
				(= cycles 5)
			)
			(5
				(wizP cycleSpeed: 0 setCycle: End self)
				(gMiscSound number: 221 loop: 1 priority: 5 play:)
			)
			(6
				(wizFrame init: cycleSpeed: 1 setCycle: End self)
			)
			(7
				(wizFrame view: 219 palette: wizColor setLoop: 2 cel: 0)
				(wizP loop: 1 tLoop: 1 posn: 179 74 talkSpeed: 1)
				(= cycles 10)
			)
			(8
				(switch wizColor
					(3
						(Say wizP self 220 16) ; "You must now withstand the fury of my flames."
					)
					(2
						(Say wizP self 220 17) ; "You must now overcome the subtle strengths of water and ice."
					)
					(4
						(Say wizP self 220 18) ; "You must now face raging earth and stone."
					)
					(1
						(Say wizP self 220 19) ; "You must now stand into the wind."
					)
				)
			)
			(9
				(wizP dispose:)
				(if (== whichTest (ScriptID 221 0)) ; airSP
					(tempStaff init:)
				)
				(wizFrame cycleSpeed: 0 setCycle: End self)
			)
			(10
				(wizFrame setPri: 9 setMotion: MoveTo 230 126 self)
				(startPath)
				(startEgo)
			)
			(11
				(wizFrame
					view: 220
					setLoop: 4
					cel: 0
					setMotion: MoveTo 246 141
					setCycle: End self
				)
			)
			(12
				(wizFrame dispose:)
				(tempStaff dispose:)
				(client setScript: whichTest)
			)
		)
	)
)

(instance fallSP of HandsOffScript
	(properties)

	(method (changeState newState &tmp difX difY)
		(switch (= state newState)
			(0
				(gEgo view: 6 cel: 0 ignoreActors:)
				(switch register
					(16
						(gEgo
							setLoop: 2
							setStep: 4 6
							setMotion:
								MoveTo
								(- (gEgo x:) 9)
								(+ (gEgo y:) 26)
							setCycle: CT 6 1 self
						)
					)
					(8192
						(gEgo setLoop: 4 setCycle: CT 2 1 self)
					)
					(2048
						(gEgo
							setLoop: 4
							setStep: 4 6
							setMotion: MoveTo 292 186
							setCycle: CT 6 1 self
						)
					)
				)
			)
			(1
				(switch register
					(16
						(= difX -12)
						(= difY -15)
					)
					(8192
						(= difX 13)
						(= difY -15)
					)
					(2048
						(= difX 14)
						(= difY -2)
					)
				)
				(sparkleP
					view: 220
					loop: 5
					cel: 0
					show:
					posn: (+ (gEgo x:) difX) (+ (gEgo y:) difY)
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(2
				(sparkleP setCycle: CT 2 1 self)
			)
			(3
				(gEgo setScript: 0 hide: z: 0)
				(sparkleP setCycle: End self)
			)
			(4
				(= gRoomExitDir 3)
				(gCSound fade:)
				(gMiscSound fade:)
				(gCurRoom newRoom: 229)
			)
		)
	)
)

(instance climbSP of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 190 117 self)
			)
			(1
				(gEgo
					view: 7
					setLoop: 0
					setCycle: Fwd
					setPri: 9
					posn: 177 114
					setMotion: MoveTo 177 105 self
					illegalBits: 0
					ignoreActors:
				)
				(gEgo
					setStep:
						-1
						(if
							(= register
								(and
									(TrySkill 11 20) ; climb
									(== client (ScriptID 221 2)) ; earthSP
								)
							)
							4
						else
							1
						)
				)
			)
			(2
				(if register
					(tallWall
						view: 222
						setLoop: 0
						setCel: -1
						cel: 0
						posn: 177 113
						setPri: 8
						setStep: -1 5
						cycleSpeed: 3
						setCycle: CT 2 1
						setMotion: MoveTo 177 72 self
						ignoreActors:
						illegalBits: 0
						init:
					)
					(gEgo setMotion: MoveTo 177 50)
				else
					(= cycles 14)
				)
			)
			(3
				(gEgo setCycle: 0 setCel: 2 setMotion: MoveTo 177 114 self)
			)
			(4
				(if register
					(tallWall
						setLoop: 0
						setCycle: Beg
						setMotion: MoveTo 177 113 self
					)
				else
					(self cue:)
				)
			)
			(5
				(if register
					(tallWall dispose:)
				)
				(NormalEgo)
				(gEgo
					illegalBits: 0
					posn: 179 117
					setMotion: MoveTo 224 133 self
				)
			)
			(6
				(if register
					(LowPrint 220 20) ; "Well, it LOOKED easy enough to climb!"
				else
					(LowPrint 220 21) ; "It's too slippery to climb."
				)
				(self dispose:)
			)
		)
	)
)

(instance outaGasS of HandsOffScript
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(wizP title: {Voices:} color: 15 back: 8 init: hide:)
				(= cycles 2)
			)
			(1
				(Say wizP self 220 22) ; "We see that you haven't enough magical power remaining to finish Our Tests. We dismiss you from Our Presence."
			)
			(2
				(SetFlag 162) ; fRanOutaMagic
				(client setScript: fallSP 0 2048)
			)
		)
	)
)

(instance wizP of Talker
	(properties
		x 177
		y 112
		noun '/wizard,man'
		description {the wizard}
		lookStr {It's an ancient-looking man in a wizard suit.}
		view 219
		priority 13
		signal 16400
		illegalBits 0
		title {Air Wizard:}
		color 13
		back 1
	)
)

(instance sparkleP of Prop
	(properties
		shiftClick 0
		view 220
		loop 5
		priority 15
		signal 16400
	)
)

(instance wizFrame of Actor
	(properties
		x 177
		y 112
		noun '/frame,painting'
		description {the wizFramed wizard}
		lookStr {Picture this - a wizFramed wizard.}
		view 220
		loop 1
		priority 12
		signal 16400
		illegalBits 0
	)
)

(instance pathEnd of Prop
	(properties
		x 271
		y 172
		noun '/path,path'
		description {a pathway}
		lookStr {The pathway appears suspended in this timeless, dimensionless void.  It leads off into infinity.}
		view 220
		loop 7
		priority 6
		signal 16400
	)
)

(instance pathMid of Prop
	(properties
		x 240
		y 147
		noun '/path,path'
		description {a pathway}
		lookStr {The pathway appears suspended in this timeless, dimensionless void.  It leads off into infinity.}
		view 220
		loop 6
		priority 6
		signal 16400
	)
)

(instance pathTop of Prop
	(properties
		x 200
		y 122
		noun '/path,path'
		description {a pathway}
		lookStr {The pathway appears suspended in this timeless, dimensionless void.  It leads off into infinity.}
		view 220
		loop 8
		priority 6
		signal 16400
	)
)

(instance tempStaff of View
	(properties
		x 170
		y 86
		noun '/staff'
		description {the wizard's staff}
		lookStr {The wizard seems to have left behind his staff.}
		view 221
		priority 9
		signal 16400
	)
)

(instance tallWall of Actor
	(properties)
)

