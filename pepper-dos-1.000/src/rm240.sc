;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use CycleBet)
(use BalloonTalker)
(use invCode)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm240 0
	watchManTalker 1
	poorRichardTalker 4
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 9] = [61 161 3 14 86 0 0 240 1]
	[local17 9] = [126 163 4 0 0 0 0 240 3]
)

(instance rm240 of ADRoom
	(properties
		noun 12
		picture 240
		horizon 75
		north 250
		vanishingY -60
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(if (== gAct 2)
					(gMessager say: 12 85 3) ; "Oh, man! How are we gonna get out of here, Lockjaw?"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(if (== gAct 4)
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 89 154 60 176 23 176 23 185 87 185 87 172 213 172 213 145 199 145 199 138 153 138 153 154
						yourself:
					)
			)
		else
			(self
				addObstacle:
					(roomPoly
						type: PContainedAccess
						init: 61 145 47 154 89 154 60 176 23 176 23 185 87 185 87 172 123 162 143 172 213 172 213 145 199 145 199 142 155 142 155 145
						yourself:
					)
			)
		)
		(super init: &rest)
		(gEgo init: normalize: x: 197 y: 144 ignoreActors: 1 setScale: 0)
		(door approachVerbs: 86 init:) ; Nose
		(bigCrate init: setOnMeCheck: 1 4)
		(eastCrates init: setOnMeCheck: 1 4096)
		(westCrates init:)
		(barrel init: setOnMeCheck: 1 8192)
		(floor init: setOnMeCheck: 1 2048)
		(theWindow init: approachVerbs: 7) ; Do
		(pillow init: approachVerbs: 6 setOnMeCheck: 1 2) ; Look
		(boxByWindow init: setOnMeCheck: 1 16384)
		(herbFeat init: setOnMeCheck: 1 2)
		(leftHerbs init: setOnMeCheck: 1 2)
		(if (== gAct 1)
			(nail init: stopUpd:)
		)
		(if (== gPrevRoomNum 116)
			(= global114 0)
			(= picture 0)
			(DrawPic 240 100 1)
			((ScriptID 895 0) init:) ; pepper
		)
		(if (== gAct 4)
			(richard init: setCycle: Walk setScript: richardPaces)
			(gLongSong number: 244 setLoop: -1 play:)
		else
			((ScriptID 895 1) ; lockjaw
				view: 807
				x: 117
				y: 175
				init:
				normalize:
				approachVerbs: 85 7 6 ; Talk, Do, Look
				approachX: 109
				approachY: 170
				approachDist: 5
				setHeading: 45
				cel: 6
				actions: ljActions
			)
			(hammer init: approachVerbs: 7 stopUpd:) ; Do
			(canvasCover init: stopUpd:)
			(smallCrate init: approachVerbs: 7 6 stopUpd:) ; Do, Look
			(herbs init: stopUpd:)
			(rNail init: approachVerbs: 7 21) ; Do, Hammer
			(lNail init: approachVerbs: 7 21) ; Do, Hammer
			(self setScript: bummedToon)
		)
		(gInventory
			addAfter:
				(gInventory at: 44) ; Wood_Cutting_c
				(Canvas init: yourself:)
				(Hammer init: yourself:)
				(Nails init: yourself:)
				(Tools init: yourself:)
		)
		(if (== gPrevRoomNum 116)
			(self curPic: 240 picture: 240)
		)
		(gGame handsOn:)
	)

	(method (dispose)
		(gInventory delete: Canvas delete: Hammer delete: Nails delete: Tools)
		(super dispose: &rest)
	)
)

(instance sHandOnWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (not local6) (watchMan mover:))
					(= local6 ((watchMan mover:) x:))
				)
				(watchMan
					view: 810
					setCycle: 0
					setMotion: 0
					setLoop: 0
					cel: 0
					forceUpd:
					stopUpd:
				)
				((ScriptID 895 1) normal: 99) ; lockjaw
				(= cycles 3)
			)
			(1
				((ScriptID 895 0) view: 1800 loop: 8 forceUpd: stopUpd:) ; pepper
				(= cycles 3)
			)
			(2
				(gMessager say: 17 7 0 0 self) ; "I'll just see if I can push out a pane of glass..."
			)
			(3
				((ScriptID 895 0) normalize:) ; pepper
				(watchMan cue:)
				(gGame handsOn:)
				((ScriptID 895 1) normal: 1 setScript: (ScriptID 838 0) 0 0) ; lockjaw, LockjawStuff
				(self dispose:)
			)
		)
	)
)

(instance sWatchMan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register 1)
					(= state 2)
					(= register 0)
				)
				(= cycles 2)
			)
			(1
				(watchMan
					view: 815
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 126 128 self
				)
			)
			(2
				(if (not (gCurRoom script:))
					(if (or (== register 2) (not (Random 0 3)))
						(self setScript: sBlaBla self)
					else
						(= cycles 2)
					)
				else
					(= cycles 2)
				)
			)
			(3
				(watchMan
					view: 815
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo 177 128 self
				)
			)
			(4
				(= seconds 3)
			)
			(5
				(watchMan
					view: 815
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 126 128 self
				)
			)
			(6
				(if (not (gCurRoom script:))
					(if (or (== register 2) (not (Random 0 3)))
						(self setScript: sBlaBla self)
					else
						(= cycles 2)
					)
				else
					(= cycles 2)
				)
			)
			(7
				(watchMan
					view: 815
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 45 128 self
				)
			)
			(8
				(self init:)
			)
		)
	)
)

(instance sBlaBla of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(self dispose:)
				else
					(gGame handsOff:)
					(if (and (not (gCurRoom script:)) (gEgo heading:))
						(gEgo setMotion: 0)
						(gEgo setHeading: 0)
						(= ticks 60)
					else
						(= cycles 2)
					)
				)
			)
			(1
				(watchMan view: 810 setLoop: 0 cel: 0 setCycle: 0)
				(= cycles 5)
			)
			(2
				(cond
					(gModelessDialog
						(gGame handsOn:)
						(self dispose:)
					)
					((not (== gAct 4))
						(switch (Random 0 4)
							(0
								(gMessager say: 15 0 28 0 self) ; "You'd better watch your P's and Q's, Missy!"
							)
							(1
								(gMessager say: 15 0 29 0 self) ; "You're gonna be sorry you helped that criminal, young lady!"
							)
							(2
								(gMessager say: 15 0 30 0 self) ; "My eyes are upon you, young lady!"
							)
							(3
								(gMessager say: 15 0 31 0 self) ; "You can't escape the King's justice, you can't!"
							)
							(4
								(gMessager say: 15 0 32 0 self) ; "They'll be comin' to get you soon, they will! Heh heh heh!"
							)
						)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance sHammerNails of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 4)
				(gEgo setMotion: PolyPath 168 142 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(= cycles 2)
			)
			(3
				((ScriptID 2000 3) talkWidth: 130) ; PepperTalker
				(gMessager say: 9 21 0 0 self) ; "I'll just pry these puppies right out of there!"
			)
			(4
				((ScriptID 2000 3) talkWidth: 0) ; PepperTalker
				(gEgo setHeading: 310 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gEgo
					view: 241
					posn: 162 141
					setLoop: 2
					setCel: 0
					setCycle: 0
				)
				(= cycles 2)
			)
			(7
				(gEgo setCycle: CT 2 1 self)
				(gLongSong2 number: 2401 setLoop: 1 play:)
			)
			(8
				(gEgo setCel: 3)
				(gLongSong2 number: 2401 setLoop: 1 play:)
				(nail dispose:)
				(= ticks 20)
			)
			(9
				(gEgo setCel: 2)
				(gLongSong2 number: 2401 setLoop: 1 play:)
				(if (-- register)
					(-= state 2)
				)
				(= ticks 20)
			)
			(10
				(gEgo setCycle: End self)
				(gLongSong2 number: 2401 setLoop: 1 play:)
			)
			(11
				(= ticks 20)
			)
			(12
				(gGame points: 239 2 handsOn:)
				(if (and (gEgo has: 45) (gEgo has: 46))
					(gEgo put: 45 put: 46 get: 48 normalize:)
					(gTheIconBar advanceCurIcon:)
				else
					(gEgo x: 168 y: 142 get: 47 normalize:)
				)
				(= cycles 2)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance sFeelPillow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= (gEgo x:) 159) (!= (gEgo y:) 176))
					(-- state)
					(gEgo setMotion: PolyPath 159 176 self)
				else
					(gEgo setHeading: 125 self)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 13 7 0 0 self) ; "The sack of flour feels nice and soft."
			)
			(3
				(gEgo normalize:)
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 240 2)
				(gEgo setMotion: PolyPath 138 145 self)
				(sWatchMan dispose:)
			)
			(1
				(gEgo
					view: 240
					setLoop: 4
					setCel: 0
					x: 128
					y: 154
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 244
					setLoop: 0
					setCel: 0
					x: 130
					y: 131
					setCycle: CT 5 1 self
				)
			)
			(3
				(gLongSong2 number: 2400 setLoop: 1 play:)
				(gEgo setCycle: CT 7 1 self)
			)
			(4
				(gLongSong2 number: 2400 setLoop: 1 play:)
				(gEgo setCycle: CT 12 1 self)
			)
			(5
				(gLongSong2 number: 2400 setLoop: 1 play:)
				(watchMan
					view: 810
					setCycle: 0
					setMotion: 0
					setLoop: 0
					cel: 0
					forceUpd:
				)
				(gEgo setCycle: End self)
			)
			(6
				(canvasCover
					view: 245
					init:
					loop: 0
					cel: 0
					x: 159
					y: 122
					ignoreActors: 1
					addToPic:
				)
				(watchMan dispose:)
				(= cycles 2)
			)
			(7
				(gEgo
					view: 240
					setLoop: 4
					setCel: 255
					x: 90
					y: 153
					put: 45
					setCycle: Beg self
				)
			)
			(8
				(gEgo put: 48 normalize: x: 81 y: 153)
				(= cycles 2)
			)
			(9
				(gMessager say: 17 156 16 0 self) ; "There! Now that big jerk won't be able to see what I'm doing!"
			)
			(10
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPushBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 68 156 self)
			)
			(1
				(gEgo setHeading: 225 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 8 7 7 0 self) ; "Okay, one...two...THREE!"
			)
			(4
				(gGame points: 242 1)
				(smallCrate hide:)
				(gEgo
					view: 240
					setLoop: 3
					setCel: 0
					setCycle: 0
					x: 55
					y: 177
				)
				(= cycles 2)
			)
			(5
				(digSpot init: approachVerbs: 86 30 6) ; Nose, Paw, Look
				(roomPoly dispose:)
				(gEgo setCycle: End self)
				(gLongSong2 number: 2402 setLoop: 1 play:)
			)
			(6
				(roomPoly
					type: PContainedAccess
					init: 57 148 36 163 68 163 68 176 61 176 61 185 125 185 125 178 213 178 213 148 160 148
					yourself:
				)
				(smallCrate
					show:
					x: 56
					y: 189
					setPri: 13
					ignoreActors: 1
					addToPic:
				)
				(gEgo normalize: x: 59 y: 167)
				(= cycles 2)
			)
			(7
				(client setScript: sPushSmallCrate)
			)
		)
	)
)

(instance sGetHammer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (not local6) (watchMan mover:))
					(= local6 ((watchMan mover:) x:))
				)
				(watchMan
					view: 810
					setCycle: 0
					setMotion: 0
					setLoop: 0
					cel: 0
					forceUpd:
					stopUpd:
				)
				((ScriptID 895 1) normal: 99) ; lockjaw
				(gEgo setMotion: PolyPath 45 176 self)
			)
			(1
				(gEgo view: 1800 loop: 8 setCycle: 0 forceUpd: stopUpd:)
				(= cycles 3)
			)
			(2
				(gMessager say: 18 7 18 0 self) ; "Hey, a hammer! I should pick that up. Mom says you should never go anywhere without one."
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo normalize: loop: 8 cel: 3 heading: 360 setCycle: 0)
				(= cycles 3)
			)
			(5
				(if (and (gEgo has: 47) (gEgo has: 45))
					((ScriptID 895 0) get: 48 put: 45 put: 47 normalize:) ; pepper
					(gTheIconBar advanceCurIcon:)
				else
					(gEgo get: 46 normalize:)
				)
				(if (and (not local6) (watchMan mover:))
					(= local6 ((watchMan mover:) x:))
				)
				(watchMan view: 810 setCycle: 0 setMotion: 0 setLoop: 0 cel: 0)
				(hammer dispose:)
				(= cycles 3)
			)
			(6
				(watchMan stopUpd:)
				((ScriptID 895 0) stopUpd:) ; pepper
				(= cycles 3)
			)
			(7
				(gGame points: 237 1 handsOn:)
				(watchMan cue:)
				((ScriptID 895 1) normal: 1 setScript: (ScriptID 838 0) 0 0) ; lockjaw, LockjawStuff
				(self dispose:)
			)
		)
	)
)

(instance pawPepper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 1) setMotion: MoveTo 128 175 self) ; lockjaw
			)
			(1
				(gMessager say: 10 86 0 0 self) ; "Whiiiiiine!"
			)
			(2
				((ScriptID 895 1) normalize:) ; lockjaw
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToGuard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(not register)
						(!= (gEgo x:) 141)
						(!= (gEgo y:) 145)
					)
					(-- state)
					(gEgo setMotion: PolyPath 141 145 self)
				else
					(gEgo setMotion: 0)
					(watchMan setScript: 0 setMotion: 0 setCycle: 0)
					(cond
						((== (watchMan x:) 128)
							(= ticks 2)
						)
						((< (watchMan x:) 128)
							(watchMan
								setLoop: 2
								setCycle: Walk
								setMotion: MoveTo 126 128 self
							)
						)
						(else
							(watchMan
								setLoop: 3
								setCycle: Walk
								setMotion: MoveTo 126 128 self
							)
						)
					)
					(if (gEgo heading:)
						(gEgo setHeading: 0 self)
					else
						(= cycles 2)
					)
				)
			)
			(1)
			(2
				(watchMan view: 810 setLoop: 0 cel: 0 setCycle: 0)
				(= cycles 5)
			)
			(3
				(switch register
					(1
						(gMessager say: 3 85 3 0 self) ; "Let me out of here, you colonial gorilla!"
					)
					(2
						(gMessager say: 8 7 5 0 self) ; "Pepper decides to try and move the crate."
					)
					(else
						(switch (++ local2)
							(1
								(gMessager say: 20 85 24 0 self) ; "Hey! Let me out of here!"
							)
							(2
								(gMessager say: 20 85 25 0 self) ; "Hey, come on! I haven't done anything!"
							)
							(3
								(gMessager say: 20 85 26 0 self) ; "If you don't let me out, I'll call the embassy! I'm an American citizen!"
							)
							(else
								(gMessager say: 20 85 27 0 self) ; "Let me out! Let me out!"
							)
						)
					)
				)
			)
			(4
				(watchMan setScript: sWatchMan 0 1)
				(gEgo normalize:)
				(= register 0)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance richardPaces of Script
	(properties)

	(method (init)
		(richard setLoop: -1 setCycle: Walk)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(richard setMotion: MoveTo 139 149 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(richard setMotion: MoveTo 77 149 self)
			)
			(3
				(= seconds 2)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance bummedToon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 240 setLoop: -1 play:)
				((ScriptID 895 1) normal: 0) ; lockjaw
				(gEgo setHeading: 225 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 15 7 23 1 3 self) ; "Oh, man, Lockjaw! I can't believe this! Five minutes after we get to colonial America, we're criminals!"
			)
			(3
				((ScriptID 895 0) stopUpd:) ; pepper
				((ScriptID 2004 0) talkWidth: 60) ; LockjawTalker
				(gMessager say: 15 7 23 4 self) ; "Rruf!"
			)
			(4
				(= cycles 2)
			)
			(5
				((ScriptID 895 1) normal: 2) ; lockjaw
				((ScriptID 2004 0) talkWidth: 0) ; LockjawTalker
				(watchMan
					init:
					ignoreActors: 1
					illegalBits: 0
					x: 45
					y: 128
					setLoop: 2
					setScript: sWatchMan
					setScale: 200
				)
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetHerbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (not local6) (watchMan mover:))
					(= local6 ((watchMan mover:) x:))
				)
				(watchMan
					view: 810
					setCycle: 0
					setMotion: 0
					setLoop: 0
					cel: 0
					forceUpd:
					stopUpd:
				)
				((ScriptID 895 1) normal: 0) ; lockjaw
				(gEgo setMotion: PolyPath 222 149 self)
			)
			(1
				(gEgo forceUpd: stopUpd:)
				(= cycles 3)
			)
			(2
				(cond
					((and (not local0) (not local7))
						(++ local7)
						(gMessager say: 7 7 5 0 self) ; "I think I'll just grab those herbs!"
					)
					((and (not local0) (not (IsFlag 57)))
						(gMessager say: 7 7 6 0 self) ; "Pepper had better not risk getting the watchman mad again. He just might come in and get her!"
					)
					((and (not (IsFlag 57)) (not (IsFlag 10)))
						(++ state)
						(= cycles 2)
					)
				)
			)
			(3
				(gGame handsOn:)
				(watchMan cue:)
				((ScriptID 895 1) normal: 1) ; lockjaw
				(self dispose:)
			)
			(4
				(gEgo
					view: 240
					setLoop: 4
					setCel: 0
					posn: 247 140
					setCycle: End self
				)
			)
			(5
				((ScriptID 895 0) ; pepper
					view: 241
					x: 242
					y: 107
					setLoop: 3
					setCel: 0
					setCycle: End self
				)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 7 7 7 0 self) ; "Ha ha! Got 'em!"
			)
			(8
				(gGame points: 241 3)
				(gEgo get: 1) ; Herb_Cluster
				(herbs dispose:)
				(SetFlag 57)
				(= seconds 2)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				((ScriptID 895 0) ; pepper
					view: 240
					x: 247
					y: 140
					setLoop: 4
					setCel: 10
					setCycle: Beg self
				)
			)
			(11
				(gEgo
					x: 222
					y: 149
					normalize:
					setMotion: MoveTo 200 150 self
				)
			)
			(12
				(gGame handsOn:)
				(watchMan cue:)
				((ScriptID 895 1) normal: 1) ; lockjaw
				(self dispose:)
			)
		)
	)
)

(instance sPushSmallCrate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 73 156 self)
			)
			(1
				(gEgo normalize: setMotion: MoveTo 148 173 self)
			)
			(2
				(gEgo setHeading: 225 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 15 0 15 0 self) ; "Well, THAT got me totally nowhere. I'm bummed, Lockjaw. I think I'm gonna take a nap. Wake me up if they decide to hang us or anything."
			)
			(5
				(= local5 (gEgo cycleSpeed:))
				(gEgo
					view: 242
					setLoop: 0
					setCel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(6
				(= ticks 30)
			)
			(7
				(gEgo
					view: 242
					setLoop: 1
					setCel: 0
					setPri: 14
					setCycle: End self
				)
			)
			(8
				(gLongSong number: 247 setLoop: 1 play: self)
			)
			(9
				(gLongSong number: 241 setLoop: -1 play:)
				((ScriptID 895 0) actions: pepperActions cycleSpeed: local5) ; pepper
				((ScriptID 895 1) normal: 0) ; lockjaw
				(gGame setEgo: (ScriptID 895 1)) ; lockjaw
				(= cycles 2)
			)
			(10
				((ScriptID 895 1) ; lockjaw
					normalize:
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 114 170 self
				)
			)
			(11
				(gGame handsOn:)
				((ScriptID 895 0) stopUpd:) ; pepper
				(SetCursor 100 0)
				(self dispose:)
			)
		)
	)
)

(instance sDigTunnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 55 164 self)
			)
			(1
				(= local5 (gEgo cycleSpeed:))
				(gEgo
					view: 242
					setLoop: 3
					setCel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(gLongSong2 number: 903 setLoop: -1 play:)
			)
			(2
				((ScriptID 895 1) setCycle: CycleBet 7 2 2 self) ; lockjaw
			)
			(3
				(gLongSong2 stop:)
				(gMessager say: 14 30 0 1 self) ; "Lockjaw digs like a beast! Lockjaw IS a beast!"
			)
			(4
				(hole init: addToPic:)
				(= cycles 2)
			)
			(5
				((ScriptID 895 1) ; lockjaw
					cycleSpeed: local5
					normalize:
					setMotion: MoveTo 87 144 self
				)
			)
			(6
				(gEgo setHeading: 225 self)
			)
			(7
				((ScriptID 895 1) approachX: 85 approachY: 156 normal: 1) ; lockjaw
				(= cycles 2)
			)
			(8
				(gGame setEgo: (ScriptID 895 0)) ; pepper
				((ScriptID 895 0) actions: 0) ; pepper
				((ScriptID 895 1) ignoreActors: 0) ; lockjaw
				(= cycles 2)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(gEgo normalize:)
				(roomPoly dispose:)
				(= cycles 2)
			)
			(11
				(gMessager say: 14 30 0 2 self) ; "Wha--? Oh!"
			)
			(12
				(roomPoly
					type: PContainedAccess
					init: 61 145 47 154 89 154 60 176 23 176 23 185 87 185 87 172 213 172 213 145 199 145 199 138 153 138 153 145
					yourself:
				)
				(gEgo setMotion: MoveTo 100 165 self)
			)
			(13
				(= cycles 2)
			)
			(14
				(gMessager say: 14 30 0 3 self) ; "Good boy! Smart boy!"
			)
			(15
				(gGame handsOn:)
				(SetCursor 100 -1)
				(self dispose:)
			)
		)
	)
)

(instance sEscape of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 462 1)
				(gLongSong fade:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) setMotion: MoveTo 50 163 self) ; pepper
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 22 7 0 0 self) ; "C'mon, boy! We're getting out of here!"
			)
			(4
				(gLongSong number: 243 setLoop: 1 play:)
				((ScriptID 895 0) ; pepper
					view: 242
					setLoop: 4
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(5
				((ScriptID 895 1) ; lockjaw
					normalize:
					normal: 0
					setMotion:
						MoveTo
						(digSpot approachX:)
						(digSpot approachY:)
						self
				)
			)
			(6
				(= seconds 2)
			)
			(7
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance sGetCanvas of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (not local6) (watchMan mover:))
					(= local6 ((watchMan mover:) x:))
				)
				(watchMan
					view: 810
					setCycle: 0
					setMotion: 0
					setLoop: 0
					cel: 0
					forceUpd:
					stopUpd:
				)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 200 140 self
				)
				((ScriptID 895 1) normal: 99) ; lockjaw
			)
			(1
				(gEgo view: 1800 loop: 8 setCycle: 0 forceUpd: stopUpd:)
				(= cycles 3)
			)
			(2
				(gMessager say: 2 7 18 0 self) ; "I wonder if I could use this canvas for something..."
			)
			(3
				(= cycles 2)
			)
			(4
				(if (and (not local1) (not (IsFlag 10)))
					(= local1 1)
					(gEgo view: 241 setLoop: 0 setCel: 0 setCycle: 0)
					(canvasCover dispose:)
					(= cycles 2)
				else
					(gGame handsOn:)
					(gEgo normalize:)
					(watchMan cue:)
					((ScriptID 895 1) normal: 1 setScript: (ScriptID 838 0) 0 0) ; lockjaw, LockjawStuff
					(self dispose:)
				)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(if (and (gEgo has: 46) (gEgo has: 47))
					((ScriptID 895 0) ; pepper
						normalize:
						loop: 8
						cel: 2
						get: 48
						put: 46
						put: 47
					)
					(gTheIconBar advanceCurIcon:)
				else
					((ScriptID 895 0) normalize: loop: 8 cel: 2 get: 45) ; pepper
				)
				(= cycles 3)
			)
			(7
				(watchMan stopUpd:)
				((ScriptID 895 0) stopUpd:) ; pepper
				(= cycles 2)
			)
			(8
				(gEgo normalize:)
				(= cycles 2)
			)
			(9
				(gGame points: 238 1 handsOn:)
				(watchMan cue:)
				((ScriptID 895 1) normal: 1 setScript: (ScriptID 838 0) 0 0) ; lockjaw, LockjawStuff
				(self dispose:)
			)
		)
	)
)

(instance sGiveLoveLetters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 246 2)
				((ScriptID 895 0) setMotion: PolyPath 174 154 self) ; pepper
			)
			(1
				(richardPaces dispose:)
				(richard setMotion: 0 setLoop: 0)
				(gMessager say: 11 118 0 1 2 self) ; "I found these...around. I have a sneaking feeling they might interest you."
			)
			(2
				(richard
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 139 149 self
				)
			)
			(3
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 5
					setCel: 0
					setCycle: End self
				)
				(gLongSong number: 248 setLoop: -1 play:)
			)
			(4
				(richard view: 247 setLoop: 0 setCycle: CT 5 1 self)
				((ScriptID 895 0) setCycle: Beg) ; pepper
			)
			(5
				(gMessager say: 11 118 0 3 self) ; "Oh! Ben's love letters! Where did you get these? Oh, my..."
			)
			(6
				(richard setCycle: End self)
			)
			(7
				(gMessager say: 11 118 0 4 8 self) ; "Oh, Ben! My, but that scoundrel can write!"
			)
			(8
				(gEgo put: 30) ; Love_Letters
				(= cycles 1)
			)
			(9
				(gEgo normalize:)
				(richard
					view: 830
					setLoop: -1
					setCycle: Walk
					setScript: richardPaces
				)
				(gLongSong number: 244 setLoop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cYaLater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: MoveTo 205 140 self) ; pepper
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 3 7 4 0 self) ; "Leave if you want to, lad. I'm not going with you. Not back to HIM!"
			)
			(3
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance sGiveCarpetBag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 247 1)
				((ScriptID 895 0) setMotion: PolyPath 174 154 self) ; pepper
			)
			(1
				(richardPaces dispose:)
				(richard setMotion: 0 setCycle: 0)
				((ScriptID 895 0) ; pepper
					view: 243
					setLoop: 1
					setCel: 0
					setCycle: End self
				)
				(gLongSong number: 246 setLoop: 1 play:)
			)
			(2
				(richard
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo 139 149 self
				)
			)
			(3
				(if (IsFlag 246)
					(gMessager say: 11 113 9 0 self) ; "Oh, but I don't see why they would detain YOU, Mrs. Franklin!"
				else
					(gMessager say: 11 113 10 0 self) ; "I've uncovered your secret! Thought you could fool a reporter, eh? You're really Deborah Franklin in disguise!"
				)
			)
			(4
				(if (IsFlag 246)
					((ScriptID 895 0) put: 31 normalize:) ; pepper, Carpet_Bag
					(= cycles 1)
				else
					(self cue:)
				)
			)
			(5
				(if (IsFlag 246)
					(gCurRoom newRoom: 213)
				else
					(richard setCycle: Walk setScript: richardPaces)
					(gEgo normalize:)
					(= cycles 2)
				)
			)
			(6
				(gLongSong number: 244 setLoop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gabWithRichard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (== (self register:) 88))
					(gGame points: 245 1)
				)
				(gGame handsOff:)
				(++ local3)
				(richardPaces dispose:)
				(richard setMotion: 0)
				(= ticks 10)
			)
			(1
				(richard
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 139 149 self
				)
			)
			(2
				(richard setLoop: 2 setCel: 1)
				(= cycles 2)
			)
			(3
				(switch register
					(7
						(gMessager say: 11 7 0 0 self) ; "If you touch me, lad, I'll smack you so hard you'll see the Saints!"
					)
					(85
						(switch local3
							(1
								(gMessager say: 11 85 12 0 self) ; "I've come to get you out of here!"
							)
							(2
								(gMessager say: 11 85 13 0 self) ; "Please, you have to come with me! It's important!"
							)
							(else
								(gMessager say: 11 85 13 0 self) ; "Please, you have to come with me! It's important!"
							)
						)
					)
					(64
						(gMessager say: 11 64 0 0 self) ; "Look, Mr. Richard! Read this letter! It PROVES that the Pughs are cheating this colony out of tax money!"
					)
					(88
						(gMessager say: 11 19 0 0 self) ; "I've no time for your nonsense, boy! Go away!"
					)
				)
			)
			(4
				(gGame handsOn:)
				(richard setScript: richardPaces)
				(self dispose:)
			)
		)
	)
)

(instance richard of Actor
	(properties
		x 93
		y 146
		noun 11
		view 830
	)

	(method (cue)
		(self setScript: richardPaces)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (IsFlag 247)
					(gMessager say: 11 6 21) ; "Pepper has to admit, Deborah made a convincing Poor Richard."
				else
					(gMessager say: 11 6 20) ; "It's Poor Richard. He seems VERY upset."
				)
				(return 1)
			)
			(85 ; Talk
				(self setScript: gabWithRichard 0 85)
				(return 1)
			)
			(67 ; Love_Letters
				(gCurRoom setScript: sGiveLoveLetters)
				(return 1)
			)
			((OneOf theVerb 68 69) ; Carpet_Bag [closed], Carpet_Bag [opened]
				(gCurRoom setScript: sGiveCarpetBag)
				(return 1)
			)
			(7 ; Do
				(gCurRoom setScript: gabWithRichard 0 7)
				(return 1)
			)
			(64 ; King_s_Letter
				(gCurRoom setScript: gabWithRichard 0 64)
				(return 1)
			)
			((OneOf theVerb 84 85 7 6 86 30 89) ; Trivia, Talk, Do, Look, Nose, Paw, Teeth
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom setScript: gabWithRichard 0 88)
				(return 1)
			)
		)
	)
)

(instance watchMan of Actor
	(properties
		noun 20
		modNum 240
		view 815
		loop 2
		priority 2
		signal 26640
		illegalBits 0
	)

	(method (cue &tmp temp0)
		(self startUpd:)
		(if local6
			(if (> local6 x)
				(= temp0 2)
			else
				(= temp0 3)
			)
			(self
				view: 815
				setCycle: Walk
				setLoop: temp0
				setMotion: MoveTo local6 y script
			)
			(= local6 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(gCurRoom setScript: sTalkToGuard 0 0)
			)
			(7 ; Do
				(gMessager say: 20 7 0 0 self) ; "Pepper doesn't want to touch the watchman. She thinks he's a creep."
			)
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance canvasCover of View
	(properties
		x 291
		y 140
		noun 2
		modNum 240
		view 246
		signal 18433
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (== gEgo (ScriptID 895 0)) ; pepper
					(gMessager say: 2 6 18) ; "It's a big piece of canvas."
				else
					(gMessager say: 2 6 1) ; "Lockjaw admires Pepper's skill with a hammer and nails."
				)
			)
			(7 ; Do
				(if local0
					(gMessager say: 2 7 33) ; "Pepper just got the window covered up! She doesn't want to uncover it again."
				else
					(gCurRoom setScript: sGetCanvas)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance nail of View
	(properties
		x 148
		y 117
		view 245
		loop 1
	)
)

(instance smallCrate of View
	(properties
		x 70
		y 170
		noun 8
		approachX 73
		approachY 156
		view 246
		cel 4
		priority 12
		signal 18449
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 44)
		(switch theVerb
			(84 ; Trivia
				(if
					(and
						(not (IsFlag 240))
						(not (gEgo has: 46))
						(not (gEgo has: 48))
					)
					(self noun: 18)
					(super doVerb: theVerb)
				else
					(self noun: 8)
					(super doVerb: theVerb)
				)
			)
			(6 ; Look
				(if
					(and
						(not (IsFlag 240))
						(not (gEgo has: 46))
						(not (gEgo has: 48))
					)
					(gMessager say: 18 6 18) ; "It's a hammer."
				else
					(gMessager say: 8 6) ; "The crate has a label that says "Herbs for the Treatment of |r||c0|Gout|c||r|"."
				)
			)
			(7 ; Do
				(cond
					(
						(and
							(not (gEgo has: 46))
							(not (gEgo has: 48))
							(not local0)
						)
						(gCurRoom setScript: sGetHammer)
					)
					((and (not local4) (not local0))
						(= local4 1)
						(gCurRoom setScript: sTalkToGuard 0 2)
					)
					((and local4 (not local0))
						(gMessager say: 8 7 6) ; "Pepper had better not make the watchman any madder. She might need to sit down sometime."
					)
					((gFeatures contains: digSpot)
						(gMessager say: 8 7 8) ; "Pepper has no reason to move the crate again."
					)
					(else
						(gCurRoom setScript: sPushBox)
					)
				)
			)
			(22 ; ???
				(gMessager say: 8 21) ; "Pepper doesn't want the herbs."
			)
			(85 ; Talk
				(gMessager say: 8 85 5) ; "That crate doesn't look TOO heavy..."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hole of View
	(properties
		x 25
		y 149
		noun 22
		view 246
		cel 6
		signal 18448
	)
)

(instance herbs of View
	(properties
		x 256
		y 68
		noun 7
		view 246
		cel 1
		priority 3
		signal 18448
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 44)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: sGetHerbs)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hammer of View
	(properties
		x 41
		y 242
		z 100
		noun 18
		approachX 35
		approachY 170
		view 246
		cel 5
		priority 12
		signal 18448
	)

	(method (doVerb theVerb)
		(smallCrate doVerb: theVerb)
	)
)

(instance bigCrate of Feature
	(properties
		x 248
		y 122
		noun 4
		nsTop 99
		nsLeft 217
		nsBottom 145
		nsRight 280
	)
)

(instance eastCrates of Feature
	(properties
		y 110
		noun 4
	)
)

(instance westCrates of Feature
	(properties
		x 11
		y 130
		noun 16
		nsTop 88
		nsBottom 173
		nsRight 23
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 44)
		(super doVerb: theVerb)
	)
)

(instance barrel of Feature
	(properties
		y 170
		noun 1
	)
)

(instance floor of Feature
	(properties
		y 50
		noun 5
	)
)

(instance theWindow of Feature
	(properties
		x 116
		y 1
		z -100
		noun 17
		modNum 240
		nsTop 55
		nsLeft 68
		nsBottom 128
		nsRight 165
		approachX 123
		approachY 151
	)

	(method (doVerb theVerb)
		(switch theVerb
			(156 ; Tools
				(gCurRoom setScript: sClimbBox)
			)
			(85 ; Talk
				(if (== gAct 4)
					(gMessager say: 17 85) ; "Nice view, but I wanna go home!"
				else
					(gMessager say: 17 85 3) ; "Hey! Let me out of here!"
				)
			)
			(21 ; Hammer
				(gMessager say: 17 21) ; "Pepper COULD smash the window, but the watchman would just grab her anyway."
			)
			(7 ; Do
				(if (== gAct 4)
					(gMessager say: 17 7 39) ; "Pepper doesn't need any more panes. She has General Pugh and Ima."
				else
					(gCurRoom setScript: sHandOnWindow)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lNail of Feature
	(properties
		x 78
		y 219
		z 100
		noun 9
		nsTop 110
		nsLeft 70
		nsBottom 125
		nsRight 85
		approachX 76
		approachY 145
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 9 6 18) ; "Some nails are sticking up out of the wood."
			)
			(7 ; Do
				(gMessager say: 9 7 18) ; "Pepper's hands aren't strong enough to pull the nails out of the wood."
			)
			(21 ; Hammer
				(rNail doVerb: 21)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rNail of Feature
	(properties
		x 150
		y 219
		z 100
		noun 9
		nsTop 110
		nsLeft 140
		nsBottom 129
		nsRight 160
		approachX 154
		approachY 146
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 9 6 18) ; "Some nails are sticking up out of the wood."
			)
			(7 ; Do
				(gMessager say: 9 7 18) ; "Pepper's hands aren't strong enough to pull the nails out of the wood."
			)
			(21 ; Hammer
				(if (gEgo has: 47)
					(gMessager say: 19 7) ; "Pepper already has the hammer and the nails."
				else
					(gCurRoom setScript: sHammerNails)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pillow of Feature
	(properties
		x 170
		y 168
		noun 13
		nsTop 148
		nsLeft 133
		nsBottom 189
		nsRight 208
		approachX 163
		approachY 173
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; Do
			(gCurRoom setScript: sFeelPillow)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance boxByWindow of Feature
	(properties
		x 114
		y 126
		noun 6
		nsTop 109
		nsLeft 78
		nsBottom 143
		nsRight 150
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 64)
		(switch theVerb
			(7 ; Do
				(if (and (gEgo has: 47) (gEgo has: 45))
					(gCurRoom setScript: sClimbBox)
				else
					(gMessager say: 6 7) ; "There's no way Pepper could EVER move that crate."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Feature
	(properties
		x 203
		y 97
		noun 3
		modNum 240
		nsTop 57
		nsLeft 174
		nsBottom 137
		nsRight 232
		approachX 172
		approachY 147
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(cond
					((gCast contains: richard)
						(gCurRoom setScript: cYaLater)
					)
					((gCast contains: watchMan)
						(gCurRoom setScript: sTalkToGuard 0 0)
					)
					(else
						(gMessager say: 3 7 3) ; "The door is firmly bolted."
					)
				)
			)
			(85 ; Talk
				(if (and (gCast contains: watchMan) (not (== gAct 4)))
					(gCurRoom setScript: sTalkToGuard 0 1)
				else
					(super doVerb: theVerb)
				)
			)
			(84 ; Trivia
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance herbFeat of Feature
	(properties
		x 271
		y 32
		noun 21
		nsLeft 223
		nsBottom 65
		nsRight 319
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 44)
		(super doVerb: theVerb)
	)
)

(instance leftHerbs of Feature
	(properties
		x 36
		y 41
		noun 21
		nsBottom 83
		nsRight 72
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 44)
		(super doVerb: theVerb)
	)
)

(instance digSpot of Feature
	(properties
		x 48
		y 159
		noun 14
		nsTop 149
		nsLeft 26
		nsBottom 170
		nsRight 70
		sightAngle 40
		approachX 61
		approachY 161
		_approachVerbs 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(cond
					((gCast contains: richard)
						(gMessager say: 14 6 14) ; "It looks like they've filled in Lockjaw's tunnel. They won't let Pepper get away with that one twice!"
					)
					((IsFlag 244)
						(gMessager say: 22 6) ; "Lockjaw dug a tunnel under the shed wall!"
					)
					((== gEgo (ScriptID 895 0)) ; pepper
						(gMessager say: 14 6 2) ; "The dirt that was under the crate is darker than the rest. It's probably a little damp."
					)
					(else
						(gMessager say: 14 6 1) ; "The dirt under the crate looks very tempting!"
					)
				)
			)
			(7 ; Do
				(cond
					((gCast contains: richard)
						(gMessager say: 14 7 14) ; "The dirt is packed down even harder than it was before. There's no way Pepper can dig through this!"
					)
					((not (IsFlag 244))
						(gMessager say: 14 7) ; "This dirt is softer than the rest, but still too hard for Pepper to dig."
					)
				)
				(gCurRoom setScript: sEscape)
			)
			(86 ; Nose
				(gGame points: 243 2)
				(gCurRoom setScript: (ScriptID 875 4) 0 @local8) ; smell
			)
			(30 ; Paw
				(gGame points: 244 3)
				(gCurRoom setScript: sDigTunnel)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance watchManTalker of BalloonTalker
	(properties
		x 0
		y 93
		talkWidth 150
	)

	(method (init)
		(if (>= (watchMan x:) 164)
			(= x 10)
			(= tailPosn 1)
		else
			(= x (+ (watchMan x:) 5))
			(= tailPosn 0)
		)
		(if (and (not local6) (watchMan mover:))
			(= local6 ((watchMan mover:) x:))
		)
		(watchMan setMotion: 0 setCycle: 0)
		(super init: &rest)
	)

	(method (say)
		(watchMan stopUpd:)
		(super say: &rest)
	)
)

(instance poorRichardTalker of BalloonTalker
	(properties
		x 130
		y 100
		talkWidth 150
	)

	(method (init)
		(= x (richard x:))
		(= y (richard y:))
		(self posnBalloon: richard)
		(super init: &rest)
	)

	(method (posnBalloon param1 &tmp temp0 temp1 temp2 temp3)
		(= x (param1 x:))
		(= y (param1 y:))
		(SetNowSeen param1)
		(= temp0 (param1 nsTop:))
		(= temp1 (param1 nsLeft:))
		(= temp2 (param1 nsBottom:))
		(= temp3 (param1 nsRight:))
		(cond
			((<= x 130)
				(if (<= y 90)
					(= x (- temp3 5))
					(= y (+ temp2 30))
					(= tailPosn 3)
				else
					(= x (- temp3 5))
					(= y (+ temp0 10))
					(= tailPosn 0)
				)
			)
			((<= x 175)
				(if (<= y 90)
					(= x (- temp3 5))
					(= y (+ temp2 30))
					(= tailPosn 3)
				else
					(= x (- temp3 5))
					(= y (+ temp0 10))
					(= tailPosn 0)
				)
			)
			((<= y 90)
				(= x (- temp1 130))
				(= y (+ temp2 30))
				(= tailPosn 4)
			)
			(else
				(= x (- temp1 130))
				(= y (+ temp0 10))
				(= tailPosn 1)
			)
		)
	)
)

(instance Canvas of TWInvItem
	(properties
		loop 1
		cel 2
		message 20
		signal 2
		noun 2
		modNum 240
	)
)

(instance Hammer of TWInvItem
	(properties
		loop 1
		cel 3
		message 21
		signal 2
		noun 18
		modNum 240
	)
)

(instance Nails of TWInvItem
	(properties
		loop 1
		cel 4
		message 154
		signal 2
		noun 9
		modNum 240
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Hammer
				(gMessager say: 9 7) ; "Pepper already has the nails."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Tools of TWInvItem
	(properties
		loop 9
		message 156
		signal 2
		noun 25
		modNum 240
	)
)

(instance pepperActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; Paw
				(gCurRoom setScript: pawPepper)
				(return 1)
			)
			(86 ; Nose
				(gCurRoom setScript: (ScriptID 875 4) 0 @local17) ; smell
				(return 1)
			)
			(34 ; Fleas
				(gMessager say: 10 34) ; "Lockjaw doesn't want to give Pepper any fleas. For some reason, she doesn't seem to like them."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ljActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(if (IsFlag 244)
					(gMessager say: 23 85 36) ; "Good job, Lockjaw-boy! You're such a smart dog!"
				else
					(gMessager say: 23 85 35) ; "We've got to get out of here, boy!"
				)
			)
			(6 ; Look
				(gMessager say: 23 6) ; "Lockjaw doesn't look very upset about all this."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance roomPoly of Polygon
	(properties)
)

