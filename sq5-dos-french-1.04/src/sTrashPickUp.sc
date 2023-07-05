;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 232)
(include sci.sh)
(use Main)
(use rm201)
(use eureka)
(use Motion)
(use System)

(public
	sTrashPickUp 3
	sAfterAlien 4
	sAlienHere 5
	sSpikeHere 7
	sDidntGetSpike 9
	sGenetixAlien 11
	sSpaceBarQuirk 12
	sSpikeComplaint 24
	sGarbageComplaint 25
)

(instance sTrashPickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music2 number: 211 setLoop: 1 play:)
				(= seconds 3)
			)
			(1
				(gSq5Music2 number: 225 loop: -1 play:)
				(= seconds 3)
			)
			(2
				(if (or (== global127 0) (and (== global127 1) (IsFlag 9)))
					(SetScore 166 100)
					(gCurRoom newRoom: 280)
				else
					(SetScore 167 100)
					(gCurRoom newRoom: 290)
				)
				(gSq5Music2 fade:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 232)
	)
)

(instance sSpikeHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
				(= global126 1)
			)
			(1
				(proc201_6 self)
			)
			(2
				(gMessager say: 16 0 26 1 self) ; "Captain! I'm picking up a life form reading in the waste compartment!"
			)
			(3
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(4
				(= seconds 2)
			)
			(5
				((ScriptID 202 13) init:) ; monitor1
				(= seconds 1)
			)
			(6
				(gMessager say: 16 0 26 2 self) ; "Captain, you'd better come down here. There are some strange scratching and whining noises coming out of the trash bin."
			)
			(7
				((ScriptID 202 13) dispose:) ; monitor1
				(= seconds 1)
			)
			(8
				(gGame handsOn:)
				(eureka state: 1)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 232)
	)
)

(instance sGarbageComplaint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 202 13) init:) ; monitor1
				(= seconds 2)
				(eureka garbage: 0 gdoor: 0)
			)
			(1
				(gMessager say: 28 0 0 1 self 202) ; "Hey! Thanks for leaving this mess back here for me to clean up. Real Captain-like of you!"
			)
			(2
				(if
					(and
						(or (not (IsFlag 56)) (IsFlag 113) (IsFlag 114))
						(> global126 1)
					)
					(if (or (IsFlag 113) (IsFlag 114))
						(ClearFlag 113)
						(ClearFlag 114)
						(if (IsFlag 56)
							(gMessager say: 14 0 90 1 self 202) ; "Thanks for taking care of your critter, Captain. I've finally managed to patch up the deck."
						else
							(gMessager say: 14 0 39 2 self 202) ; "Captain, ya gotta do something. That critter of yours is making Swiss cheese outta my deck back here! I'm gettin' mighty tired o' fixin' the floor."
						)
					else
						(gMessager say: 14 0 39 1 self 202) ; "That little acid piddling beastie you turned loose is roamin' around burning holes in everything. You better take care of him fast before he eats through the hull and kills us all!"
					)
				else
					(= cycles 1)
				)
			)
			(3
				((ScriptID 202 13) dispose:) ; monitor1
				(= seconds 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 232)
	)
)

(instance sSpikeComplaint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 202 13) init:) ; monitor1
				(= seconds 2)
			)
			(1
				(if (or (IsFlag 113) (IsFlag 114))
					(ClearFlag 113)
					(ClearFlag 114)
					(if (IsFlag 56)
						(gMessager say: 14 0 90 1 self 202) ; "Thanks for taking care of your critter, Captain. I've finally managed to patch up the deck."
					else
						(gMessager say: 14 0 39 2 self 202) ; "Captain, ya gotta do something. That critter of yours is making Swiss cheese outta my deck back here! I'm gettin' mighty tired o' fixin' the floor."
					)
				else
					(gMessager say: 14 0 39 1 self 202) ; "That little acid piddling beastie you turned loose is roamin' around burning holes in everything. You better take care of him fast before he eats through the hull and kills us all!"
				)
			)
			(2
				((ScriptID 202 13) dispose:) ; monitor1
				(= seconds 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 232)
	)
)

(instance sDidntGetSpike of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				((ScriptID 202 13) init:) ; monitor1
				(= ticks 35)
			)
			(2
				(gMessager say: 14 0 0 1 self 202) ; "Captain, we're losin' hull integrity. There's a big hole in the garbage compartment! The hatch is gonna blow any second! We're all gonna die!"
			)
			(3
				(client setScript: (ScriptID 210 3) 0 8) ; sBlowUpEureka
				(self dispose:)
			)
		)
	)
)

(instance sGenetixAlien of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
				(gGame handsOff:)
			)
			(1
				(proc201_6 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 2 0 1 1 self 202) ; "We're being hailed Captain. Putting it on screen."
			)
			(4
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(5
				(self setScript: (ScriptID 209 0) self 208) ; sStartViewPort
			)
			(6
				(gMessager say: 2 0 0 0 self 202) ; "Unauthorized ship, you are trespassing in an Alpha One security zone."
			)
			(7
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 232)
	)
)

(instance sSpaceBarQuirk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
				(gGame handsOff:)
			)
			(1
				(proc201_6 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 19 0 1 1 self 202) ; "I'm picking up a message from StarCon, sir."
			)
			(4
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(5
				(self setScript: (ScriptID 209 0) self 209) ; sStartViewPort
			)
			(6
				(gMessager say: 19 0 18 0 self 202) ; "Wilco! You malingering moron! Get back to work!"
			)
			(7
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 232)
	)
)

(instance sAlienHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(proc201_6 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 15 0 0 1 self 202) ; "Captain, I'm intercepting a rather unusual message on StarCon priority frequency 2. I'm putting it on screen."
			)
			(4
				(self setScript: (ScriptID 201 4) self 0) ; sBusyFlo
			)
			(5
				(self setScript: (ScriptID 209 0) self 208) ; sStartViewPort
			)
			(6
				((ScriptID 209 2) setCycle: End self) ; viewPort
			)
			(7
				((ScriptID 209 2) setCel: 0) ; viewPort
				(= cycles 1)
			)
			(8
				(gMessager say: 15 0 0 2 self 202) ; "...Maggot to Dung Heep, come in Dung Heep."
			)
			(9
				(= cycles 1)
			)
			(10
				(gCurRoom newRoom: 206)
				(eureka state: 1)
				(self dispose:)
			)
		)
	)
)

(instance sAfterAlien of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 209 2) init: view: 218 setLoop: 0 cel: 0) ; viewPort
				(= seconds 2)
			)
			(1
				((ScriptID 209 2) setCycle: Fwd self) ; viewPort
				(= seconds 2)
			)
			(2
				(self setScript: (ScriptID 209 1) self) ; sStopViewPort
				(proc201_5 0)
			)
			(3
				(gMessager say: 15 0 0 3 self 202) ; "I'm sorry Captain, but I wasn't able to pin down the source of the transmission."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 232)
	)
)

