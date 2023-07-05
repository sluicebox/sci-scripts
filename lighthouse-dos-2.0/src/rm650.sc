;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use LightRoom)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	local0
)

(instance rm650 of LightRoom
	(properties)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 610) ; rmWoodshop
			(self changeScene: 650 3)
		else
			(self changeScene: 654 7)
		)
		(if (!= global239 6)
			(Load rsAUDIO 61201 61202)
		)
		(gBackMusic number: 60007 loop: -1 play: setVol: 127)
	)

	(method (newRoom newRoomNumber)
		(gBackMusic fade:)
		(super newRoom: newRoomNumber)
	)

	(method (changeScene param1)
		(gCast eachElementDo: #dispose)
		(gFeatures eachElementDo: #dispose)
		(self setScript: 0)
		(monsterSound stop:)
		(super changeScene: param1 &rest)
		(switch param1
			(650
				((ScriptID 1 2) newPic: 652 7 nsTop: 275) ; exitBack
				(water init:)
				(if global239
					(bridge init:)
				)
				(if (== global239 6)
					((ScriptID 1 1) newPic: 651 3) ; exitForward
				)
				(monsterSound stop:)
				(if local0
					(self setScript: angryMonster)
				)
			)
			(651
				((ScriptID 1 1) newRoom: 660 3) ; exitForward, rmFoundry
				((ScriptID 1 2) newPic: 654 7) ; exitBack
				(if (IsFlag 208)
					(fireInTheFurnace init:)
				)
			)
			(652
				(if local0
					(Load rsAUDIO 61203)
					(monsterSound play: setLoop: -1)
				)
				((ScriptID 1 2) newPic: 650 3) ; exitBack
				((ScriptID 1 1) newRoom: 610 7) ; exitForward, rmWoodshop
			)
			(654
				((ScriptID 1 2) newPic: 651 3) ; exitBack
				((ScriptID 1 1) newPic: 652 7) ; exitForward
			)
		)
	)
)

(instance smashBridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 60003)
				(gBackMusic number: 60003 play:)
				(cond
					((== global239 4)
						(KillRobot 179 23 0)
					)
					((== global239 1)
						(KillRobot 187 19 0)
					)
				)
			)
			(1
				(if (== global239 1)
					(bridge setLoop: 0)
				else
					(bridge dispose:)
				)
			)
			(2
				(if (== global239 1)
					(bridge dispose:)
				else
					(self cue:)
				)
			)
			(3
				(= local0 1)
				(= global239 0)
				(water dispose:)
				(gGame handsOn:)
				(gCurRoom setScript: angryMonster)
			)
		)
	)
)

(instance angryMonster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (Random 0 1)
					(KillRobot 180 60 44 0 -1 1)
				else
					(KillRobot 181 83 36 0 -1 1)
				)
			)
			(1
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance fireInTheFurnace of View
	(properties
		x 193
		y 190
		view 4651
	)
)

(instance bridge of Prop
	(properties
		x 178
		y 299
		view 190
	)

	(method (init)
		(switch global239
			(1
				(= loop 0)
			)
			(2
				(= loop 1)
			)
			(3
				(= loop 2)
			)
			(4
				(= loop 4)
			)
			(5
				(= loop 6)
			)
			(6
				(= loop 8)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(water doVerb: theVerb)
	)
)

(instance water of Feature
	(properties
		nsBottom 400
		nsLeft 167
		nsRight 392
		nsTop 204
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 80 79)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; invLargePlanks
				(switch global239
					(0
						(bridge loop: 0 cel: 0 init:)
						(longBoardSound play:)
						(if (== ((ScriptID 9 72) cel:) 0) ; invLargePlanks
							(gInventory deleteItem: (ScriptID 9 72)) ; invLargePlanks
						else
							((ScriptID 9 72) cel: (- ((ScriptID 9 72) cel:) 1)) ; invLargePlanks, invLargePlanks
							(gGame normalizeCursor:)
						)
						(++ global239)
					)
					(1
						(gInventory deleteItem: (ScriptID 9 72)) ; invLargePlanks
						(longBoardSound play:)
						(bridge setLoop: 1)
						(if (OneOf global238 -1 0 3)
							(gCurRoom setScript: smashBridge)
						else
							(++ global239)
						)
					)
				)
			)
			(79 ; invSmallPlanks
				(switch global239
					(2
						(if (== ((ScriptID 9 71) cel:) 0) ; invSmallPlanks
							(gInventory deleteItem: (ScriptID 9 71)) ; invSmallPlanks
						else
							((ScriptID 9 71) cel: (- ((ScriptID 9 71) cel:) 1)) ; invSmallPlanks, invSmallPlanks
							(gGame normalizeCursor:)
						)
						(shortBoardSound play:)
						(bridge setLoop: 2)
						(++ global239)
					)
					(3
						(if (== ((ScriptID 9 71) cel:) 0) ; invSmallPlanks
							(gInventory deleteItem: (ScriptID 9 71)) ; invSmallPlanks
						else
							((ScriptID 9 71) cel: (- ((ScriptID 9 71) cel:) 1)) ; invSmallPlanks, invSmallPlanks
							(gGame normalizeCursor:)
						)
						(shortBoardSound play:)
						(bridge setLoop: 4)
						(++ global239)
					)
					(4
						(if (== ((ScriptID 9 71) cel:) 0) ; invSmallPlanks
							(gInventory deleteItem: (ScriptID 9 71)) ; invSmallPlanks
						else
							((ScriptID 9 71) cel: (- ((ScriptID 9 71) cel:) 1)) ; invSmallPlanks, invSmallPlanks
							(gGame normalizeCursor:)
						)
						(shortBoardSound play:)
						(bridge setLoop: 6)
						(if (or (IsFlag 344) (== global238 4))
							(++ global239)
						else
							(gCurRoom setScript: smashBridge)
						)
					)
					(5
						(gInventory deleteItem: (ScriptID 9 71)) ; invSmallPlanks
						(shortBoardSound play:)
						(bridge setLoop: 8)
						(++ global239)
						((ScriptID 1 1) newRoom: 660) ; exitForward, rmFoundry
					)
				)
			)
		)
	)
)

(instance monsterSound of Sound
	(properties
		number 61203
		flags 1
		loop -1
	)
)

(instance shortBoardSound of Sound
	(properties
		number 61201
		flags 1
	)
)

(instance longBoardSound of Sound
	(properties
		number 61202
		flags 1
	)
)

