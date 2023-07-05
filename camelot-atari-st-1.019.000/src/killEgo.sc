;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 136)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Menu)
(use System)

(public
	killEgo 0
)

(instance killEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj endTalk:)
				((ScriptID 51 1) setLoop: 1 setCycle: End self) ; mercenary
			)
			(1
				(gEgo
					view: 6
					setCycle: Walk
					ignoreActors: 1
					setMotion: MoveTo 220 156 self
				)
			)
			(2
				(gTObj noWidth: 1 actor: 0)
				(Talk 136 0) ; "Die, infidel"
				((ScriptID 51 2) ; whiteThug
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
					startUpd:
				)
				((ScriptID 51 3) setCycle: End startUpd:) ; blueThug
				((ScriptID 51 4) setCycle: End startUpd:) ; magentaThug
				((ScriptID 51 1) ; mercenary
					setPri: (- (gEgo priority:) 1)
					setLoop: 5
					setCycle: End
				)
				(= cycles 2)
			)
			(3
				(gEgo view: 81 loop: 0 cel: 0 setCycle: End)
				(= cycles 2)
			)
			(4
				(gRegMusic stop:)
				(gSFX number: (proc0_20 82) priority: 5 loop: 1 play:)
				(= cycles 10)
			)
			(5
				(gTObj endTalk:)
				(Print 136 1) ; "I was going to make a remark about using your brains, Arthur, but since I see they are all over the ground, along with your blood, heart, kidneys, liver, lungs and intestines, I guess there is no point."
				(MenuBar state: 1)
				(EgoDead)
			)
		)
	)
)

