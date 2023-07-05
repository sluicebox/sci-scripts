;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 261)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	kissact3 0
)

(local
	local0
	local1
)

(instance myMusic of Sound
	(properties)
)

(instance kissact3 of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not global163)
			(LoadMany rsMESSAGE 243 287)
			(= [global377 4] 287)
			(LoadMany rsSOUND 224 229)
			(LoadMany rsVIEW 474 904)
			(= global208 16)
		)
		(Load rsFONT 4)
		(Load rsSCRIPT 985)
		(if (and (not (& gMustDos $0002)) (== [gCycleTimers 2] 1))
			(LoadMany rsFONT 41)
			(LoadMany rsMESSAGE 406)
			(LoadMany rsVIEW 642 472)
			(LoadMany rsSOUND 29 94 95 96)
			(Rudy posn: 151 113 loop: 1 init:)
			(Fifi view: 460 loop: 0 cel: 0 illegalBits: 0 posn: 121 113 init:)
		else
			(if (& gMustDos $0002)
				(= local1 1)
				(Fifi
					view: 472
					loop: 1
					illegalBits: 0
					posn: 216 118
					setPri: 10
					cycleSpeed: 20
					setCycle: Fwd
				)
			else
				(Fifi view: 462 loop: 0 cel: 0 illegalBits: 0 posn: 118 76)
				(self setScript: reading)
			)
			(Fifi init:)
		)
	)

	(method (doit)
		(if
			(and
				(not (self script:))
				(> (gEgo x:) 65)
				(not local1)
				(gCast contains: Rudy)
			)
			(HandsOff)
			(self setScript: slapHim)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
	)
)

(instance slapHim of Script
	(properties)

	(method (doit)
		(if (>= state 1)
			(if (>= state 5)
				(LookAt Fifi Rudy)
			)
			(if (and (== state 3) (== (Fifi cel:) 4))
				(myMusic number: 112 loop: 1 priority: 5 play:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0002))
						(|= gMustDos $0002)
						(|= gSpyFlags $0008)
						(= [gCycleTimers 2] 0)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(= local1 (= global163 1))
				(Rudy view: 387 cycleSpeed: 2 cel: 0 loop: 0 setCycle: End self)
			)
			(2
				(Rudy hide:)
				(Fifi
					view: 467
					ignoreActors: 1
					posn: 114 113
					cel: 0
					loop: 2
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(3
				(Fifi loop: 0 cycleSpeed: 1 setCycle: End self)
				(Print 261 0 #at 90 25 #font 4 #width 125 #draw #dispose) ; "Stop!! Stop eet! Leave me alone!!"
			)
			(4
				(Rudy show: loop: 1 cel: 0 cycleSpeed: 2 setCycle: End self)
				(Fifi loop: 1 posn: 114 113 cycleSpeed: 1 setCycle: End)
			)
			(5
				(cls)
				(Fifi view: 460 setPri: -1 setCycle: Walk ignoreActors: 0)
				(Rudy loop: 2 cycleSpeed: 0 setCycle: Fwd)
				(= seconds 4)
				(Print 261 1 #at 90 25 #font 4 #width 80 #draw #dispose) ; "Get out of my room NOW!!"
			)
			(6
				(cls)
				(Print 261 2 #at 125 25 #font 4 #width 80 #draw #dispose) ; "You'll regret that, you little vixen!"
				(Rudy
					view: 380
					setCycle: Walk
					setAvoider: (Avoid new:)
					setMotion: MoveTo 44 121 self
				)
			)
			(7
				(cls)
				(Rudy setMotion: MoveTo 44 244 self)
			)
			(8
				(Rudy dispose:)
				(Fifi setScript: lieDown)
				(DisposeScript 985)
				(client setScript: 0)
			)
		)
	)
)

(instance lieDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global163 1)
					(global373 setScript: playRecord init:)
				)
				(= global163 1)
				(&= [global377 4] $fee0)
				(Fifi
					cycleSpeed: 0
					illegalBits: 0
					setMotion: MoveTo 216 118 self
				)
			)
			(1
				(Fifi
					view: 472
					loop: 0
					cel: 0
					cycleSpeed: 1
					setPri: 10
					ignoreActors: 1
					setCycle: End self
				)
			)
			(2
				(Fifi loop: 1 cycleSpeed: 6 setCycle: Fwd)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance reading of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Fifi loop: 0 setCycle: End self)
			)
			(1
				(= state -1)
				(= seconds (Random 8 16))
			)
		)
	)
)

(instance playRecord of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Fwd)
				(mySound
					number: (if (== (mySound number:) 229) 224 else 229)
					loop: 1
					play: self
				)
				(= state -1)
			)
		)
	)
)

(instance mySound of Sound
	(properties)
)

(instance Rudy of Act
	(properties
		y 119
		x 71
		view 380
	)
)

(instance Fifi of Act
	(properties
		y 113
		x 114
		view 467
	)

	(method (handleEvent event)
		(if (> (gEgo x:) 64)
			(= global213 5)
			(cond
				((or (MousedOn self event 3) (Said 'look/fifi'))
					(cond
						((not (& global207 $0010))
							(= global213 5)
							(|= global207 $0010)
							(Say 0 261 3) ; "Fifi is the Colonel's pretty French maid. You surmise that she is probably very apt in her duties...whatever THEY may be! Fifi is young, blonde, and sexy. Although she seems to have a vivacious personality, you can sense a certain cunning underneath it all."
						)
						(global163
							(Print 261 4) ; "Fifi looks tired. She's resting in her bed."
						)
						(else
							(Print 261 5) ; "Fifi is quietly sitting on her couch reading a book."
						)
					)
					(event claimed: 1)
				)
				((and global163 (Said 'listen/fifi'))
					(Print 261 6) ; "Zzzzzzzzzzz."
				)
				(
					(and
						global163
						(or (Said 'give,show/*<fifi') (Said 'give,show/*/fifi'))
					)
					(if (and global219 global224)
						(Print 261 6) ; "Zzzzzzzzzzz."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((and global163 (Said 'look[<at]/bed'))
					(Print 261 4) ; "Fifi looks tired. She's resting in her bed."
				)
				((and global163 (Said 'awaken/fifi'))
					(Print 261 7) ; "Please, Mademoiselle. Let me restzzzzzz."
				)
				((and global163 (Said 'ask,tell//*<about'))
					(switch local0
						(0
							(Print 261 7) ; "Please, Mademoiselle. Let me restzzzzzz."
						)
						(else
							(Print 261 6) ; "Zzzzzzzzzzz."
						)
					)
					(++ local0)
				)
				((Said 'talk/fifi')
					(if global163
						(switch local0
							(0
								(Print 261 7) ; "Please, Mademoiselle. Let me restzzzzzz."
							)
							(else
								(Print 261 6) ; "Zzzzzzzzzzz."
							)
						)
					else
						(switch local0
							(0
								(Say 1 261 8) ; "Mademoiselle, S'il vous plait...please! I want to read my book!"
							)
							(1
								(Say 1 261 9) ; "Excusez-moi for saying, Mademoiselle, but why do you come een here?"
							)
							(2
								(Say 1 261 10) ; "Zis eez my break, Mademoiselle! Let me rest!"
							)
							(else
								(Print 261 11) ; "Obviously uncomfortable, Fifi tries to ignore you and read her book."
							)
						)
					)
					(++ local0)
				)
				((Said '/fifi>')
					(cond
						((Said 'get')
							(Print 261 12) ; "You can't get her!"
						)
						((Said 'kill')
							(Print 261 13) ; "There's no need for THAT sort of thing!"
						)
						((Said 'kiss')
							(Print 261 14) ; "You don't feel like kissing her."
						)
						((Said 'embrace')
							(Print 261 15) ; "You don't feel like hugging her."
						)
					)
				)
			)
		)
	)
)

