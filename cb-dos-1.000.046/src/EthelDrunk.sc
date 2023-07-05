;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	EthelDrunk 0
)

(synonyms
	(ethel person woman)
)

(local
	[local0 24] = [160 185 160 132 65 129 242 187 197 172 233 134 189 138 80 138 80 113 136 177 135 163 0 0]
	[local24 24] = [0 0 160 132 83 42 340 187 340 170 304 97 159 113 -20 138 -20 138 166 240 118 240 0 0]
	[local48 24] = [160 240 -20 156 -20 62 -20 187 104 240 156 240 340 139 340 130 193 143 41 113 340 140 0 0]
	[local72 12] = [0 14 21 27 26 25 13 9 3 10 4 5]
	local84
	local85
	local86
	[local87 5]
)

(instance Smashed of Sound
	(properties)
)

(instance EthelDrunk of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gMustDos $0004))
			(LoadMany rsFONT 41)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsVIEW 642)
			(Load rsSCRIPT 406)
		)
		(Load rsVIEW 903)
		(LoadMany rsMESSAGE 243 275)
		(= [global377 3] 275)
		(if (== [gCycleTimers 0] 0)
			(= [gCycleTimers 0] 1099)
			(= global113 0)
		)
		(if (< [gCycleTimers 0] 2)
			(= [gCycleTimers 0] 900)
			(= global113 2)
			(= [local24 4] 40)
			(= [local24 5] 240)
		)
		(if (== gCurRoomNum 25)
			(Ethel setLoop: 0)
		)
		(if
			(and
				(== [local72 (- 11 global113)] gCurRoomNum)
				(> [gCycleTimers 0] (* (- 10 global113) 100))
			)
			(Smashed number: 62 loop: -1 priority: 12 play:)
			(= local84 1)
			(|= global208 $0008)
			(Ethel
				setCycle: Walk
				ignoreHorizon: 1
				moveSpeed: 2
				cycleSpeed: 1
				setAvoider: ((Avoid new:) offScreenOK: 1)
				posn: [local0 (* global113 2)] [local0 (+ (* global113 2) 1)]
				init:
			)
			(if (== gCurRoomNum 13)
				(Ethel observeControl: 64)
			)
			(if (== gCurRoomNum 27)
				(Ethel setMotion: MoveTo 193 143)
			else
				(Ethel
					setMotion:
						MoveTo
						[local48 (* global113 2)]
						[local48 (+ (* global113 2) 1)]
				)
			)
			(= global179 gCurRoomNum)
			(self setScript: ethelActions)
		)
	)

	(method (doit)
		(if (and (< [gCycleTimers 0] 2) (not local84))
			(= [gCycleTimers 0] 900)
			(= global113 2)
			(= [local24 4] 40)
			(= [local24 5] 240)
		)
		(if
			(and
				(!= gCurRoomNum 4)
				(== global180 0)
				(== (mod [gCycleTimers 0] 100) 0)
				(== [local72 (/ [gCycleTimers 0] 100)] gCurRoomNum)
				(not local84)
			)
			(if (User controls:)
				(Smashed number: 62 loop: -1 priority: 12 play:)
				(DisposeScript 990)
				(= global113 (- 11 (/ [gCycleTimers 0] 100)))
				(|= global208 $0008)
				(= local84 1)
				(Ethel
					setCycle: Walk
					ignoreHorizon: 1
					moveSpeed: 2
					cycleSpeed: 1
					setAvoider: ((Avoid new:) offScreenOK: 1)
					posn:
						[local24 (* global113 2)]
						[local24 (+ (* global113 2) 1)]
					init:
				)
				(Ethel observeControl: 64)
				(if (== gCurRoomNum 27)
					(Ethel setMotion: MoveTo 193 143)
				else
					(Ethel
						setMotion:
							MoveTo
							[local48 (* global113 2)]
							[local48 (+ (* global113 2) 1)]
					)
				)
				(= global179 gCurRoomNum)
				(self setScript: ethelActions)
			else
				(+= [gCycleTimers 0] 10)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(if (and (== global113 0) (== gCurRoomNum 5))
			(= global113 1)
		)
		(if local84
			(if (or (> (Ethel y:) 200) (> (Ethel x:) 320) (< (Ethel x:) 0))
				(++ global113)
				(= [gCycleTimers 0] (- 1100 (* global113 100)))
			else
				(= [gCycleTimers 0] (- 1120 (* global113 100)))
			)
		)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if
			(and
				(== (event type:) evSAID)
				global208
				(Said 'ask,tell,show,give,look,get,kill,kiss,embrace,flirt>')
			)
			(Ethel setScript: (ScriptID 243 0)) ; atsgl
			((Ethel script:) handleEvent: event)
			(if (event claimed:)
				(return)
			)
		)
	)
)

(instance ethelActions of Script
	(properties)

	(method (handleEvent event)
		(super handleEvent: event)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gAct 3)
					(cond
						((not global216)
							(= state -1)
						)
						((not (& gMustDos $0004))
							(if (and (== gMinute 3) (== gCurRoomNum 10))
								(= local86 1)
								(global373 startUpd:)
							)
							(|= gMustDos $0004)
							(self setScript: (ScriptID 406 0)) ; Clock
							(= state -1)
						)
						((self script:)
							(= state -1)
						)
					)
				)
				(= cycles 3)
			)
			(1
				(if (and (== gCurRoomNum 10) local86)
					(= local86 0)
					(global373 stopUpd:)
				)
				(if
					(and
						(== (Ethel x:) [local48 (* global113 2)])
						(== (Ethel y:) [local48 (+ (* global113 2) 1)])
					)
					(if (== gCurRoomNum 27)
						(= state 2)
					)
				else
					(= state 0)
				)
				(= cycles 1)
			)
			(2
				(= local86 0)
				(= local84 0)
				(++ global113)
				(= [gCycleTimers 0] (- 1100 (* global113 100)))
				(if (< [gCycleTimers 0] 2)
					(= [gCycleTimers 0] 900)
					(= global113 2)
				)
				(Smashed fade:)
				(= global179 0)
				(Ethel dispose:)
				(&= global208 $fff7)
				(= [global377 3] 0)
				(client setScript: 0)
			)
			(3
				(= state 1)
				(Ethel setMotion: MoveTo 110 110 self)
			)
		)
	)
)

(instance Ethel of Act
	(properties
		yStep 3
		view 328
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(= global213 4)
		(if local84
			(cond
				((Said '/drink,glass>')
					(cond
						((Said 'look')
							(Print 202 0) ; "It seems to be a very strong, alcoholic drink."
						)
						((Said 'get')
							(Print 202 1) ; "You don't want it!"
						)
					)
				)
				((Said 'listen/ethel')
					(Print 202 2) ; "Ethel isn't saying anything coherent."
				)
				((and (not (& global207 $0008)) (MousedOn self event 3))
					(event claimed: 1)
					(DoLook {ethel})
				)
				(
					(and
						(& global207 $0008)
						(or (MousedOn self event 3) (Said 'look/ethel'))
					)
					(event claimed: 1)
					(Print 202 3) ; "Ethel must need the cool night air to help clear her head...or is she just wandering mindlessly?"
				)
				((Said 'talk/ethel')
					(= global213 4)
					(switch local85
						(0
							(Say 1 202 4) ; "Hic! Ohhh! Back sho shooon, Laura?"
						)
						(1
							(Say 1 202 5) ; "Hiiii, Laura. Who'sh your friend?"
							(Say 1 202 6) ; "Ohh! Ish'you, ishn't it?"
						)
						(2
							(Say 1 202 7) ; "Where'ish everybody? Wha's happenin' aroun' here?"
						)
						(3
							(Say 1 202 8) ; "I'm kin'a scared, Laura. Shomeshings not right...I can fffeeel it."
						)
						(4
							(Say 1 202 9) ; "Hic! Why ddooo I keeep doing that?"
						)
						(5
							(Say 1 202 10) ; "Where you'shay Lillllian was?"
							(Say 1 202 11) ; "Ohhh, you didn't. Shat's okay. I'll finnd'her."
						)
						(6
							(Say 1 202 12) ; "Hic!"
						)
						(else
							(Print 202 13) ; "Ethel's too befuddled to really notice you. She barely responds."
						)
					)
					(++ local85)
				)
			)
		)
	)
)

