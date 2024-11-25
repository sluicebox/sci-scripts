;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 570)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use StairScript)
(use TargActor)
(use Full)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm570 0
)

(local
	thisControl
	frogger
	[unused 2]
	missedLog
	canJump
	crossedRiver
	oneSuck
	rockCount
	goodIdeaBut
)

(instance rm570 of Rm
	(properties
		picture 570
		style 40
	)

	(method (init)
		(LoadMany rsPIC 580 570)
		(LoadMany rsVIEW 570 571 575 576 3 585 572 586)
		(LoadMany rsSOUND 600 570)
		(EgoGait 4 0) ; holdingLamp
		(= gSpellChecker gAllChecker)
		(if (IsFlag 107) ; fWindShutOff
			(rocks cel: 4)
		else
			(air setCycle: Fwd init:)
		)
		(rocks init:)
		(water1 setCycle: Fwd init:)
		(water2 setCycle: Fwd init:)
		(water3 setCycle: Fwd init:)
		(if (>= gHowFast 1)
			(water4 setCycle: Fwd init:)
			(water5 setCycle: Fwd init:)
			(water6 setCycle: Fwd init:)
			(if (>= gHowFast 2)
				(water7 setCycle: Fwd init:)
				(water8 setCycle: Fwd init:)
				(water9 setCycle: Fwd init:)
				(water10 setCycle: Fwd init:)
			)
		)
		(wallShine init: hide:)
		(InitFeatures stairFeat fallFeat1 fallFeat2)
		(gEgo
			setScript:
				(if (< (gEgo y:) 85)
					(= global61 1)
					(super init:)
					(wallShine show:)
					comeBackIn
				else
					(= global61 0)
					(super init:)
					comeIn
				)
		)
		(self setScript: loggerScript)
		(gCSound number: 600 loop: -1 playBed:)
		(gMiscSound number: 570 loop: -1 play:)
	)

	(method (doit &tmp noScript)
		(= thisControl (gEgo onControl: 1))
		(= noScript (not (gEgo script:)))
		(cond
			((and (& thisControl $0040) noScript)
				(gEgo setScript: toDownAirRm)
			)
			((and (& thisControl $0002) noScript)
				(gEgo setScript: toUpAirRm)
			)
			((and (& thisControl $0008) noScript)
				(gEgo setScript: rockStairs)
			)
			((and (& thisControl $0010) noScript)
				(gEgo setScript: downStairs)
			)
			((and (& thisControl $0020) noScript)
				(gEgo setScript: downStream)
			)
			((and (gEgo inRect: 26 113 91 158) (not (IsFlag 107)) noScript) ; fWindShutOff
				(gEgo setScript: suckedIn)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/cave,wall,ceiling,roof')
				)
				(HighPrint 570 0) ; "The glow in this cavern comes from phosphorescent fungi. The stream flows swiftly to a waterfall which disappears into a great cavern far, far below."
			)
			((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
				(if (gEgo has: 16) ; Rope
					(HighPrint 570 1) ; "You have no need of the magic rope here, hero."
				else
					(HighPrint 570 2) ; "You have no rope, hero."
				)
				(event claimed: 1)
			)
			((Said 'cast,throw')
				(if (== (gEgo view:) 575)
					(HighPrint 570 3) ; "Not now, you're busy."
					(event claimed: 1)
				else
					(event claimed: 0)
				)
			)
			((Said 'climb,climb')
				(HighPrint 570 4) ; "The rocks in this room are much too slippery to climb."
			)
			((Said 'use,rub,rub,light,(turn<on)/lamp,light')
				(HighPrint 570 5) ; "OK, but there's light enough from the phosphorescent fungi on the walls."
				(EgoGait 4 0) ; holdingLamp
			)
			((Said 'put,drop,extinguish,douse/lamp,light')
				(HighPrint 570 6) ; "OK, but you'd better keep it handy. There may be other dark caves to explore."
				(wallShine hide:)
				(EgoGait 0 0) ; walking
			)
			((Said 'swim,(go<swim)')
				(Print 570 7) ; "Many's the time you've regretted your lack of a formal swimming education."
			)
			((Said 'block/chasm')
				(cond
					((IsFlag 107) ; fWindShutOff
						(HighPrint 570 8) ; "You have already stopped the wind."
					)
					((< (gEgo y:) 75)
						(Print 570 9) ; "Go back down the stairs first."
					)
					((not crossedRiver)
						(HighPrint 570 10) ; "You have to cross the river first."
					)
					(else
						(HighPrint 570 11) ; "That's a great idea..."
						(Print 570 12) ; "...but how?"
					)
				)
			)
			((Said 'get,get,fill/water,waterbag')
				(if (gEgo has: 37) ; Waterskin
					(HighPrint 570 13) ; "The speed of the rushing water would rip the waterskin out of your hand. and you might slip in on the slimy bank."
				else
					(HighPrint 570 14) ; "You don't have a waterskin to fill."
				)
			)
			(
				(or
					(Said 'lockpick[/lock]')
					(Said 'use/(lockpick[<lock]),lockpick')
					(Said 'unlock')
					(Said 'use/lockpick,implement,kit')
				)
				(cond
					((IsFlag 107) ; fWindShutOff
						(HighPrint 570 8) ; "You have already stopped the wind."
					)
					((not (CanPickLocks 1)))
					(else
						(gEgo setScript: pryRocks)
					)
				)
			)
			((or (Said 'pry,lockpick/boulder,brick') (Said 'use/dagger'))
				(cond
					((IsFlag 107) ; fWindShutOff
						(HighPrint 570 8) ; "You have already stopped the wind."
					)
					((not (or [gInvNum 5] [gInvNum 56])) ; Dagger, SilverDagger
						(DontHave)
					)
					(else
						(gEgo setScript: pryRocks)
					)
				)
			)
			(
				(or
					(Said 'use/strength')
					(Said 'force,force,shake,move,dislodge/brick,boulder,brick')
				)
				(if (IsFlag 107) ; fWindShutOff
					(HighPrint 570 8) ; "You have already stopped the wind."
				else
					(gEgo setScript: ramRocks)
				)
			)
			((Said 'cast')
				(if (< (gEgo x:) 42)
					(HighPrint 570 15) ; "Step back a little bit, Hero"
					(event claimed: 1)
				else
					(event claimed: 0)
				)
			)
			((Said 'hop[<on,off][/log]')
				(cond
					((< (gEgo y:) 75)
						(Print 570 16) ; "Wouldn't it be nicer to have a diving board?"
					)
					(crossedRiver
						(gEgo setScript: jumpInSpot)
					)
					((and canJump frogger)
						(= frogger 0)
						(gEgo setScript: offBoard)
					)
					((and frogger (< (loggerScript state:) 30))
						(HighPrint 570 17) ; "You'd better get closer to dry land first."
					)
					(frogger
						(HighPrint 570 18) ; "Too late!"
						(HighPrint 570 19) ; "'Bye..."
					)
					((== thisControl 2048)
						(gEgo setScript: inDrink)
					)
					((not (== thisControl 128))
						(Print 570 20) ; "Try jumping from the mossy bank by the falls."
					)
					((== gArcadeLevel 1)
						(gEgo setScript: smartOnBoard)
					)
					(
						(and
							(==
								(cond
									((<= 12 (loggerScript state:) 17) 1)
									((>= (loggerScript state:) 18) 2)
									(else 0)
								)
								0
							)
							(== gArcadeLevel 2)
						)
						(gEgo setScript: smartOnBoard)
					)
					(
						(==
							(cond
								((<= 12 (loggerScript state:) 17) 1)
								((>= (loggerScript state:) 18) 2)
								(else 0)
							)
							1
						)
						(gEgo setScript: onBoard)
					)
					(else
						(= missedLog 1)
						(= goodIdeaBut 1)
						(gEgo setScript: inDrink)
					)
				)
			)
		)
	)
)

(instance loggerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(log illegalBits: 0 setPri: 14)
				(= cycles 1)
			)
			(1
				(log loop: 0 cel: 0 posn: 65 22)
				(= cycles 1)
			)
			(2
				(log setPri: 14 posn: 73 28)
				(= cycles 1)
			)
			(3
				(log posn: 81 37)
				(= cycles 1)
			)
			(4
				(log cel: 1 posn: 88 45)
				(= cycles 1)
			)
			(5
				(log posn: 94 55)
				(= cycles 1)
			)
			(6
				(log cel: 2 setPri: 4 posn: 96 65)
				(= cycles 1)
			)
			(7
				(log setPri: 4 posn: 97 84)
				(= cycles 1)
			)
			(8
				(log loop: 1 cel: 0 posn: 98 103)
				(= cycles 1)
			)
			(9
				(log cel: 1 posn: 99 104)
				(= cycles 1)
			)
			(10
				(log cel: 2 posn: 99 104)
				(= cycles 1)
			)
			(11
				(log cel: 3 posn: 108 110)
				(= cycles 1)
			)
			(12
				(log loop: 2 cel: 0 posn: 115 112)
				(= cycles 1)
			)
			(13
				(log cel: 0 posn: 120 113)
				(= cycles 1)
			)
			(14
				(log posn: 126 114)
				(= cycles 1)
			)
			(15
				(log posn: 140 115)
				(= cycles 1)
			)
			(16
				(log posn: 142 117)
				(= cycles 1)
			)
			(17
				(log posn: 143 120)
				(= cycles 1)
			)
			(18
				(log posn: 145 122)
				(= cycles 1)
			)
			(19
				(log posn: 147 124)
				(= cycles 1)
			)
			(20
				(log posn: 149 127)
				(= cycles 1)
			)
			(21
				(log posn: 151 129)
				(= cycles 1)
			)
			(22
				(log posn: 153 131)
				(= cycles 1)
			)
			(23
				(log posn: 156 133)
				(= cycles 1)
			)
			(24
				(log posn: 158 135)
				(= cycles 1)
			)
			(25
				(log posn: 161 138)
				(= cycles 1)
			)
			(26
				(log posn: 164 141)
				(= cycles 1)
			)
			(27
				(log posn: 166 143)
				(= cycles 1)
			)
			(28
				(log posn: 168 145)
				(= cycles 1)
			)
			(29
				(log posn: 171 147)
				(= cycles 1)
			)
			(30
				(log posn: 173 149)
				(= canJump 1)
				(= cycles 1)
			)
			(31
				(log posn: 180 152)
				(= cycles 1)
			)
			(32
				(log posn: 184 152)
				(= cycles 1)
			)
			(33
				(log posn: 188 152)
				(= cycles 1)
			)
			(34
				(log posn: 193 152)
				(= cycles 1)
			)
			(35
				(log posn: 197 154)
				(= cycles 1)
			)
			(36
				(log cel: 2 posn: 203 155)
				(= cycles 1)
			)
			(37
				(log posn: 208 157)
				(= cycles 1)
			)
			(38
				(log posn: 212 160)
				(= cycles 1)
			)
			(39
				(log posn: 213 162)
				(= cycles 1)
			)
			(40
				(log posn: 214 165)
				(= cycles 1)
			)
			(41
				(log posn: 215 168)
				(= cycles 1)
			)
			(42
				(log posn: 216 172)
				(= cycles 1)
				(= canJump 0)
			)
			(43
				(log posn: 217 179)
				(= cycles 1)
			)
			(44
				(log cel: 3 posn: 217 188)
				(= cycles 1)
			)
			(45
				(log posn: 217 195 setStep: 2 12 setMotion: MoveTo 217 220 self)
				(if frogger
					(gEgo
						setLoop: 7
						cel: 0
						setStep: 3 12
						posn: 213 170
						setCycle: Fwd
					)
				)
			)
			(46
				(if frogger
					(gEgo
						setCycle: End
						setStep: 4 12
						setMotion: MoveTo 216 250 self
					)
				else
					(self cue:)
				)
			)
			(47
				(log setMotion: 0 setCycle: 0)
				(if frogger
					(if (== (Random 0 1) 0)
						(EgoDead
							0
							{No, dude!__It's down.__Far down.__WIPE OUT!}
							#title
							{Surf's up?}
							#icon
							570
							2
							3
						)
					else
						(EgoDead
							0
							{You have fallen just off screen to the jagged rocks below.}
							#title
							{Yeeeooooow!}
							#icon
							570
							2
							3
						)
					)
				)
				(= seconds (Random 3 7))
			)
			(48
				(self changeState: 0)
			)
		)
		(if frogger
			(gEgo setLoop: 2 posn: (+ (log x:) 8) (- (log y:) 13))
		)
	)
)

(instance downStream of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(missedLog
						(= cycles 8)
					)
					(crossedRiver
						(self setScript: longStep self)
					)
					(else
						(gEgo
							illegalBits: 0
							ignoreActors: 1
							view: 575
							setLoop: 4
							cel: 0
							xStep: 2
							yStep: 2
							posn: (- (gEgo x:) 4) (+ (gEgo y:) 10)
							setCycle: End self
						)
					)
				)
			)
			(1
				(gEgo setLoop: 6)
				(cond
					((< (gEgo y:) 104)
						(self cue:)
					)
					((< (gEgo y:) 110)
						(self changeState: 4)
					)
					((< (gEgo y:) 120)
						(self changeState: 9)
					)
					((< (gEgo y:) 135)
						(self changeState: 15)
					)
					((< (gEgo y:) 155)
						(self changeState: 26)
					)
					((< (gEgo y:) 170)
						(self changeState: 31)
					)
					(else
						(self changeState: 33)
					)
				)
			)
			(2
				(gEgo cel: 0 posn: 132 107)
				(= cycles 1)
			)
			(3
				(gEgo cel: 1 posn: 134 108)
				(= cycles 1)
			)
			(4
				(gEgo cel: 2 posn: 136 109)
				(= cycles 1)
			)
			(5
				(gEgo cel: 3 posn: 138 111)
				(= cycles 1)
			)
			(6
				(gEgo cel: 2 posn: 142 113)
				(= cycles 1)
			)
			(7
				(gEgo cel: 1 posn: 148 115)
				(= cycles 1)
			)
			(8
				(gEgo cel: 0 posn: 151 117)
				(= cycles 1)
			)
			(9
				(gEgo cel: 1 posn: 155 119)
				(= cycles 1)
			)
			(10
				(gEgo cel: 2 posn: 159 121)
				(= cycles 1)
			)
			(11
				(gEgo cel: 3 posn: 162 123)
				(= cycles 1)
			)
			(12
				(gEgo cel: 2 posn: 165 126)
				(= cycles 1)
			)
			(13
				(gEgo cel: 1 posn: 168 129)
				(= cycles 1)
			)
			(14
				(gEgo cel: 2 posn: 171 131)
				(= cycles 1)
			)
			(15
				(gEgo cel: 3 posn: 174 134)
				(= cycles 1)
			)
			(16
				(gEgo cel: 1 posn: 177 137)
				(= cycles 1)
			)
			(17
				(gEgo cel: 2 posn: 182 139)
				(= cycles 1)
			)
			(18
				(gEgo cel: 3 posn: 187 141)
				(= cycles 1)
			)
			(19
				(gEgo cel: 1 posn: 193 143)
				(= cycles 1)
			)
			(20
				(gEgo cel: 0 posn: 201 144)
				(= cycles 1)
			)
			(21
				(gEgo cel: 1 posn: 210 145)
				(= cycles 1)
			)
			(22
				(gEgo cel: 2 posn: 219 146)
				(= cycles 1)
			)
			(23
				(gEgo cel: 1 posn: 223 148)
				(= cycles 1)
			)
			(24
				(gEgo cel: 0 posn: 229 149)
				(= cycles 1)
			)
			(25
				(gEgo cel: 1 posn: 233 150)
				(= cycles 1)
			)
			(26
				(gEgo cel: 2 posn: 231 154)
				(= cycles 1)
			)
			(27
				(gEgo cel: 3 posn: 230 158)
				(= cycles 1)
			)
			(28
				(gEgo cel: 2 posn: 226 160)
				(= cycles 1)
			)
			(29
				(gEgo cel: 1 posn: 222 161)
				(= cycles 1)
			)
			(30
				(gEgo cel: 2 posn: 218 163)
				(= cycles 1)
			)
			(31
				(gEgo cel: 1 posn: 215 166)
				(= cycles 1)
			)
			(32
				(gEgo cel: 2 posn: 211 169)
				(= cycles 1)
			)
			(33
				(gEgo
					setLoop: 7
					cel: 0
					yStep: 14
					posn: 199 204
					setCycle: Fwd
					setMotion: MoveTo 199 230 self
				)
			)
			(34
				(if goodIdeaBut
					(EgoDead
						0
						{Well, would you believe good idea, but bad timing?}
						#title
						{Missed it by that much}
						#icon
						570
						3
						0
					)
				else
					(EgoDead
						0
						{The swift current overwhelms you with emotions as it sweeps you off your feet and carries you away with it.}
						#title
						{Swept away}
						#icon
						570
						3
						0
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance comeIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(log init:)
				(gEgo
					posn: 319 gEgoY
					init:
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 300 gEgoY self
				)
			)
			(1
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance comeBackIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= crossedRiver 1)
				(log init:)
				(gEgo
					posn: 319 gEgoY
					init:
					illegalBits: 0
					setCycle: Walk
					setPri: 2
					setMotion: MoveTo 311 67 self
				)
				(SetFlag 116) ; fLightOn
			)
			(1
				(gEgo setMotion: MoveTo 291 50 self)
			)
			(2
				(NormalEgo)
				(gEgo setPri: 2)
				(self dispose:)
			)
		)
	)
)

(instance smartOnBoard of HandsOffScript
	(properties)

	(method (doit)
		(super doit:)
		(switch state
			(1
				(if
					(!=
						(cond
							((<= 12 (loggerScript state:) 17) 1)
							((>= (loggerScript state:) 18) 2)
							(else 0)
						)
						2
					)
					(self cue:)
				)
			)
			(2
				(if
					(==
						(cond
							((<= 12 (loggerScript state:) 17) 1)
							((>= (loggerScript state:) 18) 2)
							(else 0)
						)
						1
					)
					(self cue:)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self
					changeState:
						(cond
							(
								(<=
									(cond
										((<= 12 (loggerScript state:) 17) 1)
										((>= (loggerScript state:) 18) 2)
										(else 0)
									)
									0
								)
								2
							)
							(
								(==
									(cond
										((<= 12 (loggerScript state:) 17) 1)
										((>= (loggerScript state:) 18) 2)
										(else 0)
									)
									2
								)
								1
							)
							(
								(==
									(cond
										((<= 12 (loggerScript state:) 17) 1)
										((>= (loggerScript state:) 18) 2)
										(else 0)
									)
									1
								)
								(client setScript: onBoard)
							)
						)
				)
			)
			(1
				(Print 570 21) ; "You think that the log is too far away and you wait for another one."
			)
			(2 0)
			(3
				(client setScript: onBoard)
			)
		)
	)
)

(instance onBoard of HandsOffScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DontMove 1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 575
					setLoop: 0
					cel: 0
					posn: (- (gEgo x:) 15) (- (gEgo y:) 2)
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 cel: 0 setCycle: End)
				(= frogger 1)
				(gEgo setMotion: MoveTo 158 118 self)
			)
			(2
				(gEgo
					view: 575
					setLoop: 2
					illegalBits: 0
					ignoreActors:
					setCycle: Fwd
				)
				(loggerScript changeState: 22)
				(self dispose:)
			)
		)
	)
)

(instance offBoard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff 1)
				(gEgo
					loop: 3
					cel: 0
					illegalBits: 0
					posn: (- (gEgo x:) 17) (+ (gEgo y:) 3)
					setCycle: End
					setMotion: MoveTo 155 150
				)
				(= seconds 2)
			)
			(1
				(gEgo
					view: 0
					loop: 1
					cel: 0
					illegalBits: $8000
					posn: (- (gEgo x:) 17) (+ (gEgo y:) 3)
				)
				(= cycles 1)
			)
			(2
				(= crossedRiver 1)
				(NormalEgo)
				(DontMove 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance inDrink of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 575
					setLoop: 0
					cel: 0
					illegalBits: 0
					posn: (- (gEgo x:) 14) (- (gEgo y:) 3)
					setMotion: MoveTo (- (gEgo x:) 28) (+ (gEgo y:) 5)
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: 4
					cel: 0
					setCycle: End
					setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:)
				)
				(= cycles 12)
			)
			(2
				(= missedLog 1)
				(client setScript: downStream)
			)
		)
	)
)

(instance jumpInSpot of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 575
					loop: 0
					cel: 0
					posn: (- (gEgo x:) 4) (+ (gEgo y:) 1)
					setCycle: Full 1 self
				)
			)
			(1
				(gEgo
					view: 0
					setLoop: 1
					cel: 0
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 1)
				)
				(= cycles 1)
			)
			(2
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance suckedIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 setCycle: 0 setHeading: 270 self)
			)
			(1
				(gEgo
					view: 575
					setLoop: 9
					setCycle: CT 4 1
					setMotion: MoveTo 27 131 self
				)
			)
			(2
				(if (not oneSuck)
					(HighPrint 570 22) ; "Your foot slips due to the force of the air rushing into that small opening. There is tremendous pressure from all the wind trying to surge into the hole, and you struggle to overcome it."
					(= oneSuck 1)
				)
				(gEgo setCel: -1 cel: 0 cycleSpeed: 1 setCycle: CT 2 -1 self)
			)
			(3
				(gEgo setCycle: CT 4 1 self)
			)
			(4
				(gEgo setCycle: CT 2 -1 self)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					view: 585
					setCel: -1
					setLoop: 3
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 50 112 self
				)
			)
			(7
				(NormalEgo)
				(gEgo setHeading: 180 self)
			)
			(8
				(HighPrint 570 23) ; "Whew! That was close."
				(self dispose:)
			)
		)
	)
)

(instance ramRocks of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 41 130 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 576 setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(ShakeScreen 1 ssUPDOWN)
				(= cycles 8)
			)
			(4
				(UseStamina 20)
				(if (TrySkill 0 125) ; strength
					(self setScript: rocksFall self)
				else
					(self cue:)
				)
			)
			(5
				(self cue:)
			)
			(6
				(if (not (IsFlag 107)) ; fWindShutOff
					(Print 570 24) ; "You just aren't strong enough to dislodge the pile of rocks."
				)
				(gEgo loop: 3)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance pryRocks of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 39 124 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					view: 572
					setLoop: 0
					cel: 0
					setMotion: MoveTo 19 128
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 1 cycleSpeed: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(gEgo setLoop: 2 setCycle: 0 cel: 0)
				(if (PickLock 80 1 0)
					(self setScript: rocksFall self)
				else
					(= cycles 1)
				)
			)
			(5
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(6
				(NormalEgo)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 30 135 self
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance rocksFall of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rocks setCycle: End self)
			)
			(1
				(rocks
					ignoreActors:
					lookStr: {The rocks lie in a heap, blocking the hole.}
					stopUpd:
				)
				(air dispose:)
				(SolvePuzzle 633 7)
				(SetFlag 107) ; fWindShutOff
				(= cycles 4)
			)
			(2
				(Print 570 25) ; "The wind no longer blows as fiercely as before."
				(self dispose:)
			)
		)
	)
)

(instance knockRocks of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= oneSuck 1)
				(DontMove 1)
				(gEgo illegalBits: 0 setMotion: MoveTo 26 142 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo view: 575 loop: 9 cel: 0 setCycle: End self)
				(++ rockCount)
			)
			(3
				(if (< rockCount 3)
					(self changeState: 2)
				else
					(self cue:)
				)
			)
			(4
				(if (< [gEgoStats 0] 80) ; strength
					(Print 570 26) ; "You are too weak to break down the rocks."
				else
					(rocks setCycle: End)
					(air dispose:)
				)
				(= seconds 2)
			)
			(5
				(gEgo view: 0 setLoop: 3 cel: 0)
				(= cycles 1)
			)
			(6
				(NormalEgo)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (+ (gEgo x:) 10) (gEgo y:) self
				)
			)
			(7
				(DontMove 0)
				(gEgo illegalBits: $8000)
				(= rockCount 0)
				(self dispose:)
			)
		)
	)
)

(instance rockStairs of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 41 108 self)
			)
			(1
				(client setScript: climbStairs)
			)
		)
	)
)

(instance climbStairs of StairScript
	(properties
		stairSize 10
		numStairs 7
	)

	(method (doit)
		(gEgo x: (- (gEgo x:) 1))
		(super doit:)
	)

	(method (init)
		(= goingUp 1)
		(super init: &rest)
	)

	(method (dispose)
		(= global61 1)
		(gCurRoom drawPic: 570 7)
		(wallShine posn: (gEgo x:) (- (gEgo y:) 30) show:)
		(super dispose:)
		(NormalEgo)
		(gEgo setPri: 2)
	)
)

(instance downStairs of StairScript
	(properties
		stairSize 10
		numStairs 6
	)

	(method (doit)
		(gEgo x: (+ (gEgo x:) 1))
		(super doit:)
	)

	(method (init)
		(gEgo setPri: -1)
		(wallShine hide:)
		(= next awayFromStepsDown)
		(= goingUp 0)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance awayFromStepsDown of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 55 113 self
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance toUpAirRm of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 313 67 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo setMotion: MoveTo 320 (gEgo y:) self)
			)
			(3
				(if (!= gEgoGait 4) ; holdingLamp
					(EgoGait 4 0) ; holdingLamp
					(HighPrint 570 27) ; "You rekindle your lamp."
				)
				(= cycles 2)
			)
			(4
				(= gEgoY (gEgo y:))
				(gCurRoom newRoom: 580)
			)
		)
	)
)

(instance toDownAirRm of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 0 setMotion: MoveTo 320 (gEgo y:) self)
			)
			(1
				(if (!= gEgoGait 4) ; holdingLamp
					(EgoGait 4 0) ; holdingLamp
					(HighPrint 570 27) ; "You rekindle your lamp."
				)
				(= cycles 2)
			)
			(2
				(= gEgoY (gEgo y:))
				(gCurRoom newRoom: 580)
			)
		)
	)
)

(instance longStep of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					view: 575
					setLoop: 5
					cel: 0
					posn: (+ (gEgo x:) 7) (+ (gEgo y:) 5)
				)
				(= cycles 1)
			)
			(1
				(gEgo cel: 1 posn: (+ (gEgo x:) 5) (- (gEgo y:) 9))
				(= cycles 1)
			)
			(2
				(gEgo cel: 2 posn: (+ (gEgo x:) 5) (gEgo y:))
				(= cycles 1)
			)
			(3
				(gEgo cel: 3 posn: (+ (gEgo x:) 3) (gEgo y:))
				(= cycles 1)
			)
			(4
				(gEgo cel: 4 posn: (+ (gEgo x:) 9) (gEgo y:))
				(= cycles 1)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance log of TargActor
	(properties
		x 59
		y 19
		noun '/log,forest,board,debris'
		description {the log}
		lookStr {The old logs and other debris come from above.__The rushing water carries them deep into the caverns far below.}
		view 570
		signal 16384
		illegalBits 0
	)

	(method (fetchMe)
		(Print 570 28) ; "The log is too large and has too much momentum for your Fetch spell to have much effect."
		(return 1)
	)

	(method (hurtMe amount whatHurt)
		(if (== (whatHurt type:) 25)
			(loggerScript cycles: 0 changeState: 0)
			(self posn: 150 220)
			(return 1)
		)
	)
)

(instance rocks of TargActor
	(properties
		x 12
		y 125
		noun '/brick,boulder,base'
		description {the rocks}
		view 575
		loop 10
		priority 4
		signal 16400
		illegalBits 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if crossedRiver
				(HighPrint 570 29) ; "Careful examination of the airhole and the rocks above reveals that there are some loose stones that hold the structure together. There are small fissures running between its base and the rocks above."
			else
				(HighPrint 570 30) ; "There appears to be an opening in the rocks, but it's hard to see from this side of the river."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (detectMe)
		(Print 570 31) ; "There is an aura of magic throughout this room."
		(return 1)
	)

	(method (openMe)
		(Print 570 32) ; "Your spell opens up some of the smaller fissures in the stones."
		(self setScript: rocksFall)
	)

	(method (hurtMe amount whatHurt)
		(switch (whatHurt type:)
			(25
				(Print 570 33) ; "The rocks will not burn."
			)
			(27
				(cond
					((IsFlag 107) ; fWindShutOff
						(HighPrint 570 8) ; "You have already stopped the wind."
					)
					((> hitY 109)
						(self setScript: rocksFall)
					)
					(else
						(Print 570 34) ; "The rocks shake, but they are still well-supported at the base."
					)
				)
			)
			(else
				(return 0)
			)
		)
		(return 1)
	)
)

(instance air of Prop
	(properties
		x 4
		y 141
		z 30
		noun '/air,wind,chasm,airhole,opening'
		description {the wind}
		lookStr {Great volumes of air are being sucked into this small hole.}
		view 571
		signal 16384
	)

	(method (onMe)
		(return 0)
	)
)

(instance water1 of Prop
	(properties
		x 77
		y 26
		description {}
		lookStr {The rushing river surges from above forming a raging waterfall.}
		view 570
		loop 3
		cel 1
		priority 5
		signal 16400
		cycleSpeed 1
	)
)

(instance water2 of Prop
	(properties
		x 176
		y 182
		description {}
		lookStr {The lower cascade falls seemingly forever to the rocks below.}
		view 570
		loop 8
		priority 3
		signal 16400
		cycleSpeed 1
	)
)

(instance water3 of Prop
	(properties
		x 222
		y 184
		description {}
		lookStr {The lower cascade falls seemingly forever to the rocks below.}
		view 570
		loop 8
		cel 1
		priority 3
		signal 16400
		cycleSpeed 1
	)
)

(instance water4 of Prop
	(properties
		x 103
		y 98
		description {}
		lookStr {The rushing river boils furiously.}
		view 570
		loop 5
		cel 2
		priority 3
		signal 16400
		cycleSpeed 1
	)
)

(instance water5 of Prop
	(properties
		x 81
		y 39
		description {}
		lookStr {The rushing river surges from above forming a raging waterfall.}
		view 570
		loop 4
		cel 3
		priority 5
		signal 16400
		cycleSpeed 1
	)
)

(instance water6 of Prop
	(properties
		x 92
		y 61
		description {}
		lookStr {The rushing river surges from above forming a raging waterfall.}
		view 570
		loop 4
		priority 3
		signal 16400
		cycleSpeed 1
	)
)

(instance water7 of Prop
	(properties
		x 81
		y 59
		description {}
		lookStr {The rushing river surges from above forming a raging waterfall.}
		view 570
		loop 4
		cel 2
		priority 5
		signal 16400
		cycleSpeed 1
	)
)

(instance water8 of Prop
	(properties
		x 81
		y 48
		description {}
		lookStr {The rushing river surges from above forming a raging waterfall.}
		view 570
		loop 4
		cel 2
		priority 5
		signal 16400
		cycleSpeed 1
	)
)

(instance water9 of Prop
	(properties
		x 90
		y 75
		description {}
		lookStr {The rushing river surges from above forming a raging waterfall.}
		view 570
		loop 4
		cel 3
		priority 5
		signal 16400
		cycleSpeed 1
	)
)

(instance water10 of Prop
	(properties
		x 94
		y 87
		description {}
		lookStr {The rushing river surges from above forming a raging waterfall.}
		view 570
		loop 4
		priority 5
		signal 16400
		cycleSpeed 1
	)
)

(instance wallShine of Actor
	(properties
		x 43
		y 17
		view 586
		loop 1
		signal 18448
		illegalBits 0
	)

	(method (doit)
		(if (and (not (& signal $0080)) (IsFlag 116) (== (gEgo view:) 585)) ; fLightOn
			(switch (gEgo loop:)
				(0
					(self posn: (+ (gEgo x:) 10) (- (gEgo y:) 20))
				)
				(1
					(self posn: (- (gEgo x:) 10) (- (gEgo y:) 20))
				)
				(2
					(self posn: (gEgo x:) (- (gEgo y:) 20))
				)
				(3
					(self posn: (gEgo x:) (- (gEgo y:) 30))
				)
				(4
					(self posn: (+ (gEgo x:) 12) (- (gEgo y:) 15))
				)
				(5
					(self posn: (- (gEgo x:) 20) (- (gEgo y:) 20))
				)
				(6
					(self posn: (+ (gEgo x:) 12) (- (gEgo y:) 25))
				)
				(else
					(self posn: (- (gEgo x:) 20) (- (gEgo y:) 20))
				)
			)
		)
		(super doit:)
	)
)

(instance stairFeat of Feature
	(properties
		x 30
		y 80
		noun '/ladder,step'
		nsTop 54
		nsLeft 14
		nsBottom 100
		nsRight 58
		description {the steps}
		lookStr {Near the waterfall, the stone has formed into a natural stairway.}
	)
)

(instance fallFeat1 of Feature
	(properties
		x 90
		y 80
		noun '/cascade,water'
		nsLeft 45
		nsBottom 50
		nsRight 110
		description {the waterfall}
		lookStr {The rushing river surges from above to form a raging waterfall.}
	)
)

(instance fallFeat2 of Feature
	(properties
		x 90
		y 90
		noun '/cascade,cascade'
		nsTop 50
		nsLeft 65
		nsBottom 97
		nsRight 135
		description {the waterfall}
		lookStr {The rushing river surges from above to form a raging waterfall.}
	)
)

