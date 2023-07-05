;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 226)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	marian 0
	marianAttack 1
	randomHorse 2
	glassSlipper 3
	dummySlip 4
	monk 5
	dummyMonk 6
	stick 7
	dummyStick 8
	menGather 9
	johnPic 10
	tuckPic 11
	willPic 12
	muchPic 13
	dumpMarian 14
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
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	[local23 4] = [1226 0 1 0]
	[local27 4] = [1226 1 1 0]
	[local31 4] = [1226 2 1 0]
	[local35 11] = [1226 3 2 2 1 2 1 2 1 2 0]
	[local46 13] = [1226 11 2 2 1 2 2 0 1226 16 1 1 0]
	[local59 4] = [1226 18 1 0]
	[local63 5] = [1226 19 1 2 0]
	[local68 12] = [1226 32 2 1 3 1 4 1 1 2 3 0]
	[local80 4] = [1226 41 1 0]
	[local84 4] = [1226 44 1 0]
	[local88 4] = [1226 45 1 0]
	[local92 4] = [1226 46 1 0]
	[local96 13] = [1226 47 1 0 -1 {Robin Hood} 0 0 0 0 0 0 0]
)

(instance bowSound of Sound
	(properties)
)

(instance marian of Actor
	(properties
		yStep 9
		view 214
		illegalBits 0
		xStep 12
	)

	(method (init)
		(HandsOff)
		(LoadMany rsVIEW 214 222 223 221 224 218)
		(LoadMany rsSOUND 218 913 906 908 916)
		(if (== gEgoEdgeHit 2)
			(self loop: 1 posn: 197 101)
		else
			(self loop: 0 posn: 140 120)
		)
		(self setCycle: Fwd setScript: marianAttack)
		(gEgo setScript: randomHorse)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1226 24 1) ; "She cannot hold him off much longer!"
			)
			(3 ; Do
				(Say 1226 25 1) ; "I cannot reach from here!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance monk of Actor
	(properties
		view 218
		loop 1
		signal 16384
		illegalBits 0
	)

	(method (init)
		(if (== gEgoEdgeHit 2)
			(= local19 233)
			(= local20 99)
			(self loop: 1 posn: 233 119)
		else
			(= local19 103)
			(= local20 117)
			(self loop: 0 posn: 103 137)
		)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (doit)
		(cond
			(
				(and
					(<= (gEgo y:) y)
					(not local16)
					(!= (gEgo script:) watchHerDie)
				)
				(marian setScript: 0)
				(gEgo setScript: watchHerDie)
			)
			(
				(and
					(< (self distanceTo: gEgo) 40)
					(not local16)
					(!= (gEgo script:) suicide)
					(!= view 16)
					(!= loop 2)
					(!= loop 3)
				)
				(marian setScript: 0)
				(gEgo setScript: suicide)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(if (< loop 2)
					(Converse 2 @local63 2 0 11 1 self) ; "Dog of a monk! Let her go!"
				else
					(Say 1226 21 1) ; "He'll utter nothing ever again."
				)
			)
			(2 ; Look
				(if (< loop 2)
					(Say 1226 22 1) ; "'Tis a monk from the fens attacking the woman in my dreams."
				else
					(Say 1226 23 1) ; "He is, beyond a doubt, demised."
				)
			)
			(3 ; Do
				(cond
					((not local16)
						(Say 1226 26 1) ; "Bare hands will avail nothing against a quarterstaff!"
					)
					(local18
						(Say 1226 50 1) ; "I've already searched his body and found nothing of use."
					)
					(else
						(= local18 1)
						((ScriptID 23) setScript: beatItTimerScript) ; Tuck
						(gEgo setScript: searchMonk)
					)
				)
			)
			(10 ; Longbow
				(if (< loop 2)
					(marian setScript: 0)
					((ScriptID 220 0) setScript: 0) ; forest
					(gEgo setScript: skewerMonk)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance glassSlipper of Actor
	(properties
		yStep 30
		view 222
		loop 2
		cycleSpeed 5
		xStep 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1226 31 1) ; "'Tis Marian's slipper."
			)
			(3 ; Do
				((ScriptID 23) setScript: beatItTimerScript) ; Tuck
				(gEgo setScript: getSlipper)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stick of View
	(properties
		view 218
	)

	(method (init)
		(if (== gEgoEdgeHit 2)
			(self
				loop: 5
				priority: (- (monk priority:) 1)
				signal: 16465
				x: (- (monk x:) 24)
				y: (+ (monk y:) 1)
			)
		else
			(self
				loop: 4
				priority: (- (monk priority:) 1)
				signal: 16465
				x: (+ (monk x:) 23)
				y: (- (monk y:) 1)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1226 29 1) ; "The Monk's evil staff lies where it fell."
			)
			(3 ; Do
				(Say 1226 30 1) ; "I'll not touch the cursed thing that dared to strike my beauteous Marian."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance marianAttack of Script
	(properties)

	(method (doit)
		(if (and (gEgo edgeHit:) (not local22))
			(= local22 1)
			(SetFlag 5)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo actions: marianHornBlow)
				(NormalEgo)
				(SetFlag 182)
				(monk init:)
				(mariansSong play:)
				(if (== gEgoEdgeHit 2)
					(gEgo
						loop: 0
						posn: 1 188
						init:
						setMotion: PolyPath 41 182 self
					)
				else
					(gEgo
						loop: 1
						posn: 318 188
						init:
						setMotion: PolyPath 277 182 self
					)
				)
			)
			(1
				(Converse 1 @local23 22 0 self) ; "Help me! Help!"
			)
			(2
				(Converse 1 @local27 2 0 self) ; "`Tis her! The woman I dreamt of!"
			)
			(3
				(HandsOn)
				(if (not (HaveMouse))
					(gGame setCursor: gTheCursor 1 local19 local20)
				)
				(gEgo setScript: 0)
				((ScriptID 220 0) setScript: randomHorse) ; forest
				(gTheIconBar disable: 5)
				(cond
					((> gMachineSpeedZeroOrSix 7)
						(= seconds 10)
					)
					((> gMachineSpeedZeroOrSix 4)
						(= seconds 8)
					)
					(else
						(= seconds 6)
					)
				)
			)
			(4
				(SetIcon 3)
				(HandsOff)
				(= ticks 90)
			)
			(5
				(marian setCycle: Beg self)
			)
			(6
				(= local22 1)
				(mariansSong fade: 0 15 16 1)
				((ScriptID 220 0) setScript: 0) ; forest
				(gSFX2 number: 25 loop: -1 play:)
				(SetFlag 5)
				(marian
					view: 223
					setLoop: (if (== gEgoEdgeHit 2) 1 else 0)
					setCycle: End self
				)
				(monk setCycle: End)
				(= ticks 20)
			)
			(7
				(= local17 1)
				(glassSlipper
					signal: 26640
					cel: 3
					posn: (marian x:) (marian y:)
					init:
				)
			)
			(8
				(monk view: 16 loop: 0)
				(= ticks 12)
			)
			(9
				(mariansSong dispose:)
				(monk loop: 2)
				(= ticks 24)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Converse 1 @local31 11 0 self) ; "Not much of an outlaw, are you?"
			)
			(11
				(gEgo actions: marianHornBlow)
				(if (== gEgoEdgeHit 2)
					(monk setCycle: Walk setMotion: PolyPath 335 112 self)
				else
					(monk setCycle: Walk setMotion: PolyPath -13 137 self)
				)
				(marian
					view: 221
					setLoop: (if (== gEgoEdgeHit 2) 1 else 0)
					setStep: 3 2
					cycleSpeed: 8
					setCycle: Walk
					setMotion: PFollow monk 60
				)
			)
			(12
				(if (== gEgoEdgeHit 2)
					(marian
						setStep: 12 9
						setMotion: PolyPath 350 (marian y:) self
					)
				else
					(marian
						setStep: 12 9
						setMotion: PolyPath -150 (marian y:) self
					)
				)
			)
			(13
				(= ticks 270)
			)
			(14
				(HandsOn)
				(gSFX2 fade: 0 20 16 1)
				(LoadMany 0 930 851 928)
				((ScriptID 220 0) setScript: 0) ; forest
				(monk setCycle: 0 delete: dispose:)
				(marian setCycle: 0 setScript: 0 delete: dispose:)
			)
		)
	)
)

(instance skewerMonk of Script
	(properties)

	(method (doit)
		(if
			(and
				(or (== (monk loop:) 2) (== (monk loop:) 3))
				(== (monk cel:) 4)
			)
			(stick init:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					(
						(or
							(<=
								(= local21
									(GetAngle
										(gEgo x:)
										(gEgo y:)
										(monk x:)
										(monk y:)
									)
								)
								20
							)
							(> local21 340)
						)
						(gEgo setLoop: 3)
					)
					((<= local21 60)
						(gEgo setLoop: 6)
					)
					((<= local21 100)
						(gEgo setLoop: 0)
					)
					((<= local21 110)
						(gEgo setLoop: 4)
					)
					((<= local21 200)
						(gEgo setLoop: 2)
					)
					((<= local21 240)
						(gEgo setLoop: 5)
					)
					((<= local21 260)
						(gEgo setLoop: 1)
					)
					((<= local21 280)
						(gEgo setLoop: 7)
					)
				)
				(gEgo view: 4 setCel: 0 setCycle: Beg self)
			)
			(1
				(gEgo view: 5 setCel: 0 setCycle: End self)
			)
			(2
				(bowSound number: 906 loop: 1 init: play:)
				(= ticks 26)
			)
			(3
				(monk setLoop: (if (== gEgoEdgeHit 2) 3 else 2) setCel: 0)
				(bowSound number: 907 loop: 1 init: play:)
				(= ticks 12)
			)
			(4
				(monk setCycle: End self)
				(marian setScript: 0 setCycle: Beg)
			)
			(5
				(bowSound dispose:)
				(gSFX2 number: 25 loop: -1 play:)
				(mariansSong fade: 0 15 16 1)
				((ScriptID 220 0) setScript: 0) ; forest
				(NormalEgo)
				(monk z: -7 y: (- (monk y:) 7))
				(= local16 1)
				(SetFlag 23)
				(= seconds 2)
			)
			(6
				(if (== gEgoEdgeHit 2)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init:
									(+ (monk x:) 52)
									(+ (monk y:) 2)
									(+ (monk x:) 28)
									(+ (monk y:) 2)
									(+ (monk x:) 14)
									(+ (monk y:) 16)
									(- (monk x:) 21)
									(+ (monk y:) 9)
									(- (monk x:) 21)
									(- (monk y:) 2)
									(+ (monk x:) 2)
									(- (monk y:) 2)
									(+ (monk x:) 14)
									(- (monk y:) 9)
									(+ (monk x:) 52)
									(- (monk y:) 9)
								yourself:
							)
					)
				else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init:
									(+ (monk x:) 18)
									(+ (monk y:) 6)
									(- (monk x:) 17)
									(+ (monk y:) 16)
									(- (monk x:) 30)
									(+ (monk y:) 3)
									(- (monk x:) 51)
									(+ (monk y:) 1)
									(- (monk x:) 49)
									(- (monk y:) 8)
									(- (monk x:) 3)
									(- (monk y:) 8)
									(+ (monk x:) 18)
									(monk y:)
								yourself:
							)
					)
				)
				(bowSound number: 916 loop: 1 init: play:)
				(+= gScore 100)
				(stick stopUpd:)
				((ScriptID 0 1) doit:) ; statLine
				(= ticks 40)
			)
			(7
				(Converse 2 @local35 3 0 22 1 self) ; "Thank you, bold outlaw!"
			)
			(8
				(monk stopUpd:)
				(bowSound dispose:)
				(= ticks 60)
			)
			(9
				(mariansSong dispose:)
				(marian
					view: 222
					setLoop: (if (== gEgoEdgeHit 2) 1 else 0)
					setCel: 0
					setCycle: End self
				)
			)
			(10
				(glassSlipper
					setPri: 13
					signal: 26640
					posn: (marian x:) (- (marian y:) 74)
					init:
					setCycle: Fwd
					setScript: spinner self
				)
			)
			(11
				(Converse 2 @local46 3 0 22 1 self) ; "This slipper is your first reward, and there may be other rewards, if you are wise enough to earn them!"
			)
			(12
				(marian view: 224 setCycle: Walk)
				(if (== gEgoEdgeHit 2)
					(marian setLoop: 1 setMotion: MoveTo 350 100 self)
				else
					(marian setLoop: 0 setMotion: MoveTo -50 123 self)
				)
			)
			(13
				((ScriptID 220 0) setScript: 0) ; forest
				(Say 1226 16) ; "She rides swiftly away before I could ask about my dream."
				(Say 1226 17 self) ; "But we'll meet again my lovely Marian, for I've many a sweet reward in mind!"
			)
			(14
				(= ticks 170)
			)
			(15
				(HandsOn)
				(gEgo actions: marianHornBlow)
				(monk signal: 16384)
				(gSFX2 fade: 0 20 16 1)
				(marian dispose:)
				(= ticks 18)
			)
			(16
				(self dispose:)
			)
		)
	)
)

(instance noGoodShot of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 1) self)
			)
			(1
				(Say 1226 51 1) ; "*** I cannot get a good shot from here without risking Marian."
				(self dispose:)
			)
		)
	)
)

(instance searchMonk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gEgoEdgeHit 2)
					(gEgo
						setMotion:
							PolyPath
							(+ (monk x:) 39)
							(+ (monk y:) 4)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(- (monk x:) 39)
							(+ (monk y:) 4)
							self
					)
				)
			)
			(1
				(gEgo
					view: 7
					setLoop: (if (== gEgoEdgeHit 2) 0 else 1)
					setCycle: CT 5 1 self
				)
			)
			(2
				(gEgo setCel: 4)
				(= ticks 18)
			)
			(3
				(gEgo setCel: 5)
				(= ticks 18)
			)
			(4
				(Say 1226 27 self) ; "The robe is no use to me. Covered with blood as it is, I'd only arouse suspicion and questions if I were to wear it."
			)
			(5
				(Say 1226 28 self) ; "'Tis odd that he carries no pouch, but I can find nothing of value upon him."
			)
			(6
				(gEgo setCel: -1 setCycle: End self)
			)
			(7
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getSlipper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo x:) (glassSlipper x:))
					(gEgo
						setMotion:
							PolyPath
							(- (glassSlipper x:) 12)
							(+ (glassSlipper y:) 16)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (glassSlipper x:) 8)
							(+ (glassSlipper y:) 16)
							self
					)
				)
			)
			(1
				(gEgo
					view: 7
					setCel: 0
					setLoop: (if (< (gEgo x:) (glassSlipper x:)) 1 else 0)
					setCycle: CT 4 1 self
				)
			)
			(2
				(glassSlipper hide:)
				(= local17 0)
				(SetFlag 53)
				(gEgo get: 3) ; slipper
				(bowSound number: 916 loop: 1 init: play:)
				(+= gScore 100)
				((ScriptID 0 1) doit:) ; statLine
				(gEgo setCycle: End self)
			)
			(3
				(gEgo loop: (if (not (gEgo loop:)) 6 else 7))
				(bowSound dispose:)
				(glassSlipper dispose:)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance spinner of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gEgoEdgeHit 2)
					(glassSlipper
						signal: (| (glassSlipper signal:) $2000)
						setMotion:
							MoveTo
							(- (glassSlipper x:) 14)
							(- (glassSlipper y:) 2)
							self
					)
				else
					(glassSlipper
						signal: (| (glassSlipper signal:) $2000)
						setMotion:
							MoveTo
							(+ (glassSlipper x:) 14)
							(- (glassSlipper y:) 2)
							self
					)
				)
			)
			(1
				(if (== gEgoEdgeHit 2)
					(glassSlipper
						setMotion:
							MoveTo
							(- (glassSlipper x:) 14)
							(+ (glassSlipper y:) 2)
							self
					)
				else
					(glassSlipper
						setMotion:
							MoveTo
							(+ (glassSlipper x:) 14)
							(+ (glassSlipper y:) 2)
							self
					)
				)
			)
			(2
				(if (== gEgoEdgeHit 2)
					(glassSlipper
						setMotion:
							MoveTo
							(- (glassSlipper x:) 10)
							(+ (glassSlipper y:) 35)
							self
					)
				else
					(glassSlipper
						setMotion:
							MoveTo
							(+ (glassSlipper x:) 10)
							(+ (glassSlipper y:) 35)
							self
					)
				)
			)
			(3
				(if (== gEgoEdgeHit 2)
					(glassSlipper
						setMotion:
							MoveTo
							(+ (glassSlipper x:) 1)
							(+ (glassSlipper y:) 52)
							self
					)
				else
					(glassSlipper
						setMotion:
							MoveTo
							(+ (glassSlipper x:) 1)
							(+ (glassSlipper y:) 42)
							self
					)
				)
			)
			(4
				(glassSlipper
					setPri: -1
					signal: 26624
					setCel: 0
					setCycle: CT 3 1
					setMotion:
						MoveTo
						(glassSlipper x:)
						(- (glassSlipper y:) 3)
						self
				)
			)
			(5
				(glassSlipper
					setCycle: 0
					setMotion:
						MoveTo
						(glassSlipper x:)
						(+ (glassSlipper y:) 3)
						self
				)
				(= local17 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance watchHerDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath (- (gEgo x:) 1) (gEgo y:))
				(marian setCycle: Beg)
				(= ticks 12)
			)
			(1
				(monk
					view: 218
					setLoop: (if (== gEgoEdgeHit 2) 1 else 0)
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(monk setCycle: Beg)
				(mariansSong fade: 0 15 16 1)
				((ScriptID 220 0) setScript: 0) ; forest
				(gSFX2 number: 25 loop: -1 play:)
				(SetFlag 5)
				(marian
					view: 223
					setLoop: (if (== gEgoEdgeHit 2) 1 else 0)
					setCycle: End self
				)
				(= ticks 20)
			)
			(3
				(= local17 1)
				(glassSlipper
					signal: 26640
					cel: 3
					posn: (marian x:) (marian y:)
					init:
				)
			)
			(4
				(monk
					view: 16
					setLoop: (if (== gEgoEdgeHit 2) 1 else 0)
					setCel: 0
				)
				(= ticks 48)
			)
			(5
				(Converse 1 @local31 11 0 self) ; "Not much of an outlaw, are you?"
			)
			(6
				(gEgo actions: marianHornBlow)
				(if (== gEgoEdgeHit 2)
					(monk
						setCycle: Walk
						setLoop: -1
						setMotion: PolyPath 335 112 self
					)
				else
					(monk
						setCycle: Walk
						setLoop: -1
						setMotion: PolyPath -13 137 self
					)
				)
				(marian
					view: 221
					setLoop: (if (== gEgoEdgeHit 2) 1 else 0)
					setStep: 3 2
					cycleSpeed: 8
					setCycle: Walk
					setMotion: PFollow monk 60
				)
			)
			(7
				(if (== gEgoEdgeHit 2)
					(marian
						setStep: 12 9
						setMotion: PolyPath 350 (marian y:) self
					)
				else
					(marian
						setStep: 12 9
						setMotion: PolyPath -150 (marian y:) self
					)
				)
			)
			(8
				(mariansSong fade: 0 30 15 1)
				(= ticks 270)
			)
			(9
				(HandsOn)
				(mariansSong dispose:)
				(LoadMany 0 930 851 928)
				((ScriptID 220 0) setScript: 0) ; forest
				(monk setCycle: 0 delete: dispose:)
				(marian setCycle: 0 setScript: 0 delete: dispose:)
				(= ticks 12)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance suicide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== gEgoEdgeHit 2)
					(gEgo
						setMotion:
							PolyPath
							(- (monk x:) 10)
							(+ (monk y:) 7)
							self
					)
				else
					(gEgo
						setMotion:
							PolyPath
							(+ (monk x:) 10)
							(+ (monk y:) 7)
							self
					)
				)
			)
			(1
				(marian setCycle: Beg)
				(gEgo signal: (| (gEgo signal:) $4000) setLoop: 3)
				(= ticks 12)
			)
			(2
				(monk view: 585 setLoop: 0 setCel: 0 setCycle: End)
				(= ticks 30)
			)
			(3
				(gEgo view: 792 setCel: 1 setCycle: End self)
			)
			(4
				(dieSound play:)
				(monk setCycle: CT 1 1 self)
			)
			(5
				(monk
					view: 218
					setLoop: (if (== gEgoEdgeHit 2) 1 else 0)
					setCel: 0
					setCycle: End self
				)
			)
			(6
				(monk setCycle: Beg)
				(SetFlag 5)
				(marian
					view: 223
					setLoop: (if (== gEgoEdgeHit 2) 1 else 0)
					setCycle: End self
				)
				(= ticks 12)
			)
			(7
				(= local17 1)
				(glassSlipper
					signal: 26640
					cel: 3
					posn: (marian x:) (marian y:)
					init:
				)
			)
			(8
				(monk
					view: 16
					setLoop: (if (== gEgoEdgeHit 2) 5 else 4)
					setCel: 0
				)
				(= ticks 48)
			)
			(9
				(Converse 1 @local59 11 0 self) ; "Foolish outlaw! Had you fired your deadly longbow, you and the Lady might still be alive."
			)
			(10
				(EgoDead)
			)
		)
	)
)

(instance hornToot of Sound
	(properties)
)

(instance menGather of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LoadMany rsSCRIPT 19 23 20 22)
				(LoadMany rsSOUND 904)
				(= local0 320)
				(= local4 -10)
				(= local8 320)
				(= local12 -10)
				(if (== gEgoEdgeHit 2)
					(= local1 125)
					(= local5 180)
					(= local9 160)
					(= local13 148)
					(= local2 298)
					(= local3 127)
					(= local6 115)
					(= local7 150)
					(= local10 250)
					(= local11 160)
					(= local14 168)
					(= local15 112)
				else
					(= local1 140)
					(= local5 180)
					(= local9 125)
					(= local13 120)
					(= local2 122)
					(= local3 110)
					(= local6 44)
					(= local7 175)
					(= local10 196)
					(= local11 127)
					(= local14 33)
					(= local15 133)
				)
				(gEgo
					actions: marianHornBlow
					setMotion: PolyPath 160 165 self
				)
			)
			(1
				(if
					(or
						(== (gEgo loop:) 2)
						(== (gEgo loop:) 4)
						(== (gEgo loop:) 0)
						(== (gEgo loop:) 6)
					)
					(gEgo setLoop: 0)
				else
					(gEgo setLoop: 1)
				)
				(gEgo view: 10 setCel: 0 setCycle: End self)
			)
			(2
				(hornToot number: 904 loop: 1 init: play:)
				(= seconds 5)
			)
			(3
				(hornToot dispose:)
				(= ticks 30)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo)
				((ScriptID 22) posn: local0 local1 init: setCycle: StopWalk 164) ; Much
				((ScriptID 23) posn: local4 local5 init: setCycle: StopWalk 155) ; Tuck
				(if (== gEgoEdgeHit 2)
					((ScriptID 23) setMotion: PolyPath local6 local7 self) ; Tuck
					((ScriptID 22) setMotion: PolyPath local2 local3) ; Much
				else
					((ScriptID 22) setMotion: PolyPath local2 local3 self) ; Much
					((ScriptID 23) setMotion: PolyPath local6 local7) ; Tuck
				)
			)
			(6
				((ScriptID 22) stopUpd:) ; Much
				((ScriptID 23) stopUpd:) ; Tuck
				(gEgo setMotion: PolyPath (gEgo x:) (- (gEgo y:) 1))
				((ScriptID 20) posn: local8 local9 init: setCycle: StopWalk 161) ; Will
				((ScriptID 19) ; John
					posn: local12 local13
					init:
					setCycle: StopWalk 152
				)
				(if (== gEgoEdgeHit 2)
					((ScriptID 19) setMotion: PolyPath local14 local15 self) ; John
					((ScriptID 20) setMotion: PolyPath local10 local11) ; Will
				else
					((ScriptID 20) setMotion: PolyPath local10 local11 self) ; Will
					((ScriptID 19) setMotion: PolyPath local14 local15) ; John
				)
			)
			(7
				(if (== gEgoEdgeHit 2)
					((ScriptID 20) ; Will
						setMotion:
							PolyPath
							((ScriptID 20) x:) ; Will
							(- ((ScriptID 20) y:) 1) ; Will
					)
					(gEgo setMotion: PolyPath 200 150 self)
				else
					(self cue:)
				)
			)
			(8
				((ScriptID 20) stopUpd:) ; Will
				((ScriptID 19) stopUpd:) ; John
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 1) self
				)
			)
			(9
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init:
								(+ ((ScriptID 22) x:) 30) ; Much
								((ScriptID 22) y:) ; Much
								(+ ((ScriptID 22) x:) 21) ; Much
								(+ ((ScriptID 22) y:) 7) ; Much
								(- ((ScriptID 22) x:) 21) ; Much
								(+ ((ScriptID 22) y:) 7) ; Much
								(- ((ScriptID 22) x:) 30) ; Much
								((ScriptID 22) y:) ; Much
								(- ((ScriptID 22) x:) 21) ; Much
								(- ((ScriptID 22) y:) 9) ; Much
								(+ ((ScriptID 22) x:) 21) ; Much
								(- ((ScriptID 22) y:) 9) ; Much
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init:
								(+ ((ScriptID 23) x:) 30) ; Tuck
								((ScriptID 23) y:) ; Tuck
								(+ ((ScriptID 23) x:) 21) ; Tuck
								(+ ((ScriptID 23) y:) 7) ; Tuck
								(- ((ScriptID 23) x:) 21) ; Tuck
								(+ ((ScriptID 23) y:) 7) ; Tuck
								(- ((ScriptID 23) x:) 30) ; Tuck
								((ScriptID 23) y:) ; Tuck
								(- ((ScriptID 23) x:) 21) ; Tuck
								(- ((ScriptID 23) y:) 9) ; Tuck
								(+ ((ScriptID 23) x:) 21) ; Tuck
								(- ((ScriptID 23) y:) 9) ; Tuck
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init:
								(+ ((ScriptID 20) x:) 32) ; Will
								((ScriptID 20) y:) ; Will
								(+ ((ScriptID 20) x:) 23) ; Will
								(+ ((ScriptID 20) y:) 7) ; Will
								(- ((ScriptID 20) x:) 28) ; Will
								(+ ((ScriptID 20) y:) 7) ; Will
								(- ((ScriptID 20) x:) 32) ; Will
								((ScriptID 20) y:) ; Will
								(- ((ScriptID 20) x:) 28) ; Will
								(- ((ScriptID 20) y:) 9) ; Will
								(+ ((ScriptID 20) x:) 23) ; Will
								(- ((ScriptID 20) y:) 9) ; Will
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init:
								(+ ((ScriptID 19) x:) 26) ; John
								((ScriptID 19) y:) ; John
								(+ ((ScriptID 19) x:) 20) ; John
								(+ ((ScriptID 19) y:) 7) ; John
								(- ((ScriptID 19) x:) 23) ; John
								(+ ((ScriptID 19) y:) 7) ; John
								(- ((ScriptID 19) x:) 32) ; John
								((ScriptID 19) y:) ; John
								(- ((ScriptID 19) x:) 23) ; John
								(- ((ScriptID 19) y:) 9) ; John
								(+ ((ScriptID 19) x:) 20) ; John
								(- ((ScriptID 19) y:) 9) ; John
							yourself:
						)
				)
				(if (== gEgoEdgeHit 2)
					(= seconds 4)
				else
					(= ticks 12)
				)
			)
			(10
				(Converse 4 @local68 2 0 13 1 15 2 14 3 self) ; "Master, what's happened here? I see a Monk adorned with your fletching."
				((ScriptID 19) actions: johnAct) ; John
				((ScriptID 23) actions: tuckAct) ; Tuck
				((ScriptID 20) actions: willAct) ; Will
				((ScriptID 22) actions: muchAct) ; Much
			)
			(11
				(HandsOn)
				((ScriptID 220 0) setScript: beatItTimerScript) ; forest
				(self dispose:)
			)
		)
	)
)

(instance getGoing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 1 @local80 15 0 self) ; "No need to wait on us, Robin. We can do this without troubling you."
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance beatItTimerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 15)
			)
			(1
				(if (not (gEgo script:))
					((ScriptID 220 0) setScript: getGoing) ; forest
				else
					((ScriptID 220 0) setScript: beatItTimerScript) ; forest
				)
			)
		)
	)
)

(instance heartSick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1226 42 self) ; "I have not the heart to call my men now."
			)
			(1
				(Say 1226 43 self) ; "It will be hard enough to tell them tonight how I failed so miserably."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dummyMonk of PicView
	(properties)

	(method (init)
		(self
			view: (monk view:)
			loop: (monk loop:)
			cel: (monk cel:)
			x: (monk x:)
			y: (monk y:)
			z: (monk z:)
			signal: 16449
			priority: (monk priority:)
		)
		(super init:)
	)
)

(instance dummyMarian of PicView
	(properties)

	(method (init)
		(self
			view: (marian view:)
			loop: (marian loop:)
			cel: (marian cel:)
			x: (marian x:)
			y: (marian y:)
			z: (marian z:)
			signal: (marian signal:)
			priority: (marian priority:)
		)
		(super init:)
	)
)

(instance dummySlip of PicView
	(properties)

	(method (init)
		(self
			view: (glassSlipper view:)
			loop: (glassSlipper loop:)
			cel: (glassSlipper cel:)
			x: (glassSlipper x:)
			y: (glassSlipper y:)
			signal: (glassSlipper signal:)
			priority: (glassSlipper priority:)
		)
		(super init:)
	)
)

(instance dummyStick of PicView
	(properties)

	(method (init)
		(self
			view: (stick view:)
			loop: (stick loop:)
			cel: (stick cel:)
			x: (stick x:)
			y: (stick y:)
			signal: (stick signal:)
			priority: (stick priority:)
		)
		(super init:)
	)
)

(instance johnPic of PicView
	(properties)

	(method (init)
		(self
			view: ((ScriptID 19) view:) ; John
			loop: ((ScriptID 19) loop:) ; John
			cel: ((ScriptID 19) cel:) ; John
			x: ((ScriptID 19) x:) ; John
			y: ((ScriptID 19) y:) ; John
			signal: ((ScriptID 19) signal:) ; John
		)
		(super init:)
	)
)

(instance tuckPic of PicView
	(properties)

	(method (init)
		(self
			view: ((ScriptID 23) view:) ; Tuck
			loop: ((ScriptID 23) loop:) ; Tuck
			cel: ((ScriptID 23) cel:) ; Tuck
			x: ((ScriptID 23) x:) ; Tuck
			y: ((ScriptID 23) y:) ; Tuck
			signal: ((ScriptID 23) signal:) ; Tuck
		)
		(super init:)
	)
)

(instance willPic of PicView
	(properties)

	(method (init)
		(self
			view: ((ScriptID 20) view:) ; Will
			loop: ((ScriptID 20) loop:) ; Will
			cel: ((ScriptID 20) cel:) ; Will
			x: ((ScriptID 20) x:) ; Will
			y: ((ScriptID 20) y:) ; Will
			signal: ((ScriptID 20) signal:) ; Will
		)
		(super init:)
	)
)

(instance muchPic of PicView
	(properties)

	(method (init)
		(self
			view: ((ScriptID 22) view:) ; Much
			loop: ((ScriptID 22) loop:) ; Much
			cel: ((ScriptID 22) cel:) ; Much
			x: ((ScriptID 22) x:) ; Much
			y: ((ScriptID 22) y:) ; Much
			signal: ((ScriptID 22) signal:) ; Much
		)
		(super init:)
	)
)

(instance randomHorse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSFX number: 913 loop: 1)
				(= ticks 6)
			)
			(1
				(gSFX play:)
				(= ticks (Random 300 600))
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance marianHornBlow of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(== invItem 1) ; horn
				(cond
					((gCast contains: (ScriptID 19)) ; John
						(Say 1226 49 1) ; "I've no need to call for my men. They're here."
						1
					)
					((== local16 1)
						(gEgo setScript: menGather)
						1
					)
					((and (gCast contains: monk) (not (IsFlag 5)))
						(Say 1226 48 1) ; "I've no time to wait for my men"
						1
					)
					(else
						(gEgo setScript: heartSick)
						1
					)
				)
			)
		)
	)
)

(instance johnAct of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 5) ; Talk
				(Converse 1 @local84 13 0 0) ; "No need to wait for us, Robin. We'll take care of this."
				1
			)
		)
	)
)

(instance tuckAct of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 5) ; Talk
				(Converse 1 @local88 15 0 0) ; "I'll say a few words over him, though I fear his doom is already set."
				1
			)
		)
	)
)

(instance willAct of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 5) ; Talk
				(Converse 1 @local92 14 0 0) ; "We'll bury him and see you in camp tonight."
				1
			)
		)
	)
)

(instance muchAct of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 5) ; Talk
				(Converse 1 @local96 17 0 0) ; "I'll stay and help bury him."
				1
			)
		)
	)
)

(instance dumpMarian of Code
	(properties)

	(method (doit)
		(mariansSong stop: dispose:)
		(monk setScript: 0)
		(if local16
			(AddToAddToPics dummyMonk dummyStick)
			(monk delete: dispose:)
			(stick delete: dispose:)
		)
		(if (gCast contains: monk)
			(AddToAddToPics dummyMonk)
			(monk delete: dispose:)
		)
		(if (gCast contains: marian)
			(AddToAddToPics dummyMarian)
		)
		(if local17
			(AddToAddToPics dummySlip)
			(glassSlipper delete: dispose:)
		)
		(if (gCast contains: (ScriptID 19)) ; John
			(AddToAddToPics johnPic tuckPic willPic muchPic)
			((ScriptID 19) setCycle: 0 delete: dispose:) ; John
			((ScriptID 23) setCycle: 0 delete: dispose:) ; Tuck
			((ScriptID 20) setCycle: 0 delete: dispose:) ; Will
			((ScriptID 22) setCycle: 0 delete: dispose:) ; Much
		)
		(LoadMany 0 19 23 20 22 851 928 227)
		(gEgo actions: 0)
	)
)

(instance mariansSong of Sound
	(properties
		flags 1
		number 218
		loop -1
	)
)

(instance dieSound of Sound
	(properties
		flags 1
		number 588
	)
)

