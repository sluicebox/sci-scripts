;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 194)
(include sci.sh)
(use Main)
(use Interface)
(use EgoLooper)
(use Yoyo)
(use Motion)
(use Actor)
(use System)

(public
	fromShip 0
)

(procedure (localproc_0)
	(gTObj
		actor: (ScriptID 35 1) ; jabir
		noWidth: 1
		tWindow: (ScriptID 35 3) ; jabirWindow
		postLoop: 3
		cSpeed: 1
		talkCue: self
	)
	(if (!= (head cel:) 0)
		(head setCycle: Beg)
	)
	((ScriptID 35 2) setCycle: Fwd) ; jHead
	(Talk &rest)
)

(procedure (localproc_1)
	((ScriptID 35 2) setCycle: 0 cel: 0) ; jHead
	(gTObj
		actor: (ScriptID 35 4) ; hazm
		tLoop:
			(if
				(and
					(== ((ScriptID 35 4) loop:) 6) ; hazm
					(== ((ScriptID 35 4) cel:) 5) ; hazm
				)
				9
			else
				4
			)
		noWidth: 1
		tWindow: (ScriptID 35 5) ; hazmWindow
		postLoop: 6
		cSpeed: 2
		talkCue: self
	)
	(if (!= (head cel:) 4)
		(head setCycle: End)
	)
	(Talk &rest)
)

(instance fromShip of Script
	(properties)

	(method (dispose)
		((ScriptID 35 4) setCycle: 0 ignoreActors: 0) ; hazm
		(head dispose: delete:)
		(super dispose:)
		(DisposeScript 960)
		(DisposeScript 194)
		(gEgo
			setCycle: Walk
			setLoop: -1
			illegalBits: $8000
			moveSpeed: 0
			cycleSpeed: 0
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMuleObj loop: 1)
				(SetFlag 128)
				(gEgo
					view: 0
					illegalBits: 0
					ignoreActors:
					posn: 183 177
					setLoop: 0
					setCel: 0
					setPri: 3
					yStep: 1
					moveSpeed: 1
					setCycle: 0
				)
				(gMuleObj posn: 221 165 stopUpd:)
				((ScriptID 35 1) ; jabir
					view: 389
					posn: 39 138
					loop: 0
					cel: 5
					illegalBits: 0
				)
				((ScriptID 35 2) ignoreActors: 1) ; jHead
				((ScriptID 35 4) ; hazm
					view: 390
					posn: 200 167
					loop: 0
					setCycle: Fwd
					cycleSpeed: 3
					illegalBits: 0
				)
				(SetFlag 78)
				(= seconds 4)
			)
			(1
				(Print 194 0) ; "Arthur? Arthur."
				(= cycles 10)
			)
			(2
				(Print 194 1) ; "Arthur, WAKE UP!"
				(= cycles 10)
			)
			(3
				(gEgo setMotion: MoveTo 183 163 self)
			)
			(4
				(= seconds 2)
			)
			(5
				(Print 194 2) ; "You slept through the entire docking and unloading of the ship. You indulged too heavily in foreign wine."
				(Print 194 3) ; "If your head is pounding, blame no one but yourself."
				(gEgo
					setLoop: 3
					setCel: -1
					cycleSpeed: 1
					setCycle: Walk
					setMotion: MoveTo 183 154 self
				)
			)
			(6
				(gEgo
					moveSpeed: 2
					yStep: 2
					looper: EgoLooper
					setMotion: MoveTo 172 150 self
				)
			)
			(7
				(gEgo setLoop: 1 moveSpeed: 1 setMotion: MoveTo 160 121 self)
			)
			(8
				(gEgo setPri: 10 setLoop: -1 setMotion: MoveTo 105 140 self)
			)
			(9
				((ScriptID 35 4) loop: 1 cycleSpeed: 2 setCycle: End) ; hazm
				(gEgo setPri: -1 setMotion: MoveTo 128 154 self)
			)
			(10
				(ClearFlag 128)
				(gEgo cycleSpeed: 0 moveSpeed: 0 loop: 2 cel: 0)
				(head
					ignoreActors: 1
					posn: (- (gEgo x:) 2) (gEgo y:)
					init:
				)
				((ScriptID 35 4) ; hazm
					setLoop: 2
					cel: 0
					cycleSpeed: 0
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 155 160 self
				)
			)
			(11
				((ScriptID 35 4) setLoop: 3 setCel: 0 cycleSpeed: 1) ; hazm
				(gTObj preLoop: 3 tLoop: 4)
				(localproc_1 194 4) ; "Sir, I am Hazm. My master sends his respects and invites you to accept his hospitality. My Master--"
				((ScriptID 35 1) ; jabir
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 98 155
				)
			)
			(12
				((ScriptID 35 1) ; jabir
					view: 392
					loop: 8
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(13
				((ScriptID 35 2) posn: 98 155) ; jHead
				(gTObj preLoop: 3 tLoop: 4)
				(localproc_0 194 5) ; "Ignore this boy. You are lucky he did not make off with your mule. I am Jabir ibn Hamid. I overheard some sailors say you need a guide through the desert to Jerusalem."
			)
			(14
				(localproc_1 194 6) ; "Please, sir, my Master is Al-Sirat and he is very wise and he asks--"
			)
			(15
				(gTObj preLoop: 3)
				(localproc_0 194 7) ; "Al-Sirat is an impoverished old scholar of no use to anyone. But I, Jabir, know the desert, every rock, wadi, and waterhole. Trust me in all things."
			)
			(16
				(localproc_1 194 8) ; "Sir, I beg you to accept my Master's hospitality. He heard of you from the Captain of the ship and he sends warning that the mukhtar of Gaza--"
			)
			(17
				(gTObj preLoop: 5 tLoop: 6)
				(localproc_0 194 9) ; "Allow ME to explain. The mukhtar is the man who governs this port. He hates all foreigners and if he catches you here, he will throw you in prison. We should leave at once."
			)
			(18
				(gTObj tLoop: 4)
				(localproc_1 194 10) ; "I can take you to my Master by secret ways and Al-Sirat will protect and tell you--"
			)
			(19
				(gTObj preLoop: 3)
				(localproc_0 194 11) ; "Get out of here, boy! We men have business together and have no need of chattering pests. Be off!"
			)
			(20
				((ScriptID 35 2) hide:) ; jHead
				((ScriptID 35 1) loop: 1 setCycle: Yoyo 1 self) ; jabir
			)
			(21
				((ScriptID 35 2) show:) ; jHead
				(gTObj tLoop: 2 talkCue: self)
				(Talk 194 12 194 13) ; "Stranger, you will never survive the desert without my help. I ask for no payment now. When we reach Jerusalem safely, I will accept a fair payment."
			)
			(22
				(gTObj tLoop: 4)
				(localproc_1 194 14) ; "Sir, I beg you, ask to see my Master and all will be well."
				((ScriptID 35 1) loop: 1 cel: 6 setCycle: Beg) ; jabir
			)
			(23
				(= cycles 10)
			)
			(24
				(gEgo setCycle: 0)
				((ScriptID 35 1) setCycle: 0) ; jabir
				(head setCycle: 0 hide:)
				(gEgo loop: 2 cel: 0 ignoreActors: 0 illegalBits: $8000)
				((ScriptID 35 4) setLoop: 6 cel: 0) ; hazm
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance head of Prop
	(properties
		z 42
		view 90
		cel 4
	)
)

