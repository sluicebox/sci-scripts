;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use Rm62)
(use n151)
(use Motion)
(use System)

(public
	buyLamb 0
)

(instance buyLamb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				(proc151_0 2 self self)
			)
			(1
				(global186 hide:)
				(global185
					setLoop: 5
					setCel: 0
					setCycle: End
					setStep: 4 2
					setMotion: MoveTo 232 126 self
				)
			)
			(2
				(global185 setLoop: 7 setCel: 0 setCycle: CT 2 1 self)
				(global187 hide:)
			)
			(3
				(global185 setCycle: End self)
				(= seconds 2)
			)
			(4
				(global185 setCel: 3 setCycle: End self)
			)
			(5
				(global185 setCel: 3 setCycle: End self)
			)
			(6
				(gEgo ignoreActors: setMotion: MoveTo 240 141 self)
			)
			(7
				(gEgo loop: 3)
				(proc62_2 170 0) ; "Here."
				(= seconds 2)
			)
			(8
				(proc151_0 1 self self)
			)
			(9
				(= seconds 1)
			)
			(10
				(gEgo view: 0 loop: 3 ignoreActors: 0)
				(global185 setLoop: 7 setCel: 255 setCycle: Beg self)
			)
			(11
				(global187 show: setCel: 1)
				(global185
					setLoop: 6
					setCel: 0
					setCycle: End
					setMotion: MoveTo 256 126 self
				)
			)
			(12
				(global185 setLoop: 1 setCel: 0)
				(global186 show:)
				(gEgo get: 10) ; lamb | dove
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 170)
			)
		)
	)
)

