;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm200 0
)

(local
	local0
	local1 = -1
	local2 = -1
	local3 = -1
	local4
	local5
)

(instance rm200 of Rm
	(properties
		noun 1
		picture 200
		north 240
		south 180
	)

	(method (init &tmp temp0)
		(Load rsVIEW 200)
		(LoadMany rsSOUND 9 106 135 137 140 141 212)
		(if (IsFlag 16)
			(= global171 0)
			(= local5 1)
		)
		(= local4 global171)
		(for ((= temp0 1)) (Message msgSIZE 201 1 4 temp0 1) ((++ temp0))
		)
		(= local0 (- temp0 1))
		(fBrainFace init:)
		(fCodeBridge init:)
		(fFootPrint init:)
		(fGardenSign init:)
		(fDoorway init:)
		(fSky init:)
		(fTrail init:)
		(fWhistle init:)
		(fOcean init:)
		(fToupeSign init:)
		(signSet
			add:
				(signTop init: ignoreActors: yourself:)
				(signMiddle init: ignoreActors: yourself:)
				(signBottom init: ignoreActors: yourself:)
		)
		(boardSet
			add:
				(firstBoard init: ignoreActors: actions: fCodeBridge yourself:)
				(middleBoard init: ignoreActors: actions: fCodeBridge yourself:)
				(lastBoard init: ignoreActors: actions: fCodeBridge yourself:)
		)
		(cond
			((and (!= global171 0) (not (IsFlag 16)))
				(switch global171
					(1
						(firstBoard show:)
						(middleBoard hide:)
						(lastBoard hide:)
						(signTop hide:)
						(signMiddle show:)
						(signBottom show:)
					)
					(2
						(firstBoard show:)
						(middleBoard show:)
						(lastBoard hide:)
						(signTop hide:)
						(signMiddle hide:)
						(signBottom show:)
					)
				)
			)
			((IsFlag 16)
				(signSet eachElementDo: #hide)
				(boardSet eachElementDo: #show)
			)
			(else
				(signSet eachElementDo: #show)
				(boardSet eachElementDo: #hide)
			)
		)
		(leftPole init: setCycle: Fwd actions: fCodeBridge)
		(rightPole init: setCycle: Fwd actions: fCodeBridge)
		(brainsEyes init: setScript: moveEyes)
		(smoke init: setCycle: Fwd)
		(chea init:)
		(ear init:)
		(volcanoDoor init:)
		(magicRock init:)
		(whistle init:)
		(if (IsFlag 35)
			(volcanoDoor cel: (- (NumCels volcanoDoor) 1))
			(fDoorway init:)
			(magicRock hide:)
		)
		(gCMusic number: 9 setLoop: -1 play: 127)
		(super init: &rest)
	)

	(method (doit)
		(Palette palANIMATE 230 236 9)
		(super doit:)
	)

	(method (dispose)
		(if (IsObject (ScriptID 220 0)) ; hiddenFolPuzzle
			((ScriptID 220 0) dispose:) ; hiddenFolPuzzle
		)
		(DisposeScript 220)
		(if (IsObject (ScriptID 268 0)) ; elementAnalyzer
			((ScriptID 268 0) dispose:) ; elementAnalyzer
		)
		(DisposeScript 268)
		(if (IsObject (ScriptID 205 0)) ; cipher
			((ScriptID 205 0) dispose:) ; cipher
		)
		(DisposeScript 205)
		(signSet release: dispose:)
		(boardSet release: dispose:)
		(super dispose: &rest)
	)
)

(instance growth of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 140 setLoop: 0 setVol: 127 play:)
				(if (== (client cel:) 0)
					(client startUpd: setCycle: End self)
				else
					(client startUpd: setCycle: Beg self)
				)
			)
			(1
				(gCSoundFX stop:)
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance wiggleEars of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client startUpd: setCycle: Fwd)
				(gCSoundFX number: 336 setVol: 1 play: 127)
				(= ticks (* (client cycleSpeed:) (NumCels client) 4))
			)
			(1
				(client setCycle: 0)
				(if (!= (client cel:) 0)
					(client cel: 0)
				)
				(= cycles 1)
			)
			(2
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance moveEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 60 180))
			)
			(1
				(if (!= (client cel:) (- (NumCels client) 1))
					(client startUpd: cel: (+ (client cel:) 1))
				else
					(client startUpd: cel: 0)
				)
				(= cycles 1)
			)
			(2
				(client stopUpd:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance openDoor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 7 9 0 0 self 20) ; "I have just completed my latest top-secret project. I would appreciate my battery (at your earliest convenience of course)."
			)
			(1
				(gCSoundFX number: 212 setLoop: 0 setVol: 127 play:)
				(client startUpd: setCycle: End self)
			)
			(2
				(gCSoundFX stop:)
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance getBag of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(gCSoundFX number: 106 setLoop: 1 play: 127 self)
				(client cycleSpeed: 6 setCycle: End self)
			)
			(2
				(gCSoundFX stop:)
				(gCSoundFX number: 135 setLoop: 0 play: 127)
				(= ticks 45)
			)
			(3
				(Print y: 60 addText: 15 1 0 0 init: self) ; "You see a mysterious bag suddenly appear on the trail."
			)
			(4
				(Print y: 60 addText: 15 4 0 0 init: self) ; "You take the mysterious bag from the mountain trail. It contains items for the Volcano Door Analyzer."
			)
			(5
				(gEgo get: 11)
				(proc5_12 11)
				(magicRock hide:)
				(gGame setCursor: gTheCursor 1 106 112)
				(self dispose:)
			)
		)
	)
)

(instance boatWhistling of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 141 setLoop: 0 play: 127 self)
				(whistle setCycle: Fwd)
			)
			(1
				(whistle setCycle: 0 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance fBrainFace of Feature
	(properties
		noun 3
		onMeCheck 16
	)
)

(instance fCodeBridge of Feature
	(properties
		noun 17
		onMeCheck 1024
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(cond
					((< local2 0)
						((ScriptID 205 0) init:) ; cipher
						(= local2 global114)
					)
					((!= local2 global114)
						((ScriptID 205 0) dispose: init:) ; cipher
						(= local2 global114)
					)
				)
				(switch ((ScriptID 205 0) show:) ; cipher
					(1
						((ScriptID 205 0) dispose:) ; cipher
						(= local2 -1)
						(if (not local5)
							(Wait 0)
							(for ((= temp0 local4)) (< temp0 3) ((++ temp0))
								(Wait 30)
								(gCSoundFX number: 137 setLoop: 0 play: 127)
								((signSet at: temp0) hide:)
								((boardSet at: temp0) show:)
								(Animate (gCast elements:) 0)
							)
							(= local5 1)
						)
						(= global171 0)
					)
					(0
						(if (and (!= local4 global171) (not (IsFlag 16)))
							(Wait 0)
							(for
								((= temp0 local4))
								(< temp0 global171)
								((++ temp0))
								
								(Wait 30)
								(gCSoundFX number: 137 setLoop: 0 play: 127)
								((signSet at: temp0) hide:)
								((boardSet at: temp0) show:)
								(Animate (gCast elements:) 0)
							)
						)
						(= local4 global171)
					)
				)
				(return 1)
			)
			(1
				(if (not local5)
					(gMessager say: noun theVerb 1) ; "You notice several slats missing from the bridge. Perhaps that sign in front of the bridge will give you a clue about this."
				else
					(gMessager say: noun theVerb 5) ; "It looks like this bridge was repaired recently."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fFootPrint of Feature
	(properties
		noun 11
		onMeCheck 8
	)
)

(instance fGardenSign of Feature
	(properties
		noun 9
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (IsFlag 16))
					(gMessager say: noun 4 1 0) ; "Sorry, it's unsafe to enter Dr. Brain's Botanical Garden right now. In fact, did you notice how many gaps are in that bridge? If you can repair that bridge, then you can safely enter Dr. Brain's Garden."
					(return)
				)
				(cond
					(
						(or
							(< local3 0)
							(not (IsObject (ScriptID 220 0))) ; hiddenFolPuzzle
							(not ((ScriptID 220 0) inited:)) ; hiddenFolPuzzle
						)
						((ScriptID 220 0) init:) ; hiddenFolPuzzle
						(= local3 global114)
					)
					((!= local3 global114)
						((ScriptID 220 0) dispose: init:) ; hiddenFolPuzzle
						(= local3 global114)
					)
				)
				(gCMusic fade: 0 10 10 0)
				(Wait 0)
				(Wait 105)
				(switch ((ScriptID 220 0) show:) ; hiddenFolPuzzle
					(1
						((ScriptID 220 0) dispose:) ; hiddenFolPuzzle
						(if (magicRock isNotHidden:)
							(magicRock setScript: getBag)
						)
					)
					(0 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fSky of Feature
	(properties
		noun 10
		onMeCheck 4
	)
)

(instance fDoorway of Feature
	(properties
		noun 2
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gCurRoom newRoom: (gCurRoom north:))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fTrail of Feature
	(properties
		noun 8
		onMeCheck 4096
	)
)

(instance fWhistle of Feature
	(properties
		noun 7
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gCurRoom setScript: boatWhistling)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fOcean of Feature
	(properties
		noun 12
		onMeCheck 16384
	)
)

(instance fToupeSign of Feature
	(properties
		noun 13
		onMeCheck 8192
	)
)

(instance leftPole of Prop
	(properties
		x 79
		y 142
		view 200
		loop 3
		signal 22530
		cycleSpeed 9
	)
)

(instance rightPole of Prop
	(properties
		x 78
		y 134
		view 200
		loop 4
		signal 22530
		cycleSpeed 9
	)
)

(instance brainsEyes of Prop
	(properties
		x 259
		y 178
		noun 3
		view 200
		loop 1
		signal 18433
		cycleSpeed 1
	)
)

(instance smoke of Prop
	(properties
		x 112
		noun 10
		view 200
		loop 2
		signal 18434
		cycleSpeed 12
	)
)

(instance chea of Prop
	(properties
		x 17
		y 97
		noun 5
		view 200
		loop 5
		signal 18433
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (== script 0)
					(self setScript: growth)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ear of Prop
	(properties
		x 294
		y 149
		noun 14
		view 200
		loop 10
		signal 18433
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (== script 0)
					(self setScript: wiggleEars)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance volcanoDoor of Prop
	(properties
		x 124
		y 42
		noun 1
		view 200
		loop 7
		signal 22529
		cycleSpeed 12
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(cond
			((or (== theVerb 4) (== theVerb 38))
				(if (or (not (IsFlag 16)) (not (IsFlag 17)))
					(proc5_1)
					(Wait 0)
					(for ((= temp0 0)) (< temp0 4) ((++ temp0))
						(gCSoundFX number: 112 setLoop: 0 play: 127)
						(Wait 10)
					)
					(= temp0 1)
					(= temp1 (Random 1 local0))
					(proc5_2)
					(while (Message msgSIZE 201 noun 4 temp1 temp0)
						(proc15_0 0 noun 4 temp1 temp0 0 201)
						(++ temp0)
					)
					(return)
				)
				(if (gEgo has: 11)
					(gEgo put: 11)
					(proc0_1)
				)
				(cond
					((< local1 0)
						((ScriptID 268 0) init:) ; elementAnalyzer
						(= local1 global114)
					)
					((!= local1 global114)
						((ScriptID 268 0) dispose: init:) ; elementAnalyzer
						(= local1 global114)
					)
				)
				(switch ((ScriptID 268 0) show:) ; elementAnalyzer
					(1
						((ScriptID 268 0) dispose:) ; elementAnalyzer
						(if (not (IsFlag 35))
							(volcanoDoor setScript: openDoor)
							(SetFlag 35)
						)
						(= local1 -1)
					)
					(0 0)
				)
			)
			((== theVerb 1)
				(gMessager say: noun 1 0 0 0 201) ; "In the distance you see a doorway leading into the volcano."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance magicRock of Prop
	(properties
		x 103
		y 116
		noun 1
		view 204
	)
)

(instance whistle of Prop
	(properties
		x 132
		y 40
		noun 7
		view 200
		loop 11
		signal 2049
	)
)

(instance firstBoard of View
	(properties
		x 65
		y 139
		noun 17
		view 200
		cel 2
		signal 4353
	)
)

(instance middleBoard of View
	(properties
		x 56
		y 131
		noun 17
		view 200
		signal 4353
	)
)

(instance lastBoard of View
	(properties
		x 58
		y 129
		noun 17
		view 200
		cel 1
		signal 4353
	)
)

(instance signTop of View
	(properties
		x 146
		y 122
		noun 4
		view 200
		loop 6
		cel 1
		signal 4353
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(fCodeBridge doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance signMiddle of View
	(properties
		x 145
		y 116
		noun 4
		view 200
		loop 6
		cel 2
		signal 4353
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(fCodeBridge doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance signBottom of View
	(properties
		x 143
		y 103
		noun 4
		view 200
		loop 6
		cel 3
		signal 4353
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(fCodeBridge doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance signSet of Set
	(properties)
)

(instance boardSet of Set
	(properties)
)

