;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 154)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Actor)

(public
	jet 0
	proc154_1 1
	proc154_2 2
)

(synonyms
	(attendant attendant)
)

(procedure (proc154_1)
	(Print &rest #at 10 10 #font gSmallFont)
)

(procedure (proc154_2)
	(gAddToPics
		add:
			toilet
			seat1
			seat2
			seat3
			seat4
			seat5
			seat6
			seat7
			seat8
			seat9
			seat10
			seat11
			seat12
			seat13
			seat14
			seat15
			seat16
			window1
			window2
			window3
			window4
			window5
			window6
			window7
			bath1
			bath2
			trash
			sink
			mirror
			LCutWall
	)
	(gAddToPics doit:)
)

(instance jet of Locale
	(properties)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(cond
					((== (= temp0 (event message:)) KEY_F6)
						(event claimed: 1)
						(cond
							((not (gEgo has: 0)) ; hand_gun
								(proc0_13) ; "You don't have your gun."
							)
							(
								(or
									(not (gEgo has: 1)) ; extra_ammo_clips
									(== [global215 1] [global215 2] 0)
								)
								(Print 154 0) ; "You don't have any extra ammo clips."
							)
							([global215 global207]
								(Print 154 1) ; "Checking your gun, you see that the clip is not yet empty, and you do not reload."
							)
							((and global106 (not global201)) 0)
							(else
								(Print 154 2 #time 4) ; "Loaded."
								(if (== global207 1)
									(= global207 2)
								else
									(= global207 1)
								)
							)
						)
					)
					((== temp0 KEY_F8)
						(event claimed: 1)
						(cond
							((not (gEgo has: 0)) ; hand_gun
								(proc0_13) ; "You don't have your gun."
							)
							((== gCurRoomNum 41)
								(event claimed: 0)
							)
							(else
								(Print 154 3) ; "You don't need to use your gun now."
							)
						)
					)
				)
			)
			(evSAID
				(cond
					((Said '/compartment')
						(proc154_1 154 4)
					)
					((Said '/door>')
						(cond
							((Said 'open,hit')
								(cond
									((& (gEgo onControl:) $2000)
										(Print 154 5) ; "The rest room is occupied."
									)
									((& (gEgo onControl:) $1000)
										(Print 154 6) ; "The cockpit door is locked. Access is for crew members only."
									)
									(else
										(proc0_7) ; "You're not close enough."
									)
								)
							)
							((Said 'knock,hit')
								(cond
									((& (gEgo onControl:) $2000)
										(Print 154 7) ; "It's empty. Just go in."
									)
									((& (gEgo onControl:) $1000)
										(Print 154 8) ; "You knock, but no one answers."
									)
									(else
										(proc0_7) ; "You're not close enough."
									)
								)
							)
							((Said 'unlock')
								(Print 154 9) ; "You can't."
							)
							(else
								(event claimed: 1)
								(Print 154 10) ; "Leave the door alone."
							)
						)
					)
					((Said 'talk/passenger,man,woman')
						(if (not global201)
							(switch (Random 81 85)
								(81
									(proc154_1 154 11)
								)
								(82
									(proc154_1 154 12)
								)
								(83
									(proc154_1 154 13)
								)
								(84
									(proc154_1 154 14)
								)
								(85
									(proc154_1 154 15)
								)
							)
						else
							(Print 154 16) ; "You cannot talk to anyone from where you are sitting."
						)
					)
					((Said 'pinch[/attendant]')
						(cond
							((not (gCast contains: global198))
								(Print 154 17) ; "She's not here."
							)
							((> (gEgo distanceTo: global198) 25)
								(proc0_7) ; "You're not close enough."
							)
							(else
								(proc154_1 154 18)
							)
						)
					)
					((Said 'talk,call/attendant')
						(cond
							((not (gCast contains: global198))
								(Print 154 17) ; "She's not here."
							)
							((> (gEgo distanceTo: global198) 25)
								(proc0_7) ; "You're not close enough."
							)
							(else
								(proc154_1 154 19)
							)
						)
					)
					((Said 'use,go/crapper,bathroom,(chamber<(bath,rest))')
						(Print 154 20) ; "The bathroom is in the back of the plane."
					)
					((Said 'show/badge')
						(cond
							((not (gCast contains: global198))
								(Print 154 17) ; "She's not here."
							)
							((> (gEgo distanceTo: global198) 25)
								(proc0_7) ; "You're not close enough."
							)
							(else
								(proc154_1 154 21)
							)
						)
					)
					((Said '[kiss,fuck][/naked,boob,sex]')
						(cond
							((not (gCast contains: global198))
								(Print 154 17) ; "She's not here."
							)
							((> (gEgo distanceTo: global198) 25)
								(proc0_7) ; "You're not close enough."
							)
							(else
								(proc154_1 154 22)
								(proc154_1 154 23)
							)
						)
					)
					((Said 'fasten,drop,wear,buckle/belt,belt')
						(cond
							((not global201)
								(Print 154 24) ; "You are not sitting down."
							)
							(global202
								(Print 154 25) ; "Your seat belt is already buckled."
							)
							(else
								(Print 154 26) ; "Ok."
								(= global202 1)
							)
						)
					)
					((Said 'unfasten,unbuckle,remove,(get<off)/belt,belt')
						(cond
							((not global201)
								(Print 154 24) ; "You are not sitting down."
							)
							((not global202)
								(Print 154 27) ; "Your seat belt is already unbuckled."
							)
							(global202
								(Print 154 26) ; "Ok."
								(= global202 0)
							)
						)
					)
					((Said 'sat')
						(if global201
							(Print 154 28) ; "You already are."
						else
							(Print 154 29) ; "You are not near enough to your seat."
						)
					)
					((Said 'stand,(get<up)')
						(cond
							(global202
								(Print 154 30) ; "It's a little hard to do that while your seat belt is fastened."
							)
							((not global201)
								(Print 154 31) ; "You are already standing."
							)
							(else
								(Print 154 32) ; "You don't need to right now."
							)
						)
					)
					((Said 'buy,order')
						(Print 154 33) ; "The stewardess is not serving drinks now."
					)
					((Said '/captain')
						(proc154_1 154 34)
					)
					((Said 'meditate,nap')
						(Print 154 35) ; "You try to relax and sleep, but there's something about airplanes that you find unsettling."
					)
					((Said 'look>')
						(cond
							((Said '/attendant')
								(if (not (gCast contains: global198))
									(Print 154 17) ; "She's not here."
								else
									(proc154_1 154 36)
								)
							)
							((Said '/passenger')
								(proc154_1 154 37)
							)
							((Said '/man,woman')
								(proc154_1 154 38)
							)
							((Said '/pane')
								(proc154_1 154 39)
							)
							((Said '/bench')
								(proc154_1 154 40)
							)
							((Said '/bathroom')
								(proc154_1 154 20)
							)
							((Said '[<at,around][/(!*,chamber,airplane)]')
								(if (gEgo inRect: 63 152 75 161)
									(proc154_1 154 41)
								else
									(proc154_1 154 42)
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
		)
	)
)

(instance seat1 of PV
	(properties
		y 72
		x 205
		view 82
		loop 1
		cel 3
		priority 1
		signal 16384
	)
)

(instance seat2 of PV
	(properties
		y 82
		x 186
		view 82
		loop 1
		cel 5
		priority 1
		signal 16384
	)
)

(instance seat3 of PV
	(properties
		y 92
		x 165
		view 82
		loop 1
		priority 1
		signal 16384
	)
)

(instance seat4 of PV
	(properties
		y 102
		x 146
		view 82
		loop 1
		cel 6
		priority 1
		signal 16384
	)
)

(instance seat5 of PV
	(properties
		y 112
		x 125
		view 82
		loop 1
		cel 1
		priority 1
		signal 16384
	)
)

(instance seat6 of PV
	(properties
		y 123
		x 103
		view 82
		loop 1
		priority 1
		signal 16384
	)
)

(instance seat7 of PV
	(properties
		y 135
		x 80
		view 82
		loop 1
		cel 2
		priority 1
		signal 16384
	)
)

(instance seat8 of PV
	(properties
		y 146
		x 58
		view 82
		loop 1
		cel 4
		priority 1
		signal 16384
	)
)

(instance seat9 of PV
	(properties
		y 90
		x 253
		view 82
		loop 1
		cel 5
		priority 14
		signal 16384
	)
)

(instance seat10 of PV
	(properties
		y 100
		x 234
		view 82
		loop 1
		cel 1
		priority 14
		signal 16384
	)
)

(instance seat11 of PV
	(properties
		y 110
		x 213
		view 82
		loop 1
		cel 6
		priority 14
		signal 16384
	)
)

(instance seat12 of PV
	(properties
		y 120
		x 193
		view 82
		loop 1
		cel 4
		priority 14
		signal 16384
	)
)

(instance seat13 of PV
	(properties
		y 131
		x 171
		view 82
		loop 1
		priority 14
		signal 16384
	)
)

(instance seat14 of PV
	(properties
		y 141
		x 151
		view 82
		loop 1
		cel 2
		priority 14
		signal 16384
	)
)

(instance seat15 of PV
	(properties
		y 151
		x 131
		view 82
		loop 1
		cel 1
		priority 14
		signal 16384
	)
)

(instance seat16 of PV
	(properties
		y 162
		x 109
		view 82
		loop 1
		cel 5
		priority 14
		signal 16384
	)
)

(instance window1 of PV
	(properties
		y 49
		x 203
		view 82
		loop 6
		priority 0
	)
)

(instance window2 of PV
	(properties
		y 59
		x 183
		view 82
		loop 6
		priority 0
	)
)

(instance window3 of PV
	(properties
		y 69
		x 163
		view 82
		loop 6
		priority 0
	)
)

(instance window4 of PV
	(properties
		y 80
		x 141
		view 82
		loop 6
		priority 0
	)
)

(instance window5 of PV
	(properties
		y 91
		x 119
		view 82
		loop 6
		priority 0
	)
)

(instance window6 of PV
	(properties
		y 103
		x 95
		view 82
		loop 6
		priority 0
	)
)

(instance window7 of PV
	(properties
		y 116
		x 69
		view 82
		loop 6
		priority 0
	)
)

(instance bath1 of PV
	(properties
		y 41
		x 246
		view 82
		signal 16384
	)
)

(instance bath2 of PV
	(properties
		y 167
		x 65
		view 82
		loop 2
		cel 1
		priority 12
		signal 16384
	)
)

(instance toilet of PV
	(properties
		y 178
		x 68
		view 82
		cel 4
		priority 14
		signal 16384
	)
)

(instance trash of PV
	(properties
		y 181
		x 32
		view 82
		cel 3
		priority 14
		signal 16384
	)
)

(instance sink of PV
	(properties
		y 159
		x 27
		view 82
		cel 2
		signal 16384
	)
)

(instance mirror of PV
	(properties
		y 143
		x 21
		view 82
		cel 1
		signal 16384
	)
)

(instance LCutWall of PV
	(properties
		y 54
		x 242
		view 82
		cel 5
		priority 2
		signal 16384
	)
)

