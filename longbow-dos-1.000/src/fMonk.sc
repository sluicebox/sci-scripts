;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use n013)
(use n121)
(use Wat)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	fMonk 0
	monkScript 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 4] = [1027 27 1 0]
	[local12 6] = [1027 1 2 1 2 0]
	[local18 4] = [1027 4 1 0]
	[local22 6] = [1027 11 2 1 2 0]
	[local28 5] = [1027 14 1 2 0]
	[local33 13] = [1027 17 1 2 1 2 1 2 2 2 1 2 0]
	[local46 4] = [1027 5 1 0]
	[local50 5] = [1027 6 1 2 0]
	[local55 5] = [1027 28 2 1 0]
	[local60 9] = [1027 30 1 2 2 1 2 2 0]
	[local69 4] = [1027 36 1 0]
	[local73 4] = [1027 38 1 0]
	[local77 5] = [1027 39 2 1 0]
	[local82 4] = [1027 41 1 0]
	[local86 5] = [1027 42 1 2 0]
	[local91 4] = [1027 37 1 0]
	[local95 5] = [1027 44 2 1 0]
	[local100 8] = [1027 46 1 2 3 1 2 0]
	[local108 7] = [1027 51 2 1 2 1 0]
	[local115 9] = [1027 55 3 1 2 1 1 1 0]
	[local124 8] = [1027 61 2 3 1 1 1 0]
	[local132 10] = [1027 66 4 1 2 3 2 1 4 0]
	[local142 4] = [1027 73 1 0]
	[local146 4] = [1027 74 1 0]
)

(instance fMonk of Actor
	(properties
		description {the Fens Monk}
		view 128
		signal 8192
	)

	(method (init)
		(gSFX number: 126 loop: -1 play:)
		(if (== (Wat travelDir:) 1)
			(= local2 1)
		)
		(if (== gDay 5)
			(SetFlag 133)
		else
			(SetFlag 134)
		)
		(closePoly init:)
		(super init:)
	)

	(method (doit)
		(cond
			((or script (gEgo script:) (gCurRoom script:)))
			((and (not local1) (closePoly onMe: gEgo))
				(= local1 1)
				(gEgo setScript: getBack)
			)
			(
				(and
					local2
					(if (== (Wat travelDir:) 1)
						(< (GetAngle (gEgo x:) (gEgo y:) x y) 170)
					else
						(> (GetAngle x y (gEgo x:) (gEgo y:)) 190)
					)
				)
				(self setScript: LRScript)
			)
			(
				(and
					(not local2)
					(if (== (Wat travelDir:) 1)
						(> (GetAngle (gEgo x:) (gEgo y:) x y) 190)
					else
						(< (GetAngle x y (gEgo x:) (gEgo y:)) 170)
					)
				)
				(self setScript: RLScript)
			)
			((and local3 (not (gEgo inRect: 20 50 300 180)))
				(gEgo setScript: comeBackLittleEgo)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1027 0) ; "He's hard, lean, and muscular, and he carries his quarterstaff with readiness. A dangerous adversary."
			)
			(5 ; Talk
				(if (Wat offRoad:)
					(if (not (Wat charFirstTalk:))
						(Wat charFirstTalk: 1)
						(Converse @local12 1 11) ; "What's the meaning of this ruse?"
					else
						(Converse 1 @local18 11 3) ; "I'll not move until you are gone."
					)
				else
					(Converse 1 @local46 11 3) ; "Enough talk. Are you a man of words or deeds?"
				)
			)
			(10 ; Longbow
				(gEgo setScript: drawBow)
			)
			(4 ; Inventory
				(if (== invItem 0) ; bucks
					(if local4
						(Say 1027 8 1) ; "He scorns my money. I'll not offer it again."
					else
						(= local4 1)
						(Converse @local50 1 11) ; "I'm not an entirely unreasonable man. I'll buy your robe and possessions. Name your price."
					)
				else
					(gEgo setMotion: PChase fMonk 20)
				)
			)
			(3 ; Do
				(gEgo setScript: getBack)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gSFX fade: 0 30 8 1)
		(gCurRoom notify:)
		(self setCycle: 0 setMotion: 0)
		(Wat weMeetAgain: 1)
		(if (gFeatures contains: closePoly)
			(closePoly dispose:)
		)
		(SetFlag 39)
		(super dispose:)
		(self delete:)
		(DisposeScript 27)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(if (and (== theVerb 4) (== invItem 1)) ; Inventory, horn
				(if local3
					(Say 1027 9 0) ; "But my men are already here."
				else
					(gEgo setScript: getYerMen)
				)
				1
			)
		)
	)
)

(instance menActions of SpecialDoVerb
	(properties)

	(method (doVerb)
		(Say 1027 10 1) ; "My men wait for me to take action. I must do nothing else save deal with this monk."
		(return 1)
	)
)

(instance RLScript of Script
	(properties)

	(method (doit)
		(if (and (gEgo mover:) (closePoly onMe: gEgo))
			(gEgo setMotion: 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (Wat travelDir:) 3)
					(fMonk
						cel: 1
						loop: (+ (fMonk loop:) 1)
						x: (+ (fMonk x:) 5)
						y: (- (fMonk y:) 2)
					)
				else
					(fMonk cel: 1 loop: (- (fMonk loop:) 1) y: (- (fMonk y:) 1))
				)
				(= ticks 18)
			)
			(1
				(if (== (Wat travelDir:) 3)
					(fMonk cel: 0 x: (+ (fMonk x:) 7) y: (+ (fMonk y:) 4))
				else
					(fMonk cel: 0 x: (- (fMonk x:) 2) y: (- (fMonk y:) 2))
				)
				(= local2 1)
				(self dispose:)
			)
		)
	)
)

(instance LRScript of Script
	(properties)

	(method (doit)
		(if (and (gEgo mover:) (closePoly onMe: gEgo))
			(gEgo setMotion: 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (Wat travelDir:) 3)
					(fMonk cel: 1 x: (- (fMonk x:) 7) y: (- (fMonk y:) 4))
				else
					(fMonk cel: 1 x: (+ (fMonk x:) 2) y: (+ (fMonk y:) 2))
				)
				(= ticks 18)
			)
			(1
				(if (== (Wat travelDir:) 3)
					(fMonk
						loop: (- (fMonk loop:) 1)
						cel: 0
						x: (- (fMonk x:) 5)
						y: (+ (fMonk y:) 2)
					)
				else
					(fMonk loop: (+ (fMonk loop:) 1) cel: 0 y: (+ (fMonk y:) 1))
				)
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

(instance monkScript of TScript
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(if (== (Wat travelDir:) 3)
					(= temp0 235)
					(= temp1 50)
					(= temp2 205)
					(= temp3 70)
				else
					(= temp0 85)
					(= temp1 160)
					(= temp2 135)
					(= temp3 125)
				)
				(HandsOff)
				(Wat setScript: 0)
				(if (Wat weMeetAgain:)
					(client setScript: repeatEncounter)
				else
					(if (not (gCast contains: fMonk))
						(fMonk init:)
					)
					(fMonk
						posn: temp0 temp1
						setLoop: (if (== (Wat travelDir:) 3) 0 else 2)
						setCycle: Walk
						setMotion: MoveTo temp2 temp3 self
					)
				)
			)
			(1
				(fMonk
					setLoop: (if (== (Wat travelDir:) 3) 4 else 6)
					setCel: 0
					cycleSpeed: 60
					ignoreActors: 1
				)
				(NormalEgo)
				(= ticks 18)
			)
			(2
				(Converse @local22 3 11 self 0) ; "You block my way, friend."
			)
			(3
				(Converse @local28 1 11 self 0) ; "And if I do not?"
			)
			(4
				(Converse @local33 2 11 self) ; "I'm not a common outlaw. I'm Robin Hood."
			)
			(5
				(HandsOn)
				(gEgo actions: egoActions)
				(self dispose:)
			)
		)
	)
)

(instance repeatEncounter of Script
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(Converse 1 @local8 11 3 self) ; "I tire of this. Remove yourself from my path."
			)
			(2
				(HandsOn)
				(gEgo actions: egoActions)
				(self dispose:)
			)
		)
	)
)

(instance comeBackLittleEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Converse 1 @local142 11 1 self) ; "Aye, flee from me, outlaw, like the coward that you are."
			)
			(1
				(Face gEgo fMonk self)
			)
			(2
				(= ticks 12)
			)
			(3
				(Converse 1 @local146 2 0 self) ; "By my troth, you'll pay for that insult!"
			)
			(4
				(gEgo
					setMotion:
						PolyPath
						(if (== (Wat travelDir:) 3) 140 else 205)
						(if (== (Wat travelDir:) 3) 115 else 75)
						self
				)
			)
			(5
				(= local5 1)
				(client setScript: drawBow)
			)
		)
	)
)

(instance getBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local1
					(gEgo setMotion: 0)
					(Face gEgo fMonk self)
				else
					(gEgo setMotion: PChase fMonk 40 self)
				)
			)
			(1
				(fMonk setCel: 1)
				(= ticks 30)
			)
			(2
				(Converse @local55 1 11 self 1) ; "One more step and I'll crack your skull open!"
			)
			(3
				(gEgo
					setCycle: Rev
					setLoop: (gEgo loop:)
					setMotion:
						MoveFwd
						(if (closePoly onMe: gEgo) -25 else -12)
						self
				)
			)
			(4
				(= local1 0)
				(NormalEgo)
				(fMonk setCel: 0)
				(= ticks 30)
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance drawBow of Script
	(properties)

	(method (dispose)
		(shootSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 4 5)
				(SetIcon 0)
				(HandsOff)
				(gGame setSpeed: global141)
				(Face gEgo fMonk self)
			)
			(1
				(gEgo view: 4 setCel: 0 setCycle: End self)
			)
			(2
				(shootSound loop: -1 play:)
				(gEgo
					view: 5
					setCel: 0
					setCycle: CT (- (gEgo lastCel:) 1) 1 self
				)
			)
			(3
				(= ticks 12)
			)
			(4
				(Converse @local60 2 11 self) ; "Remove your robe and turn over your possessions now or I will kill you."
			)
			(5
				(gSFX stop:)
				(if (AyeOrNay)
					(client setScript: staffFight)
				else
					(client setScript: shootMonk)
				)
			)
		)
	)
)

(instance staffFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX number: 15 loop: -1 play: hold: 1)
				(Converse 1 @local69 2 0 self) ; "I accept."
			)
			(1
				(LoadMany rsVIEW 702 703 15 122 124 167)
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo)
				(gEgo
					setMotion:
						PolyPath
						(if (== (Wat travelDir:) 3) 140 else 205)
						(if (== (Wat travelDir:) 3) 115 else 75)
						self
				)
			)
			(3
				(= ticks 12)
			)
			(4
				(if local3
					(+= state 8)
					(self cue:)
				else
					(self setScript: (ScriptID 5 1) self) ; blowinIt
				)
			)
			(5
				(gRgnMusic fade: 0 30 8 1)
				(Converse @local77 2 11 self) ; "What is this?"
			)
			(6
				(gEgo
					setMotion:
						PolyPath
						(if (== (Wat travelDir:) 3) 140 else 205)
						(if (== (Wat travelDir:) 3) 115 else 75)
						self
				)
			)
			(7
				(= ticks 12)
			)
			(8
				(fMonk stopUpd:)
				(gEgo stopUpd:)
				(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
			)
			(9
				(Face gEgo (ScriptID 19)) ; John
				((ScriptID 23) actions: (menActions new:)) ; Tuck
				((ScriptID 20) actions: (menActions new:)) ; Will
				((ScriptID 19) ; John
					ignoreActors: 1
					actions: (menActions new:)
					setMotion: PolyPath 90 101 self
				)
			)
			(10
				(Face (ScriptID 19) gEgo self) ; John
			)
			(11
				(= ticks 12)
			)
			(12
				(Converse 1 @local82 13 3 self) ; "What is it, Master? Does this Monk trouble you overmuch?"
			)
			(13
				(if local3
					(Face gEgo (ScriptID 19) self) ; John
				else
					(+= state 1)
					(self cue:)
				)
			)
			(14
				(= ticks 12)
			)
			(15
				(Converse 2 @local86 1 2 13 3 self) ; "Little John, will you lend me your quarterstaff? This Monk has challenged my honour."
			)
			(16
				(gEgo setMotion: MoveTo 222 117 self)
			)
			(17
				(gEgo setHeading: 135 self)
			)
			(18
				(gEgo
					view: 15
					posn: (+ (gEgo x:) 5) (+ (gEgo y:) 5)
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
				((= local6 (Prop new:))
					view: 15
					ignoreActors: 1
					posn: (gEgo x:) (gEgo y:)
					setLoop: 6
					setCel: 0
					cycleSpeed: 12
					init:
					setCycle: End
					yourself:
				)
			)
			(19
				(local6 addToPic:)
				(gEgo setCycle: Beg self)
			)
			(20
				(gEgo
					posn: (- (gEgo x:) 9) (- (gEgo y:) 3)
					setLoop: 3
					setCycle: CT 5 1 self
				)
			)
			(21
				(NormalEgo 2 702 703)
				(gEgo setHeading: 0 self)
				((= local7 (PicView new:))
					view: 15
					x: (+ (gEgo x:) 6)
					y: (+ (gEgo y:) 2)
					loop: 4
					cel: 0
					init:
					yourself:
				)
			)
			(22
				(gGame setSpeed: global141)
				(gEgo setMotion: MoveTo 131 99 self)
			)
			(23
				((ScriptID 20) ; Will
					setMotion:
						MoveTo
						(+ ((ScriptID 20) x:) 20) ; Will
						((ScriptID 20) y:) ; Will
						self
				)
				(fMonk
					setLoop: (if (== (Wat travelDir:) 3) 0 else 2)
					cycleSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 162 97 self
				)
			)
			(24
				((ScriptID 20) setHeading: 180) ; Will
			)
			(25
				(fMonk view: 124 loop: 0 cel: 0)
				(gEgo view: 167 loop: 3 cel: 0)
				((ScriptID 19) view: 167 loop: 2 cel: 0 setCycle: CT 3 1 self) ; John
			)
			(26
				((ScriptID 19) setCycle: End) ; John
				(gEgo setCycle: End self)
			)
			(27
				(gEgo view: 122 posn: 145 100 loop: 0 cel: 0)
				(= ticks 30)
			)
			(28
				((gEgo looper:) dispose:)
				(gEgo hide: looper: 0)
				(gEgoHead hide:)
				(User canControl: 0)
				(fMonk hide: stopUpd:)
				((ScriptID 19) stopUpd:) ; John
				((ScriptID 20) stopUpd:) ; Will
				((ScriptID 23) stopUpd:) ; Tuck
				(Wat qFight: 4660)
				(closePoly dispose:)
				((ScriptID 120 4) dispose:) ; westSide
				((ScriptID 120 3) dispose:) ; eastSide
				((ScriptID 120 2) dispose:) ; theStreet
				(catchAll init:)
				(gAddToPics eachElementDo: #dispose release:)
				((gCurRoom obstacles:) eachElementDo: #dispose release:)
				(gSFX release:)
				(self setScript: (ScriptID 11) self) ; monkFight
			)
			(29
				(if (gEgo mover:)
					(gEgo setMotion: 0)
				)
				((ScriptID 120 4) init:) ; westSide
				((ScriptID 120 3) init:) ; eastSide
				((ScriptID 120 2) init:) ; theStreet
				(catchAll dispose:)
				(switch (Wat qFight:)
					(1
						(fMonk view: 124 loop: 0 cel: 0 show:)
						(gEgo view: 122 posn: 145 100 loop: 10 cel: 6 show:)
					)
					(2
						(fMonk view: 124 loop: 10 cel: 6 show:)
						(gEgo view: 167 posn: 131 99 loop: 3 cel: 7 show:)
					)
				)
			)
			(30
				(= ticks 12)
			)
			(31
				((ScriptID 19) startUpd:) ; John
				((ScriptID 20) startUpd:) ; Will
				((ScriptID 23) startUpd:) ; Tuck
				(DisposeScript 11)
				(= ticks 30)
			)
			(32
				(switch (Wat qFight:)
					(1
						(client setScript: dieRobinDie)
					)
					(2
						(client setScript: dieMonkDie)
					)
				)
			)
		)
	)
)

(instance dieRobinDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse @local95 13 11 self) ; "Robin Hood is dead! Death to all outlaws."
			)
			(1
				(= gDeathNum 0)
				(((ScriptID 19) actions:) dispose:) ; John
				(((ScriptID 23) actions:) dispose:) ; Tuck
				(((ScriptID 20) actions:) dispose:) ; Will
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance dieMonkDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: CT 5 -1 self)
			)
			(1
				(gEgo cycleSpeed: 6 setCycle: Beg)
				((ScriptID 19) cycleSpeed: 6 setCycle: Beg self) ; John
			)
			(2
				(NormalEgo 1 702 703)
				(= ticks 30)
			)
			(3
				(gSFX number: 128 loop: -1 play:)
				(Converse 3 @local100 1 0 13 1 14 3 self) ; "He fought well."
			)
			(4
				(SetFlag 147)
				(gCurRoom drawPic: 803 -32762)
				(= gDisguiseNum 6) ; fens monk
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(gEgo get: 5 6) ; pipe
				(NormalEgo 5)
				(gCast eachElementDo: #hide)
				(= seconds 3)
			)
			(5
				(((ScriptID 19) actions:) dispose:) ; John
				(((ScriptID 23) actions:) dispose:) ; Tuck
				((ScriptID 19) actions: 0 dispose:) ; John
				((ScriptID 23) actions: 0 dispose:) ; Tuck
				(gCurRoom drawPic: 120 -32761)
				(gGame setCursor: 0 1)
				(proc121_0 1)
				((ScriptID 20) posn: 200 110 loop: 1 show:) ; Will
				(gEgo show:)
				(gEgoHead show:)
				(= ticks 24)
			)
			(6
				(Converse @local108 8 14 self) ; "You look the part, Robin, even without a staff. But surely you could have kept Little John's?"
			)
			(7
				((ScriptID 20) setMotion: PolyPath 340 ((ScriptID 20) y:) self) ; Will, Will
			)
			(8
				(proc125_2)
				(((ScriptID 20) actions:) dispose:) ; Will
				((ScriptID 20) actions: 0 dispose:) ; Will
				(= cycles 2)
			)
			(9
				(HandsOn)
				(SetIcon 0)
				(SetScore (if local5 25 else 100))
				(self dispose:)
				(fMonk dispose:)
			)
		)
	)
)

(instance hereComesWill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ScriptID 20) ; Will
				(ScriptID 23) ; Tuck
				(LoadMany rsVIEW 160 161 154 155)
				((ScriptID 20) ; Will
					posn: 330 125
					init:
					setCycle: StopWalk 161
					setMotion: MoveTo 240 125 self
				)
				((ScriptID 23) ; Tuck
					posn: 335 120
					init:
					setCycle: StopWalk 155
					setMotion: MoveTo 270 120
				)
			)
			(1
				(= ticks 12)
			)
			(2
				(Face gEgo (ScriptID 20) self) ; Will
			)
			(3
				(= ticks 12)
			)
			(4
				(Converse 3 @local115 1 0 14 1 15 3 self) ; "Master! We heard the Monk issue his challenge and hurried to see you fight him."
			)
			(5
				(= ticks 45)
			)
			(6
				(SetFlag 147)
				(gCurRoom drawPic: 803 -32762)
				(= gDisguiseNum 6) ; fens monk
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(gEgo get: 5 6 posn: 160 90) ; pipe
				(gCast eachElementDo: #hide)
				(= seconds 3)
			)
			(7
				(gCurRoom drawPic: 120 -32761)
				(proc121_0)
				((ScriptID 20) dispose:) ; Will
				((ScriptID 23) dispose:) ; Tuck
				(NormalEgo 2)
				(gEgo show:)
				(proc125_2)
				(SetIcon 0)
				(= cycles 3)
			)
			(8
				(SetScore -100)
				(HandsOn)
				(self dispose:)
				(fMonk dispose:)
			)
		)
	)
)

(instance shootMonk of Script
	(properties)

	(method (dispose)
		(shootSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 1 @local91 2 0 self) ; "Death to traitors!"
			)
			(1
				(gEgo cel: (gEgo lastCel:))
				(= ticks (/ (gEgo distanceTo: fMonk) 2))
			)
			(2
				(shootSound number: 906 loop: 1 play:)
				(fMonk
					setLoop: (+ (fMonk loop:) 4)
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(3
				(gSFX stop:)
				(shootSound number: 907 play:)
				(NormalEgo)
				(gEgo setMotion: PChase fMonk 30 self)
			)
			(4
				(if local3
					((ScriptID 20) setMotion: PChase fMonk 45 self) ; Will
				else
					(client setScript: hereComesWill)
				)
				(gSFX number: 127 loop: -1 play:)
			)
			(5
				(Converse 3 @local124 1 0 14 1 15 3 self) ; "I've no love for these monks, but you should've fought him fairly."
			)
			(6
				(SetFlag 147)
				(= gDisguiseNum 6) ; fens monk
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(gEgo get: 5 6) ; pipe
				(proc125_2)
				(((ScriptID 20) actions:) dispose:) ; Will
				(((ScriptID 23) actions:) dispose:) ; Tuck
				(((ScriptID 19) actions:) dispose:) ; John
				((ScriptID 20) actions: 0 dispose:) ; Will
				((ScriptID 23) actions: 0 dispose:) ; Tuck
				((ScriptID 19) actions: 0 dispose:) ; John
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 -32761)
				(= seconds 3)
			)
			(7
				(gCurRoom drawPic: 120 -32761)
				(proc121_0)
				(gEgo posn: 160 90 show:)
				(NormalEgo)
				(proc125_2)
				(= cycles 3)
				(SetIcon 0)
			)
			(8
				(SetScore -100)
				(HandsOn)
				(self dispose:)
				(fMonk dispose:)
			)
		)
	)
)

(instance getYerMen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(1
				(Converse 1 @local73 11 3 self) ; "One man...a dozen. Call all your men. It matters not. I'm prepared to die."
			)
			(2
				(fMonk stopUpd:)
				(gEgo
					setMotion:
						PolyPath
						(if (== (Wat travelDir:) 3) 140 else 205)
						(if (== (Wat travelDir:) 3) 115 else 75)
						self
				)
			)
			(3
				(Face gEgo fMonk self)
			)
			(4
				(= ticks 12)
			)
			(5
				(gEgo stopUpd:)
				(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
			)
			(6
				(Face gEgo (ScriptID 19)) ; John
				((ScriptID 19) ; John
					ignoreActors: 1
					setMotion: PChase gEgo 35 self
				)
			)
			(7
				((ScriptID 19) actions: (menActions new:)) ; John
				((ScriptID 20) actions: (menActions new:)) ; Will
				((ScriptID 23) actions: (menActions new:)) ; Tuck
				(= ticks 12)
			)
			(8
				(Converse 4 @local132 1 0 11 3 14 1 13 2 self) ; "What say you, Robin? Do you wish him taken?"
			)
			(9
				((ScriptID 19) setMotion: MoveTo 90 101 self) ; John
			)
			(10
				(Face (ScriptID 19) gEgo self) ; John
			)
			(11
				(= local3 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 73 107 65 96 103 96 96 107
							yourself:
						)
				)
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance closePoly of Feature
	(properties)

	(method (init)
		(if (== (Wat travelDir:) 3)
			((= onMeCheck (Polygon new:))
				type: PTotalAccess
				init: 319 42 318 63 194 94 0 34
				yourself:
			)
		else
			((= onMeCheck (Polygon new:))
				type: PTotalAccess
				init: 0 104 86 104 151 94 210 126 205 152 0 147
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(cond
			(((ScriptID 120 3) onMe: self) ; eastSide
				((ScriptID 120 3) doVerb: theVerb &rest) ; eastSide
			)
			(((ScriptID 120 4) onMe: self) ; westSide
				((ScriptID 120 4) doVerb: theVerb &rest) ; westSide
			)
			(else
				((ScriptID 120 2) doVerb: theVerb &rest) ; theStreet
			)
		)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance catchAll of Feature
	(properties
		nsBottom 189
		nsRight 319
	)

	(method (doVerb)
		(return 1)
	)
)

(instance shootSound of Sound
	(properties
		flags 1
		number 900
	)
)

