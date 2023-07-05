;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 141)
(include sci.sh)
(use Main)
(use n819)
(use Talker)
(use Motion)
(use Actor)
(use System)

(public
	useTrident 0
	trident 1
)

(instance useTrident of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 141)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 10 255)
				(if (gFeatures contains: (ScriptID 140 1)) ; eyeFeature
					((ScriptID 140 1) dispose:) ; eyeFeature
					((ScriptID 140 2) dispose:) ; tridentDesign
				)
				(if (IsFlag 30)
					(= next (ScriptID 140 11)) ; TalkWithOracle
					(= state 8)
				)
				(= cycles 1)
			)
			(1
				(if (not gHowFast)
					(trident cycleSpeed: 5)
				else
					(trident cycleSpeed: 8)
				)
				(trident init: setCycle: CT 4 1 self)
			)
			(2
				(= cycles 5)
			)
			(3
				(gSoundEffects number: 144 loop: 1 play:)
				(trident setCycle: End self)
			)
			(4
				(trident setCycle: Beg self)
			)
			(5
				(trident setCycle: 0 dispose: delete:)
				(= cycles 3)
			)
			(6
				(if (gCast contains: (ScriptID 140 12)) ; breakage
					(gSoundEffects number: 165 loop: 1 play:)
					(ShakeScreen 7 ssLEFTRIGHT)
					((ScriptID 140 12) ; breakage
						setLoop: 1
						cel: 0
						cycleSpeed: 7
						setCycle: End self
					)
				else
					(self changeState: 8)
				)
			)
			(7
				((ScriptID 140 12) setCycle: 0 dispose: delete:) ; breakage
				(= cycles 3)
			)
			(8
				(UnLoad 128 155)
				(Narrator posn: -1 5 talkWidth: 224 init: 4 0 0 4 self 140) ; "The trident pushes in the three eyes and the wall trembles. A panel slowly opens..."
			)
			(9
				((ScriptID 140 3) init:) ; background
				(gSoundEffects number: 145 loop: 1 flags: 1 play:)
				((ScriptID 140 4) ; door
					cel: 1
					setMotion:
						MoveTo
						((ScriptID 140 4) x:) ; door
						(- ((ScriptID 140 4) nsTop:) 1) ; door
						self
				)
			)
			(10
				(gSoundEffects stop:)
				((ScriptID 140 4) hide:) ; door
				(self setScript: (ScriptID 140 5) self) ; oracleAppears
			)
			(11
				(= cycles 2)
			)
			(12
				(cond
					((IsFlag 73)
						(gCurRoom notify: 0)
					)
					((IsFlag 31)
						(gCurRoom notify: 1)
					)
					((and (IsFlag 4) (not (gEgo has: 19))) ; goldMask
						(if gFastCast
							((ScriptID 140 9) dispose:) ; Oracle
						)
						(gCurRoom notify: 2)
					)
					(else
						(if (IsFlag 29)
							(= state 14)
						)
						(= cycles 1)
					)
				)
			)
			(13
				(Narrator posn: -1 5 talkWidth: 224 init: 4 0 0 30 self 140) ; "A fish appears mysteriously from somewhere behind the panel. It must be the Oracle!"
			)
			(14
				((ScriptID 140 9) init: 2 0 0 1 1 self 140) ; Oracle, "The Oracle knows all life in the sea, But, creature of man, I know not thee."
			)
			(15
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance trident of Prop
	(properties
		x 143
		y 113
		z 17
		view 141
		priority 15
		signal 16400
	)
)

