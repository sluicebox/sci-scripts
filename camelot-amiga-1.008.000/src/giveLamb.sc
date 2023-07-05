;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 161)
(include sci.sh)
(use Main)
(use Rm57)
(use n151)
(use Motion)
(use System)

(public
	giveLamb 0
	sellLamb 1
)

(procedure (localproc_0)
	(proc57_2)
	(gTObj tLoop: 4 postLoop: 0 cSpeed: 3)
	(Talk &rest)
)

(instance giveLamb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register (global185 script:))
				(global185 setLoop: 4 setCel: 0 setCycle: 0 setScript: 0)
				(gEgo
					view: 70
					loop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(SetFlag 150)
				(PutItem 10) ; lamb | dove
				(++ global146)
			)
			(1
				(global185 setLoop: 7 setCel: 0 setCycle: End self)
			)
			(2
				(Wait 0)
				(= seconds 1)
			)
			(3
				(global185 setCycle: Beg self)
			)
			(4
				(gEgo setCycle: Beg)
				(global185 setLoop: 4 cel: 0 setCycle: End self)
			)
			(5
				(gEgo view: 0 loop: 3 cycleSpeed: 0)
				(gTObj talkCue: self)
				(localproc_0 161 0 161 1) ; "You...you have brought this for me simply because I wanted it? No-one has ever shown me a kindness like this before."
			)
			(6
				(global185 view: 355 loop: 4 posn: 244 123)
				(gTObj talkCue: self)
				(localproc_0 161 2) ; "Come here, little one. I will feed you and clothe you and raise you as my son in honor of this good man."
			)
			(7
				(global185
					view: 380
					loop: 0
					setCel: 0
					posn: 244 125
					setCycle: 0
				)
				(= seconds 2)
			)
			(8
				(global185 cel: 1 posn: 244 125)
				(global186
					setLoop: 3
					ignoreActors:
					illegalBits: 0
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 248 137 self
				)
			)
			(9
				(global186
					setLoop: 9
					cel: 0
					cycleSpeed: 1
					setCycle: CT 4 1 self
				)
			)
			(10
				(global186 setPri: 7 setCycle: End)
				(global185
					view: 380
					setLoop: 0
					posn: 244 125
					setCycle: End self
				)
			)
			(11
				(global186 hide:)
				(global185 setLoop: 1 cel: 0 setCycle: End self)
			)
			(12
				(global185 setLoop: 2 cycleSpeed: 3 setCycle: Fwd)
				(= seconds 4)
			)
			(13
				(global185 cycleSpeed: 1 setLoop: 3 cel: 0 setCycle: End self)
			)
			(14
				(global185 setLoop: 0 setCel: 255 setCycle: Beg self)
				(global186 setLoop: 0 setCel: 3 posn: 219 128 show:)
			)
			(15
				(global185
					view: 355
					setLoop: 4
					cel: 0
					posn: 244 124
					setCycle: 0
				)
				(gTObj talkCue: self)
				(localproc_0 161 3) ; "I shall name him Joshua."
				(SetFlag 142)
			)
			(16
				(global185 setScript: register)
				(HandsOn)
				(= global185 0)
				(= global186 0)
				(client setScript: 0)
				(DisposeScript 161)
			)
		)
	)
)

(instance sellLamb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 240 140 self)
			)
			(1
				(gTObj talkCue: self)
				(proc57_3 161 4) ; "Buy it? Does no-one do anything in this world without seeking gain? Very well, I will give you 3 fals for it, since you have gone to the trouble."
			)
			(2
				(proc151_0 2 self self)
			)
			(3
				(+= global120 3)
				(PutItem 10) ; lamb | dove
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

