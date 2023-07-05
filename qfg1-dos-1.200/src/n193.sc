;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 193)
(include sci.sh)
(use Main)

(public
	proc193_0 0
)

(procedure (proc193_0 &tmp temp0)
	(cond
		((Said 'look,read/sign,note,message')
			(HighPrint 193 0) ; "There are two notes."
			(HighPrint 193 1) ; "There is a sign on the blue carpet which reads, "Step Here"."
			(HighPrint 193 2) ; "There is a sign on the right bridge which reads, "Cross Here"."
		)
		((Said 'look>')
			(cond
				((Said '[<at,around][/place,area]')
					(HighPrint 193 3) ; "This is not what you expected the brigands' fortress to look like in your imagination. The barracks with the open half-doors to the east and west are fairly normal looking. The carpet lying near the gate, however, is a bit odd. The small chasm in the middle of this yard with the bridge across it seems strange, too. There are two blockades near the gate and some barriers near the north."
				)
				((Said '<below/carpet,carpet')
					(HighPrint 193 4) ; "That's interesting. There seems to be a pit trap under the carpet."
				)
				((Said '[<at]/carpet,carpet')
					(HighPrint 193 5) ; "The carpets look rather new, perhaps recently stolen from the merchant in town. There is a sign on the blue carpet which reads, "Step Here"."
				)
				((Said '[<at]/wall')
					(HighPrint 193 6) ; "The barracks have open half-doors and you can hear noise behind them."
				)
				((Said '[<at]/chasm,pit,chasm')
					(HighPrint 193 7) ; "The chasm is about six feet across and ten feet deep."
				)
				((Said '[<at]/string,rope,string,line')
					(HighPrint 193 8) ; "There is a dark rope stretched tautly across the path. It can easily be avoided by stepping over it."
				)
				((Said '[<at]/jack,box')
					(HighPrint 193 9) ; "It looks like a plain, simple, harmless box to you."
				)
				((Said '[<at]/bridge[<left]')
					(HighPrint 193 10) ; "The bridge looks sturdy resting on its pole across the chasm."
				)
				((Said '[<at]/bridge,plank[<right]')
					(HighPrint 193 11) ; "The bridge looks sturdy resting on its poles across the chasm. There is a sign on it which reads, "Cross Here"."
				)
				((Said '[<at]/bridge,plank')
					(cond
						((gEgo inRect: 204 97 245 123)
							(HighPrint 193 12) ; "Sturdy looking bridge with two support poles across the chasm. A sign that reads: "Cross Here" is atop the bridge."
						)
						((gEgo inRect: 90 98 112 124)
							(HighPrint 193 13) ; "Sturdy looking bridge with one support pole across the chasm."
						)
						(else
							(HighPrint 193 14) ; "There are two bridges which cross the chasm."
						)
					)
				)
				((Said '[<at]/bag,bag')
					(HighPrint 193 15) ; "The sacks seem to be full of grain."
				)
				((Said '[<at]/barrel,barrel')
					(HighPrint 193 16) ; "The barrels look like empty wine casks."
				)
				((Said '<up')
					(HighPrint 193 17) ; "Nothing but cobwebs."
				)
				((or (Said '<down') (Said '/ground'))
					(cond
						(
							(or
								(gEgo inRect: 145 72 175 100)
								(gEgo inRect: 275 152 298 170)
							)
							(HighPrint 193 18) ; "You see a rope tautly strung about 6 inches off the floor."
						)
						((gEgo inRect: 128 125 193 184)
							(HighPrint 193 5) ; "The carpets look rather new, perhaps recently stolen from the merchant in town. There is a sign on the blue carpet which reads, "Step Here"."
						)
						((gEgo inRect: 204 97 245 123)
							(HighPrint 193 12) ; "Sturdy looking bridge with two support poles across the chasm. A sign that reads: "Cross Here" is atop the bridge."
						)
						((gEgo inRect: 90 98 112 124)
							(HighPrint 193 13) ; "Sturdy looking bridge with one support pole across the chasm."
						)
						(else
							(HighPrint 193 19) ; "Don't -- you'll get dizzy."
						)
					)
				)
				((Said '/east,west')
					(HighPrint 193 6) ; "The barracks have open half-doors and you can hear noise behind them."
				)
				((Said '/north')
					(HighPrint 193 20) ; "The building to the north has a window and a single door."
				)
				((Said '/south,gate,door')
					(if (IsFlag 238)
						(HighPrint 193 21) ; "You can see the fortress wall and the open gate."
					else
						(HighPrint 193 22) ; "You can see the fortress wall and the closed gate."
					)
				)
				((Said '/window')
					(cond
						((gEgo inRect: 156 65 207 76)
							(HighPrint 193 23) ; "All that can be seen through the window are vague shapes and outlines."
						)
						((not (< 59 (gEgo x:) 240))
							(if ((ScriptID 94 0) notify: 0) ; rm94
								((ScriptID 94 1) setScript: (ScriptID 94 5)) ; archer1, archer1Start
								((ScriptID 94 2) setScript: (ScriptID 94 6)) ; archer2, archer2Start
								((ScriptID 94 3) setScript: (ScriptID 94 7)) ; archer3, archer3Start
								((ScriptID 94 4) setScript: (ScriptID 94 8)) ; archer4, archer4Start
								(HighPrint 193 24) ; "You see a group of brigands playing cards. One looks back at you in surprise and starts yelling."
							)
						)
						(else
							(HighPrint 193 25) ; "You're not near any window"
						)
					)
				)
				((Said '/door')
					(HighPrint 193 26) ; "Yep, it's a door all right"
				)
				((Said '/cabinet,box,table')
					(cond
						((gEgo inRect: 0 129 37 190)
							(HighPrint 193 27) ; "An empty cabinet."
						)
						((not (gEgo inRect: 276 143 320 177))
							(HighPrint 193 28) ; "Get close for a good look."
						)
						(((ScriptID 94 0) notify: 1) ; rm94
							(HighPrint 193 29) ; "You don't have much time to look at toys."
						)
						(else
							(HighPrint 193 30) ; "The cabinet seems to have some kind of hasp."
						)
					)
				)
			)
		)
		((Said 'get,get,grab,move>')
			(cond
				((Said '/carpet,carpet')
					(HighPrint 193 31) ; "The rugs are too big to put into your backpack and too heavy to carry around. You do notice a pit trap under the spread-out carpet."
				)
				((Said '/string,rope,string')
					(HighPrint 193 32) ; "The rope is securely fastened and is pretty useless anyway."
				)
				((Said '/jack,box')
					(HighPrint 193 33) ; "Your life is in grave danger and you want to play with toys? What kind of hero are you?."
				)
				((Said '/bag,barrel')
					(HighPrint 193 34) ; "They're too heavy to carry."
				)
			)
		)
		((Said 'get/boulder')
			(HighPrint 193 35) ; "There are no rocks in here."
		)
		((Said 'open/jack,box,toy,hasp,cabinet')
			(cond
				((not (gEgo inRect: 276 143 320 177))
					(HighPrint 193 36) ; "You're not close enough"
				)
				(((ScriptID 94 0) notify: 1) ; rm94
					(HighPrint 193 37) ; "It's already open."
				)
				(else
					((ScriptID 94 15) setScript: (ScriptID 192 0)) ; jackCycle, jackJumps
				)
			)
		)
		((Said 'close,close[/gate,door]')
			(cond
				(
					(and
						(gEgo inRect: 193 0 320 74)
						((ScriptID 94 0) notify: 3) ; rm94
					)
					((ScriptID 94 17) setScript: (ScriptID 194 1)) ; door, closeGate
				)
				(((ScriptID 94 0) notify: 3) ; rm94
					(HighPrint 193 38) ; "You must get closer."
				)
				(else
					(HighPrint 193 39) ; "The door is closed."
				)
			)
		)
	)
	(DisposeScript 193)
)

