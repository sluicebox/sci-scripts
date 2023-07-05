;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use n026)
(use JumpX)
(use Feature)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	local0
	local1
	local2 = 72
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
	local17 = 2
	local18
	local19
	local20
	local21
	local22
	local23
)

(procedure (localproc_0 param1 param2)
	(switch global209
		(1
			((Timer new:) setReal: param1 (* param2 10))
		)
		(2
			((Timer new:) setReal: param1 (* param2 7))
		)
		(3
			((Timer new:) setReal: param1 (* param2 4))
		)
	)
)

(procedure (localproc_1)
	(DrawPic (gCurRoom picture:) 9)
	(Animate (gCast elements:) 0)
)

(class Fcycler of Cycle
	(properties
		head 0
		tail 10
	)

	(method (init param1 param2 param3)
		(super init: param1)
		(self head: param2)
		(if (> param3 (client lastCel:))
			(self tail: (client lastCel:))
		else
			(self tail: param3)
		)
	)

	(method (doit &tmp temp0)
		(if (> (= temp0 (self nextCel:)) (self tail:))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(client cel: head)
	)
)

(class Sspell of Actor
	(properties
		yStep 10
		view 21
		priority 15
		signal 16
		cycleSpeed 0
		xStep 12
		moveSpeed 0
		tim 0
	)

	(method (init param1)
		(super init: &rest)
		(self
			x: (gEgo x:)
			y: (- (gEgo y:) 40)
			setLoop: param1
			setCycle: Fwd
			setMotion: MoveTo local15 local16 self
		)
		(if (== param1 4)
			(self scaleX: 88 scaleY: 88 origStep: 6672)
		)
		(gLongSong2
			number:
				(switch param1
					(0 943)
					(2 13)
					(else 11)
				)
			play:
			setLoop: 1
		)
	)

	(method (cue)
		(if tim
			(= tim 0)
			(self dispose:)
		else
			(if (== loop 4)
				(= loop 10)
			else
				(= loop 9)
			)
			(= tim 1)
			(gLongSong2 number: 930 play: setLoop: 1)
			(self setCycle: End self)
		)
	)
)

(class Fspell of Actor
	(properties
		yStep 6
		view 21
		priority 15
		signal 16
		cycleSpeed 0
		xStep 8
		moveSpeed 0
		rx 0
		ry 0
		qvalue 0
	)

	(method (init)
		(= x (gEgo x:))
		(= y (- (gEgo y:) 30))
		(super init: &rest)
		(self
			rx: (gEgo x:)
			ry: (- (gEgo y:) 30)
			setLoop: 7
			setCycle: Fwd
			setMotion: JumpX local15 local16 15 self
		)
		(gLongSong2 number: 900 play: setLoop: 1)
	)

	(method (cue)
		(if qvalue
			(self dispose:)
		else
			(= qvalue 1)
			(if local22
				(gMessager say: 5 6 35) ; "You cannot Fetch something which is held."
				(= local22 0)
			)
			(self
				setPri: (- (gEgo priority:) 1)
				setMotion: MoveTo rx ry self
			)
			(gLongSong2 number: 900 play: setLoop: 1)
		)
	)
)

(instance rm650 of Rm
	(properties
		noun 7
		picture 650
		vanishingY -180
	)

	(method (init)
		((ScriptID 36 0) x: 200 y: 2 textX: -175 textY: 150) ; johariTalker
		((ScriptID 43 0) x: 200 y: 2 textX: -175 textY: 150) ; shamanTalker
		(LoadMany rsVIEW 653 654 14)
		(if (== gPrevRoomNum 550) ; combatRm
			(gEgo
				view: 5
				init:
				setScale: 0
				setLoop: 7
				solvePuzzle: 314 5 2
				addHonor: 20
			)
			(SetFlag 165)
			(judge init:)
			(super init: &rest)
			(SetFlag 79)
			(switch global155
				(0
					(gEgo view: 43 cel: 0 loop: 1)
					(sHaman view: 656 loop: 0 x: 102 cel: 9 init:)
					(self setScript: toDead)
				)
				(else
					(gEgo view: 5 init: setScale: 0 setLoop: 7)
					(sHaman view: 656 loop: 0 x: 102 cel: 9 init:)
					(gCurRoom setScript: leave)
				)
			)
		else
			(gEgo
				view: 5
				loop: 6
				cel: 0
				x: 110
				y: 151
				init:
				get: 44 ; theWood
				setScale: 0
			)
			(judge init: stopUpd:)
			(judgeplat init:)
			(mainplatform init:)
			(sHaman init:)
			(juggleLight init: setScale: 0 stopUpd: hide:)
			(fire init: stopUpd: hide:)
			(cage init: stopUpd: hide:)
			(burst init: stopUpd:)
			(spell init: stopUpd:)
			(HandsOff)
			(SetFlag 69)
			(super init: &rest)
			(self setScript: sayMessage)
		)
	)

	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 217 219 5)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (and (> 88 theVerb 74) (== local1 8)) ; lightningBallSpell, Sleep
			(gMessager say: 5 6 12) ; "You'd better put out your staff before trying any other spells."
		else
			(switch theVerb
				(82 ; fetchSpell
					(if (gEgo castSpell: 26 local10)
						(= local15 ((gUser curEvent:) x:))
						(= local16 ((gUser curEvent:) y:))
						(if (& local0 $0080)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0080)
							(gEgo setScript: castPersonalSpell 0 1)
							((Fspell new:) init:)
						)
					)
				)
				(78 ; dazzleSpell
					(if (gEgo castSpell: 22 local10)
						(if (& local0 $0008)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0008)
							(if (& local1 $0200)
								(= local17 3)
								(turnFacing dispose:)
								(= local8 1)
								(sHaman setScript: buffScript 0 34)
								(judge setScript: reactDazz combat)
							else
								(= local8 1)
								(sHaman setScript: reactDazz)
							)
							(gEgo setScript: castPersonalSpell 0 0)
							(gLongSong2 number: 900 play: setLoop: 1)
						)
					)
				)
				(85 ; reversalSpell
					(if (gEgo castSpell: 29 local10)
						(if (& local0 $0400)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(= local4 1)
							(|= local0 $0400)
							(= local8 1)
							(gEgo setScript: castPersonalSpell 0 0)
							(gLongSong2 number: 944 play: setLoop: 1)
							(switch local1
								(0
									(sHaman setScript: buffScript 0 13)
								)
								(1
									(if local3
										(sHaman setScript: buffScript 0 13)
									else
										(sHaman setScript: buffScript 0 4)
									)
								)
								(4
									(sHaman setScript: buffScript 0 10)
									(gEgo solvePuzzle: 309 4 2)
								)
								(else
									(sHaman setScript: buffScript 0 30583)
								)
							)
						)
					)
				)
				(80 ; calmSpell
					(if (gEgo castSpell: 24 local10)
						(if (& local0 $0020)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0020)
							(switch local1
								(64
									(= temp0 0)
									(judge setScript: noFire 0 0)
									(sHaman setScript: buffScript 0 23)
									(gEgo solvePuzzle: 307 4 2)
								)
								(8
									(= temp0 0)
									(judge setScript: noFire 0 0)
									(sHaman setScript: buffScript 0 4)
								)
								(else
									(= temp0 1)
								)
							)
							(gEgo setScript: castPersonalSpell 0 temp0)
							(gLongSong2 number: 942 play: setLoop: 1)
						)
					)
				)
				(84 ; levitateSpell
					(if (gEgo castSpell: 28 local10)
						(if (& local0 $0200)
							(gCurRoom setScript: disQualify 0 (++ local7))
						else
							(|= local0 $0200)
							(switch local1
								(64
									(= temp0 0)
									(judge setScript: noFire 0 1)
									(gEgo setPri: 11)
									(sHaman setScript: buffScript 0 36)
								)
								(1024
									(= temp0 0)
									(= local8 1)
									(sHaman setScript: buffScript 0 40)
									(gEgo solvePuzzle: 312 4 2)
								)
								(else
									(= temp0 1)
								)
							)
							(if local10
								(gEgo setScript: summonLeviSpell 0 temp0)
							else
								(gEgo setScript: castLeviSpell 0 temp0)
							)
							(gLongSong2 number: 281 setLoop: 1 play:)
						)
					)
				)
				(86 ; jugglingLightsSpell
					(if (gEgo castSpell: 30 local10)
						(if (& local0 $0800)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0800)
							(= local8 1)
							(switch local1
								(256
									(if (IsObject ((gCurRoom script:) timer:))
										(((gCurRoom script:) timer:) dispose:)
									)
									(fire setScript: waitLight 0 31)
									(juggleLight setScript: lightUp 0 1)
									(gEgo solvePuzzle: 308 4 2)
								)
								(else
									(juggleLight setScript: lightUp 0 0)
									(gEgo setScript: castJuggleLight 0 1)
								)
							)
						)
					)
				)
				(77 ; triggerSpell
					(if (gEgo castSpell: 21 local10)
						(if (& local0 $0004)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0004)
							(= local8 1)
							(if local13
								(self setScript: exPlode)
							else
								(gEgo setScript: castPersonalSpell 0 1)
								(gLongSong2 number: 900 play: setLoop: 1)
							)
						)
					)
				)
				(87 ; summonStaffSpell
					(cond
						(local23
							(gMessager say: 13 6 37) ; "You don't have time to summon your staff now."
						)
						((gEgo castSpell: 31 local10)
							(if (& local0 $1000)
								(gCurRoom setScript: disQualify 0 2)
							else
								(= local8 1)
								(|= local0 $1000)
								(gEgo
									setScript: castGetSummonSpell 0 0
									solvePuzzle: 306 4 2
								)
								(gLongSong2 number: 900 play: setLoop: 1)
								(switch local1
									(0
										(sHaman setScript: buffScript 0 17)
									)
									(1
										(if local3
											(sHaman setScript: buffScript 0 17)
										else
											(sHaman setScript: buffScript 0 4)
										)
									)
									(2
										(sHaman setScript: buffScript 0 10)
									)
									(else
										(sHaman setScript: buffScript 0 30583)
									)
								)
							)
						)
					)
				)
				(75 ; openSpell
					(if (gEgo castSpell: 19 local10)
						(if (& local0 $0001)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0001)
							(= local8 1)
							(gEgo setScript: castPersonalSpell 0 1)
							(gLongSong2 number: 900 play: setLoop: 1)
						)
					)
				)
				(76 ; detectMagicSpell
					(if (gEgo castSpell: 20 local10)
						(if (& local0 $0002)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0002)
							(gEgo setScript: castDectMagic)
							(gLongSong2 number: 900 play: setLoop: 1)
							(switch local1
								(0
									(sHaman setScript: buffScript 0 1)
								)
								(1
									(sHaman setScript: buffScript 0 4)
								)
								(else
									(sHaman setScript: buffScript 0 30583)
								)
							)
						)
					)
				)
				(79 ; ???
					(if (gEgo castSpell: 23 local10)
						(if (& local0 $0010)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0010)
							(= local8 1)
							(gEgo setScript: castPersonalSpell 0 1)
							(gLongSong2 number: 900 play: setLoop: 1)
						)
					)
				)
				(81 ; flameDartSpell
					(if (gEgo castSpell: 25 local10)
						(= local15 ((gUser curEvent:) x:))
						(= local16 ((gUser curEvent:) y:))
						(if (& local0 $0040)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0040)
							(if (and (& local1 $0200) (not local11))
								(gEgo setScript: shootIt)
								(return 1)
							else
								(gEgo setScript: castPersonalSpell 0 1)
								((Sspell new:) init: 2)
							)
						)
					)
				)
				(83 ; forceBoltSpell
					(if (gEgo castSpell: 27 local10)
						(= local15 ((gUser curEvent:) x:))
						(= local16 ((gUser curEvent:) y:))
						(if (& local0 $0100)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $0100)
							(if (and (& local1 $0200) (not local11))
								(gEgo setScript: shootIt)
								(return 1)
							else
								(gEgo setScript: castPersonalSpell 0 1)
								((Sspell new:) init: 0)
							)
						)
					)
				)
				(88 ; lightningBallSpell
					(if (gEgo castSpell: 32 local10)
						(= local15 ((gUser curEvent:) x:))
						(= local16 ((gUser curEvent:) y:))
						(if (& local0 $2000)
							(gCurRoom setScript: disQualify 0 local7)
						else
							(|= local0 $2000)
							(if (and (& local1 $0200) (not local11))
								(gEgo setScript: shootIt)
								(return 1)
							else
								(gEgo setScript: castPersonalSpell 0 1)
								((Sspell new:) init: 4)
							)
						)
					)
				)
				(33 ; theRocks
					(gEgo drop: 23 1) ; theRocks
					(super doVerb: theVerb)
				)
				(20 ; theDaggers
					(gEgo drop: 10 1) ; theDaggers
				)
				(16 ; theGrapnel
					(gEgo drop: 6 1) ; theGrapnel
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(LoadMany 0 36 43 44 57)
		(UnLoad 128 653)
		(UnLoad 128 654)
		(UnLoad 128 14)
		(gTimers eachElementDo: #dispose eachElementDo: #delete release:)
		(super dispose:)
	)
)

(instance exPlode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local10
					(gEgo
						x:
							(if (!= (gEgo view:) 18)
								(+ (gEgo x:) 12)
							else
								(gEgo x:)
							)
						y:
							(if (!= (gEgo view:) 18)
								(+ (gEgo y:) 1)
							else
								(gEgo y:)
							)
						view: 18
						setLoop: local17
						cel: 0
						setCycle: Beg self
					)
				else
					(gEgo view: 14 loop: local17 setCycle: Beg self)
				)
				(gLongSong2 number: 900 setLoop: 1 play:)
			)
			(1
				(Palette palSET_INTENSITY 0 255 800)
				(gLongSong2 number: 930 play: setLoop: 1)
				(= cycles 5)
			)
			(2
				(gCast eachElementDo: #hide)
				(= seconds 2)
			)
			(3
				(EgoDead 34) ; "As both staffs flare into mini-novas, you are in need of some nova-caine."
			)
		)
	)
)

(instance buffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(cond
					(local3
						(= local3 0)
						(if (== register 30583)
							(localproc_0 combat 1)
						else
							(combat changeState: register)
						)
					)
					((== register 30583)
						(combat cue:)
					)
					(else
						(combat changeState: register)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance waitLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(combat changeState: register)
				(self dispose:)
			)
		)
	)
)

(instance noFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
			)
			(1
				(fire setLoop: 0 setCycle: CT 0 -1 self)
				(cage setLoop: 2 setCycle: CT 0 -1 self)
			)
			(2 0)
			(3
				(cage hide: setPri: -1)
				(fire hide: setPri: -1)
				(= cycles 5)
			)
			(4
				(if register
					0
				else
					(self cue:)
				)
			)
			(5
				(gMessager say: 3 6 9 0 self) ; "The outsider has successfully countered the Shaman's Wall of Flames spell. The outsider is ahead."
			)
			(6
				(if (sHaman script:)
					(sHaman cue:)
				)
				(++ local5)
				(self dispose:)
			)
		)
	)
)

(instance shootIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 14 setLoop: 3 setCycle: End self)
				(cage
					view: 651
					x: (gEgo x:)
					y: (- (gEgo y:) 50)
					setLoop: 0
					origStep: 6671
					moveSpeed: 0
					cycleSpeed: 0
					setCycle: Fwd
					setStep: 15 10
				)
				(gLongSong2 number: 13 play: setLoop: 1)
			)
			(1
				(cage show: setMotion: MoveTo local15 local16 self)
			)
			(2
				(gEgo cel: 0)
				(cage setCycle: 0 hide:)
				(burst x: local15 y: local16 show: setCycle: End self)
			)
			(3
				(gLongSong2 number: 930 play: setLoop: 1)
				(if
					(and
						(>= local15 (- (juggleLight x:) 10))
						(<= local15 (+ (juggleLight x:) 10))
						(>= local16 (- (juggleLight y:) 18))
						(<= local16 (+ (juggleLight y:) 18))
					)
					(juggleLight dispose:)
					(turnFacing dispose:)
					(gEgo solvePuzzle: 311 4 2)
					(= register 1)
				else
					(self dispose:)
				)
				(burst hide:)
				(= cycles 5)
			)
			(4
				(combat changeState: 35)
				(burst hide:)
				(self dispose:)
			)
		)
	)
)

(instance castJuggleLight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject ((gCurRoom script:) timer:))
					(((gCurRoom script:) timer:) dispose:)
				)
				(if local10
					(gEgo
						view: 19
						setLoop: local17
						cel: 0
						setCycle: CT 2 1 self
					)
				else
					(gEgo view: 15 loop: local17 setCycle: CT 4 1 self)
				)
			)
			(1
				(juggleLight
					view: 111
					loop: 0
					cel: 0
					x: (gEgo x:)
					y: (gEgo nsTop:)
					priority: (+ (gEgo priority:) 1)
					signal: 16
					show:
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(2
				(if local10
					(gEgo view: 18 setLoop: local17 cel: 0)
				else
					(gEgo cel: 0)
				)
				(juggleLight hide:)
				(if (juggleLight script:)
					(= cycles 70)
				else
					(self cue:)
				)
			)
			(3
				(HandsOn 5 1 3 8 7)
				(= cycles 5)
			)
			(4
				(if (and (sHaman script:) local8)
					(= local8 0)
					(sHaman cue:)
				)
				(if (judge script:)
					(judge cue:)
				)
				(if register
					(cond
						(local3
							(= local3 0)
							(localproc_0 combat 1)
						)
						((& local1 $1000) 0)
						(else
							(combat cue:)
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance castPersonalSpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject ((gCurRoom script:) timer:))
					(((gCurRoom script:) timer:) dispose:)
				)
				(if local10
					(gEgo
						x:
							(if (!= (gEgo view:) 18)
								(- (gEgo x:) 5)
							else
								(gEgo x:)
							)
						y:
							(if (!= (gEgo view:) 18)
								(- (gEgo y:) 2)
							else
								(gEgo y:)
							)
						view: 18
						setLoop: local17
						cel: 0
						setCycle: Beg self
					)
				else
					(gEgo view: 14 loop: local17 setCycle: Beg self)
				)
			)
			(1
				(if (juggleLight script:)
					(= cycles 70)
				else
					(self cue:)
				)
			)
			(2
				(HandsOn 5 1 3 8 7)
				(= cycles 5)
			)
			(3
				(if (and (sHaman script:) local8)
					(= local8 0)
					(sHaman cue:)
				)
				(if (judge script:)
					(judge cue:)
				)
				(if register
					(cond
						(local3
							(= local3 0)
							(localproc_0 combat 1)
						)
						((& local1 $1000) 0)
						(else
							(combat cue:)
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance summonLeviSpell of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (IsObject local21) (& local1 $fdff))
			(local21 y: (gEgo y:))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject ((gCurRoom script:) timer:))
					(((gCurRoom script:) timer:) dispose:)
				)
				(gEgo view: 19 setLoop: local17 setCycle: CT 2 1 self)
			)
			(1
				((= local21 (Actor new:))
					view: 17
					loop: 4
					cel: 0
					x: (gEgo x:)
					y: (gEgo y:)
					priority: (gEgo priority:)
					signal: 16400
					init:
					setCycle: Fwd
				)
				(= cycles 3)
			)
			(2
				(gEgo
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) local2) self
				)
			)
			(3
				(if (judge script:)
					(judge cue:)
				)
				(if (& local1 $0400)
					(self cue:)
				else
					(gEgo
						setMotion:
							MoveTo
							(gEgo x:)
							(+ (gEgo y:) local2)
							self
					)
				)
			)
			(4
				(gEgo view: 18 cel: 0 loop: local17)
				(if (IsObject local21)
					(local21 dispose:)
				)
				(if (and (sHaman script:) local8)
					(= local8 0)
					(sHaman cue:)
				)
				(if (judge script:)
					(judge cue:)
				)
				(if register
					(if local3
						(= local3 0)
						(localproc_0 combat 1)
					else
						(combat cue:)
					)
				)
				(gEgo setPri: -1)
				(self dispose:)
			)
		)
	)
)

(instance castLeviSpell of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (IsObject local21) (& local1 $fdff))
			(local21 y: (gEgo y:))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject ((gCurRoom script:) timer:))
					(((gCurRoom script:) timer:) dispose:)
				)
				(gEgo
					view: 17
					setLoop: local17
					cel: 0
					cycleSpeed: 10
					setStep: 5 3
					setCycle: End self
				)
			)
			(1
				((= local21 (Actor new:))
					view: 17
					loop: 4
					cel: 0
					x: (gEgo x:)
					y: (gEgo y:)
					priority: (gEgo priority:)
					signal: 16400
					init:
					setCycle: Fwd
				)
				(= cycles 3)
			)
			(2
				(gEgo
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) local2) self
				)
			)
			(3
				(if (judge script:)
					(judge cue:)
				)
				(if (& local1 $0400)
					(cage hide:)
					(gEgo
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 1) self
					)
				else
					(gEgo
						setMotion:
							MoveTo
							(gEgo x:)
							(+ (gEgo y:) local2)
							self
					)
				)
			)
			(4
				(if (IsObject local21)
					(local21 dispose:)
				)
				(gEgo setCycle: CT 0 -1 self)
			)
			(5
				(if (judge script:)
					(judge cue:)
				)
				(if (and (sHaman script:) local8)
					(= local8 0)
					(sHaman cue:)
				)
				(if register
					(if local3
						(= local3 0)
						(localproc_0 combat 1)
					else
						(combat cue:)
					)
				)
				(gEgo setPri: -1 cycleSpeed: 6)
				(self dispose:)
			)
		)
	)
)

(instance castGetSummonSpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject ((gCurRoom script:) timer:))
					(((gCurRoom script:) timer:) dispose:)
				)
				(gEgo view: 20 x: 123 setLoop: 4 setCycle: End self)
			)
			(1
				(gEgo x: 116 setLoop: 6 setCycle: End self)
			)
			(2
				(if (and (sHaman script:) local8)
					(= local8 0)
					(sHaman cue:)
				)
				(+= local7 3)
				(if register
					(if local3
						(= local3 0)
						(localproc_0 combat 1)
					else
						(combat cue:)
					)
				)
				(= local10 1)
				(= local20 12)
				(self dispose:)
			)
		)
	)
)

(instance castSummonSpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsObject ((gCurRoom script:) timer:))
					(((gCurRoom script:) timer:) dispose:)
				)
				(gEgo view: 19 loop: 2 setCycle: Beg self)
			)
			(1
				(if (and (sHaman script:) local8)
					(= local8 0)
					(sHaman cue:)
				)
				(if register
					(if local3
						(= local3 0)
						(localproc_0 combat 1)
					else
						(combat cue:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance castDectMagic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: castPersonalSpell self 0)
			)
			(1
				(gMessager say: 5 6 6 0 self) ; "Once your head stops ringing, you think to yourself, Self, there's probably something here that isn't magical. But if there is, you're not having any luck finding it among the auras of all the things that are magical."
			)
			(2
				(if (sHaman script:)
					(sHaman cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance lightUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(juggleLight
					view: 111
					x: (gEgo x:)
					y: (gEgo nsTop:)
					show:
					setLoop: 0
					setPri: (- (gEgo priority:) 1)
					setCycle: Fwd
				)
				(if register
					(gEgo show:)
					(sHaman show:)
					(judge show: stopUpd:)
					(PalVary pvREVERSE 4)
					(= seconds 5)
				else
					(self cue:)
				)
			)
			(1
				(if register
					(gEgo setCycle: CT 0 -1 self)
				else
					(self cue:)
				)
			)
			(2
				(if register
					(PalVary pvINIT 650 1)
					(waitLight cue:)
				)
				(juggleLight hide:)
				(HandsOn 5 1 3 8 7)
				(self dispose:)
			)
		)
	)
)

(instance openCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local8 0)
				(self setScript: castPersonalSpell self 0)
			)
			(1
				(cage hide: setPri: -1)
				(if (IsObject local21)
					(local21 dispose:)
				)
				(localproc_1)
				(gLongSong2 number: 916 play: setLoop: 1)
				(= cycles 5)
			)
			(2
				(gMessager say: 3 6 14 0 self) ; "The outsider has successfully countered the Shaman's Cage spell. The Shaman may try again."
			)
			(3
				(gEgo solvePuzzle: 310 4 2)
				(combat changeState: 27)
				(self dispose:)
			)
		)
	)
)

(instance reactDazz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((== local1 0)
						(= local18 8)
					)
					((& local1 $0f00)
						(= local18 7)
					)
					(else
						(= local18 0)
					)
				)
			)
			(1
				(HandsOff)
				(= cycles 5)
			)
			(2
				(Palette palSET_INTENSITY 0 255 1000)
				(Palette palSET_INTENSITY 0 255 100)
				(sHaman view: 654 loop: local18 setCycle: End self)
				(if (== local1 512)
					(juggleLight dispose:)
				)
			)
			(3
				(sHaman cel: 0)
				(if (!= (gEgo trySkill: 22 150) -1) ; dazzleSpell
					(= local3 1)
					(localproc_0 combat 2)
				else
					(localproc_0 combat 1)
				)
				(HandsOn 5 1 3 8 7)
				(self dispose:)
			)
		)
	)
)

(instance disQualify of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(self setScript: castPersonalSpell self 0)
					)
					(1
						(self setScript: castLeviSpell self 0)
					)
					(2
						(self setScript: castSummonSpell self 0)
					)
					(3
						(self setScript: castPersonalSpell self 0)
					)
					(4
						(self setScript: summonLeviSpell self 0)
					)
				)
			)
			(1
				(gMessager say: 3 6 4 0 self) ; "The outsider has just broken the rule of the duel. You must not cast the same spell more than once. The Shaman is the winner of the duel."
			)
			(2
				(gCurRoom newRoom: 600)
				(self dispose:)
			)
		)
	)
)

(instance sayMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(gMessager say: 1 6 1 0 self) ; "You must follow the rules of the duel with the Shaman."
			)
			(2
				(gMessager say: 2 6 2 0 self) ; "You do not have a chance, outsider. I am the Shaman, most powerful of all!"
			)
			(3
				(gMessager say: 3 6 3 0 self) ; "Outsider, you shall begin the contest!"
			)
			(4
				(HandsOn 5 1 3 8 7)
				(gCurRoom setScript: combat)
			)
		)
	)
)

(instance castSummonStaff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sHaman view: 653 cycleSpeed: 10 setLoop: 0 setCycle: End self)
				(gLongSong2 number: 944 play: setLoop: 1)
				(= local13 1)
			)
			(1
				(HandsOn 5 1 3 8 7)
				(self dispose:)
			)
		)
	)
)

(instance castWallFlame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not local9)
					(= local9 1)
					(fire
						x: 189
						y: 58
						show:
						setLoop: 0
						moveSpeed: 0
						setCycle: Fwd
					)
				)
				(sHaman setLoop: 2 cel: 0)
				(= cycles 30)
			)
			(1
				(sHaman setCycle: End)
				(gLongSong2 number: 913 setLoop: 1 play:)
				(fire
					view: 650
					x: 69
					y: 146
					noun: 9
					setLoop: 0
					setPri: 14
					setCycle: End self
					show:
				)
				(cage
					view: 650
					x: 68
					y: 144
					noun: 9
					setLoop: 2
					setPri: (- (gEgo priority:) 1)
					show:
					setCycle: End self
				)
			)
			(2 0)
			(3
				(fire setLoop: 1 setCycle: Fwd)
				(cage setLoop: 3 setCycle: Fwd)
				(= cycles 5)
			)
			(4
				(HandsOn 5 1 3 8 7)
				(self dispose:)
			)
		)
	)
)

(instance castFlameDart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sHaman view: 653 setLoop: 1 setCycle: CT 2 1 self)
				(fire
					view: 651
					setLoop: 0
					x: 182
					y: 60
					setStep: 10 3
					moveSpeed: 0
					show:
				)
			)
			(1
				(gLongSong2 number: 13 play: setLoop: 1)
				(fire setCycle: Fwd setMotion: MoveTo (+ (fire x:) 5) (fire y:))
				(sHaman view: 653 setLoop: 1 setCycle: CT 5 1 self)
			)
			(2
				(fire setMotion: MoveTo (gEgo x:) 101 self)
			)
			(3
				(fire hide:)
				(burst x: 118 y: 101 setCycle: End self show:)
			)
			(4
				(gLongSong2 number: 11 play: setLoop: 1)
				(fire show:)
				(burst hide:)
				(if register
					(= local9 1)
					(fire setMotion: MoveTo 189 58 self)
				else
					(gMessager say: 13 6 36 0 self) ; "Casting's a pain when the flame's on the grain!"
				)
			)
			(5
				(fire view: 340 setLoop: 0 setCycle: Fwd)
				(if register
					(sHaman setLoop: 2 cel: 0)
				)
				(= cycles 2)
			)
			(6
				(= local9 1)
				(HandsOn 5 1 3 8 7)
				(self dispose:)
			)
		)
	)
)

(instance castCage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sHaman view: 653 setLoop: 2 setCycle: Beg self)
			)
			(1
				(gLongSong2 number: 7 play: setLoop: 1)
				(cage
					view: 651
					setLoop: 1
					show:
					x: (+ 112 local20)
					y: 78
					noun: 10
					setPri: 13
					setCycle: End self
				)
				((= local21 (Prop new:))
					view: 651
					loop: 4
					cel: 0
					x: (+ 113 local20)
					y: 48
					z: -30
					noun: 10
					signal: 16384
					init:
					setCycle: End self
				)
			)
			(2 0)
			(3
				(HandsOn 5 1 3 8 7)
				(self dispose:)
			)
		)
	)
)

(instance castSmoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sHaman view: 654 setLoop: 2 setCycle: Beg self)
				(if (PalVary pvGET_CURRENT_STEP)
					(PalVary pvREVERSE 0)
				)
			)
			(1
				(= seconds 1)
			)
			(2
				(PalVary pvINIT 651 2)
				(= seconds 3)
			)
			(3
				(gLongSong2 number: 939 play: setLoop: 1)
				(= local10 0)
				(= local17 3)
				(gEgo view: 15 setLoop: 3 cel: 2 x: 201 y: 134)
				(sHaman view: 654 setLoop: 4 x: 102 y: 122)
				(gCast eachElementDo: #hide)
				(= cycles 5)
			)
			(4
				(= local12 1)
				(= local13 0)
				(= local23 1)
				(gMessager say: 5 6 27 0 self) ; "You find yourself surrounded by darkness."
			)
			(5
				(HandsOn 5 1 3 8 7)
				(self dispose:)
			)
		)
	)
)

(instance turnFacing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(judge setLoop: 1 setCycle: CT 2 1 self)
			)
			(2
				(gMessager say: 3 6 17 0 self) ; "Ah, the outsider has a spell to break the darkness of the Shaman. He does very well. Now it is the Shaman's turn again."
				(HandsOn 5 1 3 8 7)
				(++ local5)
			)
			(3
				(HandsOff)
				(= local1 512)
				(sHaman view: 654 setLoop: 4 setCycle: End self)
			)
			(4
				(HandsOn 5 1 3 8 7)
				(juggleLight
					view: 651
					cel: 0
					x: (+ (sHaman x:) 35)
					y: (- (sHaman y:) 40)
					xStep: 20
					noun: 11
					cycleSpeed: 3
					show:
					setLoop: 2
					setCycle: Fcycler 0 6
				)
				(localproc_0 self 1)
			)
			(5
				(juggleLight setCycle: CT 10 1 self)
			)
			(6
				(juggleLight
					setCycle: 0
					moveSpeed: 0
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 30)
						self
				)
			)
			(7
				(= local11 1)
				(juggleLight
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 30) self
				)
			)
			(8
				(juggleLight cycleSpeed: 6 setCycle: Fcycler 0 6)
				(localproc_0 self 2)
			)
			(9
				(combat cue:)
				(self dispose:)
			)
		)
	)
)

(instance castPit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (& local1 $0200)
					(sHaman view: 654 setLoop: 5)
				else
					(sHaman view: 653 setLoop: 2)
				)
				(sHaman setCycle: Beg self)
			)
			(1
				(if (< (gEgo x:) 140)
					(cage
						view: 651
						loop: 3
						cel: 0
						noun: 12
						x: (- (gEgo x:) 24)
						y: (- (gEgo y:) 8)
						show:
					)
				else
					(cage
						view: 651
						loop: 3
						cel: 1
						x: (- (gEgo x:) 24)
						y: (- (gEgo y:) 5)
						noun: 12
						show:
					)
				)
				(= cycles 5)
			)
			(2
				(if local10
					(self changeState: 4)
				else
					(gEgo view: 5 setLoop: 0)
					(= cycles 10)
				)
			)
			(3
				(gEgo setLoop: 4)
				(= cycles 10)
			)
			(4
				(gEgo setLoop: 2)
				(= cycles 10)
			)
			(5
				(cage setPri: 1)
				(gEgo
					setPri: 2
					moveSpeed: 0
					yStep: 6
					setCycle: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 70) self
				)
			)
			(6
				(HandsOn 5 1 3 8 7)
				(gEgo moveSpeed: 6)
				(self dispose:)
			)
		)
	)
)

(instance finalScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global156 180)
				(gMessager say: 2 6 22 0 self) ; "You think you can defeat me with your stupid little spells, outsider? Fool! I am the master! I shall destroy you!"
			)
			(1
				(sHaman view: 656 cel: 0 setLoop: 0 setCycle: End self)
				(judge setLoop: 2 setCycle: Fwd)
				(burst cue:)
			)
			(2
				(= cycles 35)
			)
			(3
				(gMessager say: 1 6 23 0 self) ; "The Shaman has become a Demon! Kill it!"
			)
			(4
				(HandsOn 5 1 3)
				(switch global209
					(3
						(= seconds 5)
					)
					(else
						(= seconds 9)
					)
				)
			)
			(5
				(HandsOff)
				(= global365 595)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance combat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 157 setLoop: -1 play:)
				(= local1 0)
				(localproc_0 self 1)
			)
			(1
				(self setScript: castSummonStaff self)
			)
			(2
				(gMessager say: 3 6 5 0 self) ; "The Shaman has clearly outspelled the outsider."
				(++ local6)
			)
			(3
				(= local1 1)
				(localproc_0 self 1)
			)
			(4
				(sHaman setScript: castWallFlame self)
			)
			(5
				(= local1 64)
				(localproc_0 self 1)
			)
			(6
				(= local1 16)
				(if local9
					(fire dispose:)
				)
				(= cycles 1)
			)
			(7
				(= cycles 0)
				(gEgo view: 43 setLoop: 2 setCel: 0 setCycle: End self)
				(juggleLight dispose:)
			)
			(8
				(gMessager say: 3 6 7 0 self) ; "The outsider has failed to counter the Shaman's spell. The Shaman has clearly defeated the outsider."
			)
			(9
				(if (gEgo takeDamage: 25)
					(gCurRoom newRoom: 600)
				else
					(EgoDead 24) ; "The rules state you are not allowed to attack the Shaman directly. Now you know why. Next time, don't break the rules lest ye be broken."
				)
			)
			(13
				(if local3
					(= local3 0)
					(= cycles 1)
				else
					(self setScript: castSummonStaff self)
				)
			)
			(14
				(if local3
					(self cue:)
				else
					(gMessager say: 3 6 5 0 self) ; "The Shaman has clearly outspelled the outsider."
					(++ local6)
				)
			)
			(15
				(= local1 2)
				(localproc_0 self 1)
			)
			(16
				(self changeState: 4)
			)
			(10
				(self setScript: castFlameDart self 1)
			)
			(11
				(= local1 32)
				(++ local5)
				(gMessager say: 3 6 13 0 self) ; "The stranger has returned the Shaman's spell. Now the Shaman must counter his own spell. The stranger has won this round."
			)
			(12
				(self changeState: 4)
			)
			(17
				(self setScript: castSummonStaff self)
			)
			(18
				(gMessager say: 3 6 11 0 self) ; "The outsider's magical staff is more powerful than the Shaman's staff. The outsider wins this round."
			)
			(19
				(= local1 4)
				(localproc_0 self 1)
			)
			(20
				(self setScript: castFlameDart self 0)
			)
			(21
				(= local1 8)
				(localproc_0 self 1)
			)
			(22
				(self changeState: 6)
			)
			(23
				(sHaman setScript: castCage self)
			)
			(24
				(= local1 128)
				(= local2 5)
				(localproc_0 self 1)
			)
			(25
				(gMessager say: 3 6 15 0 self) ; "The outsider has failed to escape the Shaman's spell. The Shaman is the winner of the duel."
			)
			(26
				(gCurRoom newRoom: 600)
			)
			(27
				(juggleLight hide:)
				(sHaman setScript: castSmoke self)
			)
			(28
				(= local1 256)
				(localproc_0 self 1)
			)
			(29
				(HandsOff)
				(gMessager say: 3 6 16 0 self) ; "The outsider has failed to alter the darkness cast by the Shaman. The Shaman has won this duel."
			)
			(30
				(gCurRoom newRoom: 600)
			)
			(31
				(fire dispose:)
				(self setScript: turnFacing)
			)
			(32
				(gMessager say: 3 6 18 0 self) ; "The outsider failed to counter the Shaman's illusion. The Shaman is the winner of this duel."
			)
			(33
				(self changeState: 6)
			)
			(34 0)
			(35
				(= local2 72)
				(++ local5)
				(= cycles 0)
				(gMessager say: 3 6 19 0 self) ; "The outsider dispelled the Shaman's illusion. The Shaman must go again."
			)
			(36
				(self setScript: castPit self)
			)
			(37
				(= local1 1024)
				(localproc_0 self 1)
			)
			(38
				(gMessager say: 3 6 20 0 self) ; "The outsider has failed to escape the trap set by the Shaman. The Shaman is the winner of this duel."
			)
			(39
				(gCurRoom newRoom: 600)
			)
			(40
				(= local1 2048)
				(gMessager say: 3 6 21 0 self) ; "The stranger successfully countered the spell of the Shaman. The Shaman must try again."
			)
			(41
				(= local1 4096)
				(self setScript: finalScript self)
			)
			(42
				(gCurRoom setScript: doneRoom)
			)
		)
	)
)

(instance judgeKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: castPersonalSpell)
				(gLongSong2 number: 13 setLoop: 1 play:)
				(juggleLight
					view: (if (== register 20) 46 else 21)
					setLoop:
						(switch register
							(20 2)
							(81 2)
							(83 0)
							(88 4)
						)
					x: (gEgo x:)
					y: (- (gEgo y:) 35)
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 12 10
					setPri: 15
					show:
					setCycle: Fwd
					setMotion: MoveTo (judge x:) (- (judge y:) 20)
				)
				(= cycles 20)
			)
			(1
				(HandsOff)
				(spell
					view: 651
					x: 64
					y: 66
					moveSpeed: 0
					cycleSpeed: 0
					setLoop: 0
					setPri: 15
					setStep: 12 10
					setCycle: Fwd
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 30)
						self
					show:
				)
				(gLongSong2 number: 13 setLoop: 1 play:)
				(juggleLight
					setMotion: 0
					view: 21
					setLoop: 9
					setCycle: End juggleLight
				)
			)
			(2
				(spell hide:)
				(if (!= register 20)
					(burst
						x: (- (gEgo x:) 5)
						y: (- (gEgo y:) 20)
						show:
						setCycle: End self
					)
				else
					(burst dispose:)
					(= cycles 5)
				)
				(gLongSong2 number: 930 setLoop: 1 play:)
			)
			(3
				(burst dispose:)
				(= local14 5)
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance judgeShow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: castPersonalSpell)
				(gLongSong2 number: 13 setLoop: 1 play:)
				(sHaman
					view: 653
					cel: 0
					setLoop: (if local12 3 else 0)
					setCycle: End
				)
				(juggleLight
					view: (if (== register 20) 46 else 21)
					setLoop:
						(switch register
							(20 2)
							(81 2)
							(83 0)
							(88 4)
						)
					x: (gEgo x:)
					y: (- (gEgo y:) 35)
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 12 10
					setPri: 15
					show:
					setCycle: Fwd
					setMotion: MoveTo (sHaman x:) (- (sHaman y:) 30)
				)
				(= cycles 20)
			)
			(1
				(HandsOff)
				(spell
					view: 651
					x: 64
					y: 66
					moveSpeed: 0
					cycleSpeed: 0
					setLoop: 0
					setPri: 14
					setStep: 12 10
					setCycle: Fwd
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 30)
						self
					show:
				)
				(gLongSong2 number: 13 setLoop: 1 play:)
				(juggleLight
					setMotion: 0
					view: 21
					setLoop: 9
					setCycle: End juggleLight
				)
			)
			(2
				(spell hide:)
				(if (!= register 20)
					(burst
						x: (- (gEgo x:) 5)
						y: (- (gEgo y:) 20)
						show:
						setCycle: End self
					)
				else
					(burst dispose:)
					(= cycles 5)
				)
				(gLongSong2 number: 930 setLoop: 1 play:)
			)
			(3
				(burst dispose:)
				(gCurRoom setScript: egoDead)
			)
		)
	)
)

(instance egoDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 43 setLoop: 2 setCycle: End self)
			)
			(1
				(switch local14
					(1
						(EgoDead 25) ; "Of course you lost, you were out-spelled. You must not mis-spell when trying to teach a Master of (Magical) arts a lesson. You just didn't make the grade. You failed your final exam."
					)
					(5
						(EgoDead 31) ; "But the judge didn't miss. Spells don't do so well against poison darts. Next time, pick on someone your own size."
					)
					(else
						(EgoDead 24) ; "The rules state you are not allowed to attack the Shaman directly. Now you know why. Next time, don't break the rules lest ye be broken."
					)
				)
			)
		)
	)
)

(instance leave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 159 setLoop: 1 play: self)
			)
			(1
				(sHaman setCycle: CT 0 -1 self)
			)
			(2
				(sHaman
					view: 592
					loop: 0
					scaleX: 110
					scaleY: 110
					setCycle: End self
				)
			)
			(3
				(gEgo solvePuzzle: 305 10 2)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance toDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: End self)
			)
			(1
				(EgoDead 28) ; "The Shaman demon-strated that possession is nine parts of the law. The battle was brief and, in case you hadn't guessed, the judgement went against you. The Shaman may be disbarred for illegal summons, but you're now evidently corpus delicti."
			)
		)
	)
)

(instance doneRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(judge setCycle: 0)
				(spell dispose:)
				(burst dispose:)
				(= cycles 5)
			)
			(1
				(sHaman cycleSpeed: 12 setCycle: CT 0 -1 self)
			)
			(2
				(= cycles 10)
			)
			(3
				(gMessager say: 2 6 30 0 self) ; "You have freed me from the Demon I rashly summoned. I owe you my life."
			)
			(4
				(gEgo solvePuzzle: 305 10 2)
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance sHaman of Actor
	(properties
		x 198
		y 110
		noun 2
		view 653
		signal 16384
	)

	(method (doVerb theVerb &tmp [temp0 30])
		(if (and (> 88 theVerb 74) (== local1 8)) ; lightningBallSpell, Sleep
			(gMessager say: 5 6 12) ; "You'd better put out your staff before trying any other spells."
		else
			(switch theVerb
				(26 ; theDispell
					(if (& local1 $1000)
						(gEgo drop: 16 1) ; theDispell
						(gLongSong2 number: 932 play: setLoop: 1)
						(gEgo solvePuzzle: 313 8 2 addHonor: 50)
						(if (IsObject ((gCurRoom script:) timer:))
							(((gCurRoom script:) timer:) dispose:)
						)
						(finalScript dispose:)
					else
						(super doVerb: theVerb)
					)
				)
				(82 ; fetchSpell
					(= local22 1)
					(gCurRoom doVerb: theVerb)
				)
				(20 ; theDaggers
					(if (& local1 $1000)
						(-= global156 8)
						(gCurRoom doVerb: theVerb)
					else
						(gCurRoom setScript: judgeShow 0 20)
					)
				)
				(81 ; flameDartSpell
					(if (gEgo castSpell: 25 local10)
						(if (& local1 $1000)
							(-= global156 10)
							(&= local0 $ffaf)
							(gCurRoom doVerb: theVerb)
						else
							(gCurRoom setScript: judgeShow 0 81)
						)
					)
				)
				(83 ; forceBoltSpell
					(if (gEgo castSpell: 27 local10)
						(if (& local1 $1000)
							(-= global156 8)
							(&= local0 $feff)
							(gCurRoom doVerb: theVerb)
						else
							(gCurRoom setScript: judgeShow 0 83)
						)
					)
				)
				(88 ; lightningBallSpell
					(if (gEgo castSpell: 32 local10)
						(if (& local1 $1000)
							(-= global156 12)
							(&= local0 $dfff)
							(gCurRoom doVerb: theVerb)
						else
							(gCurRoom setScript: judgeShow 0 88)
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance judge of Prop
	(properties
		x 64
		y 80
		noun 8
		view 652
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; theDaggers
				(gCurRoom setScript: judgeKill 0 20)
			)
			(81 ; flameDartSpell
				(gCurRoom setScript: judgeKill 0 81)
			)
			(83 ; forceBoltSpell
				(gCurRoom setScript: judgeKill 0 83)
			)
			(88 ; lightningBallSpell
				(gCurRoom setScript: judgeKill 0 88)
			)
			(82 ; fetchSpell
				(= local22 1)
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance juggleLight of Actor
	(properties
		x 116
		y 88
		view 21
		loop 4
		signal 16384
		xStep 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(81 ; flameDartSpell
				(gCurRoom doVerb: theVerb)
			)
			(83 ; forceBoltSpell
				(gCurRoom doVerb: theVerb)
			)
			(88 ; lightningBallSpell
				(gCurRoom doVerb: theVerb)
			)
			(20 ; theDaggers
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance fire of Actor
	(properties
		x 184
		y 59
		sightAngle 90
		view 340
		signal 16384
	)
)

(instance cage of Actor
	(properties
		x 123
		y 76
		sightAngle 90
		view 651
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(75 ; openSpell
				(gEgo castSpell: 19 local10)
				(cond
					((& local0 $0001)
						(gCurRoom setScript: disQualify 0 local7)
					)
					((& local1 $0080)
						(|= local0 $0001)
						(gEgo setScript: openCage)
						(gLongSong2 number: 900 play: setLoop: 1)
					)
					(else
						(gCurRoom doVerb: theVerb)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
			(83 ; forceBoltSpell
				(gEgo castSpell: 27 local10)
				(if (& local1 $0080)
					(gEgo setScript: openCage)
				else
					(gCurRoom doVerb: theVerb)
				)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance judgeplat of Feature
	(properties
		x 54
		y 71
		noun 4
		nsTop 59
		nsLeft 1
		nsBottom 84
		nsRight 108
	)

	(method (doVerb theVerb)
		(switch theVerb
			(82 ; fetchSpell
				(gCurRoom doVerb: theVerb)
			)
			(81 ; flameDartSpell
				(gCurRoom doVerb: theVerb)
			)
			(83 ; forceBoltSpell
				(gCurRoom doVerb: theVerb)
			)
			(88 ; lightningBallSpell
				(gCurRoom doVerb: theVerb)
			)
			(20 ; theDaggers
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mainplatform of Feature
	(properties
		x 150
		y 75
		noun 6
		nsTop 88
		nsLeft 31
		nsBottom 170
		nsRight 270
	)

	(method (doVerb theVerb)
		(switch theVerb
			(82 ; fetchSpell
				(gCurRoom doVerb: theVerb)
			)
			(81 ; flameDartSpell
				(gCurRoom doVerb: theVerb)
			)
			(83 ; forceBoltSpell
				(gCurRoom doVerb: theVerb)
			)
			(88 ; lightningBallSpell
				(gCurRoom doVerb: theVerb)
			)
			(20 ; theDaggers
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance burst of Prop
	(properties
		view 21
		loop 9
		priority 15
		signal 16400
		cycleSpeed 1
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (cue)
		(gLongSong2 number: 13 setLoop: 1 play:)
		(spell x: 64 y: 66 show: setStep: 12 10 setMotion: MoveTo 101 92 spell)
		(self hide:)
	)
)

(instance spell of Actor
	(properties
		x 184
		y 59
		view 21
		loop 9
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(self hide:)
	)

	(method (cue)
		(gLongSong2 number: 930 setLoop: 1 play:)
		(self view: 21 loop: 9 cel: 0 show: setCycle: End burst)
	)
)

