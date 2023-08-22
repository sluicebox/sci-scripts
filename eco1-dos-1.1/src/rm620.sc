;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm620 0
)

(instance rm620 of EcoRoom
	(properties
		lookStr 15
		picture 620
		style -32761
		horizon 48
		north 344
		east 580
		walkOffTop 1
	)

	(method (init)
		(= global250 1)
		(= global251 1)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 63 319 350 -50 350 -50 187 248 187 281 167 294 115 240 133 210 117 235 107 305 107 305 103 226 103 194 107 161 91 165 76 199 73 208 -10 319 -10
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 219 135 181 177 63 155 64 129 103 79 112 100 184 141
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 244 168 239 184 214 184 202 176 222 160
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(NormalEgo)
		(gEgo init: ignoreHorizon: 1)
		(switch gPrevRoomNum
			(north
				(= style 9)
				(self setScript: fromWhale)
			)
			(else
				(self setScript: outOfShip)
			)
		)
		(plant1 setCycle: Fwd init:)
		(plant2 setCycle: Fwd init:)
		(plant3 setCycle: Fwd init:)
		(if (not (gEgo has: 30)) ; hackSaw
			(saw init:)
		)
		(gFeatures
			add:
				propeller
				propShaft
				skidMarks
				doorway
				cabin
				deck
				boat
				purplePlant
				coralCave
				greenPlant
				bulwinklePlant
				distantCoral
				distantWaters
				harpoons
			eachElementDo: #init
		)
		(super init: &rest)
		(if (not (IsFlag 341))
			(gAddToPics add: cable eachElementDo: #init doit:)
		)
		(if (not (IsFlag 85))
			(plant1 setScript: whaleSoundScript)
		)
		(if (!= (gLongSong number:) 420)
			(gLongSong number: 420 loop: -1 play:)
		)
	)

	(method (doit)
		(if (> gHowFast 0)
			(Palette palANIMATE 34 42 7)
		)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_TOP)
				(if (not (IsFlag 124))
					(self setScript: goingToCetus)
				else
					0
				)
			)
			(
				(and
					(gEgo inRect: 225 104 236 109)
					(< 35 (gEgo heading:) 145)
				)
				(self setScript: intoShip)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(self setScript: stayAndHelp)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(gEgo z: 0)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance fromWhale of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo z: 30 posn: 100 -4 setMotion: PolyPath 156 106 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance goingToCetus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Narrator init: 1 0 0 39 self) ; "Adam holds his breath with anticipation and swims up to investigate."
			)
			(1
				(gEgo
					ignoreHorizon: 1
					setMotion: MoveTo (gEgo x:) -40 self
				)
			)
			(2
				(gCurRoom newRoom: 344)
			)
		)
	)
)

(instance outOfShip of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 7 posn: 279 82 setMotion: MoveTo 166 76 self)
			)
			(1
				(gEgo z: 30 y: 106 setPri: -1)
				(if (not (IsFlag 85))
					(Narrator init: 1 0 0 32 self) ; "The whale call is louder here. It's echoing down from somewhere above the ship."
				else
					(= cycles 1)
				)
			)
			(2
				(if (not (IsFlag 132))
					(gEgo setScript: whaleCalling)
				)
				(self dispose:)
			)
		)
	)
)

(instance whaleCalling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(= state -1)
				(Narrator init: 1 0 0 38 self) ; "The whale call continues to echo from somewhere above the ship."
			)
		)
	)
)

(instance intoShip of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 7 setMotion: MoveTo 279 112 self)
			)
			(1
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance whaleSoundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(whaleSound loop: 1 play: self)
			)
			(1
				(= state -1)
				(= seconds 8)
			)
		)
	)
)

(instance whaleSound of Sound
	(properties
		number 647
	)
)

(instance stayAndHelp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Narrator init: 1 0 0 16 self) ; "There's nothing of interest over there. Besides, Adam is too concerned about Delphineus to go off very far right now."
			)
			(1
				(= temp0 (GetAngle (gEgo x:) (gEgo y:) 160 90))
				(gEgo setHeading: temp0 self)
			)
			(2
				(gEgo setMotion: MoveFwd 20 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cable of PicView
	(properties
		x 239
		y 14
		lookStr 4
		view 620
		loop 3
		priority 10
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 5) ; "Whatever's on the other end of that cable is too big for Adam to haul in from here."
			)
			(4 ; Inventory
				(switch invItem
					(30 ; hackSaw
						(Narrator init: 1 0 0 6) ; "The steel cable is too strong for Adam to cut through - even with that hacksaw."
					)
					(13 ; sharpShell
						(Narrator init: 1 0 0 7) ; "That shell is sharp but it would NEVER cut through that cable."
					)
					(else
						(Narrator init: 1 0 0 8) ; "That won't do anything to the cable. Perhaps Adam had better try to deal with the cable at its other end."
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 31) ; "Unfortunately, the cable cannot just be thrown away. Adam will have to think of something else."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant1 of Prop
	(properties
		x 24
		y 69
		lookStr 9
		view 620
		loop 1
		signal 16384
		cycleSpeed 20
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 10) ; "Adam doesn't want to pull up those living sea plants."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant2 of Prop
	(properties
		x 90
		y 41
		lookStr 9
		view 620
		signal 16384
		cycleSpeed 23
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 10) ; "Adam doesn't want to pull up those living sea plants."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant3 of Prop
	(properties
		x 222
		y 179
		lookStr 9
		view 620
		loop 2
		signal 16384
		cycleSpeed 26
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 10) ; "Adam doesn't want to pull up those living sea plants."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance propeller of Feature
	(properties
		onMeCheck 16384
		lookStr 19
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (OneOf theVerb 3 4 10) ; Do, Inventory, Recycle
			(Narrator init: 1 0 0 18) ; "The propellers don't interest Adam now. He's too worried about Delphineus."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance propShaft of Feature
	(properties
		onMeCheck 8192
		lookStr 19
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance skidMarks of Feature
	(properties
		onMeCheck 4096
		lookStr 33
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance doorway of Feature
	(properties
		onMeCheck 2048
		lookStr 34
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 13) ; "Just swim there."
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 29) ; "The ship is too large to be thrown away!"
			)
			(4 ; Inventory
				(Narrator init: 1 0 0 27) ; "The whaling vessel is sunk and no longer of concern. Adam doesn't need to do anything with the ship."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cabin of Feature
	(properties
		onMeCheck 1024
		lookStr 12
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 13) ; "Just swim there."
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 29) ; "The ship is too large to be thrown away!"
			)
			(4 ; Inventory
				(Narrator init: 1 0 0 27) ; "The whaling vessel is sunk and no longer of concern. Adam doesn't need to do anything with the ship."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deck of Feature
	(properties
		onMeCheck 512
		lookStr 11
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 1 0 0 29) ; "The ship is too large to be thrown away!"
			)
			(4 ; Inventory
				(Narrator init: 1 0 0 27) ; "The whaling vessel is sunk and no longer of concern. Adam doesn't need to do anything with the ship."
			)
			(3 ; Do
				(Narrator init: 1 0 0 14) ; "The whaling ship is long past any hope of rescue or navigation."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boat of Feature
	(properties
		onMeCheck 256
		lookStr 17
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 14) ; "The whaling ship is long past any hope of rescue or navigation."
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 29) ; "The ship is too large to be thrown away!"
			)
			(4 ; Inventory
				(Narrator init: 1 0 0 27) ; "The whaling vessel is sunk and no longer of concern. Adam doesn't need to do anything with the ship."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance purplePlant of Feature
	(properties
		onMeCheck 128
		lookStr 2
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 3) ; "The tube coral is fragile and should be left alone."
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 28) ; "The living creatures and plants in the sea have a RIGHT to be here. The garbage bag is for human litter."
			)
			(4 ; Inventory
				(Narrator init: 1 0 0 3) ; "The tube coral is fragile and should be left alone."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance coralCave of Feature
	(properties
		onMeCheck 64
		lookStr 25
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 1 0 0 28) ; "The living creatures and plants in the sea have a RIGHT to be here. The garbage bag is for human litter."
			)
			(4 ; Inventory
				(Narrator init: 1 0 0 24) ; "Adam shouldn't try to mess with the coral. It's very fragile."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance greenPlant of Feature
	(properties
		onMeCheck 32
		lookStr 9
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Narrator init: 1 0 0 9) ; "Tall plants wave lazily in the underwater currents."
			)
			(3 ; Do
				(Narrator init: 1 0 0 10) ; "Adam doesn't want to pull up those living sea plants."
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 28) ; "The living creatures and plants in the sea have a RIGHT to be here. The garbage bag is for human litter."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bulwinklePlant of Feature
	(properties
		onMeCheck 16
		lookStr 25
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 1) ; "There's no way Adam can free the ship from the coral."
			)
			(4 ; Inventory
				(Narrator init: 1 0 0 24) ; "Adam shouldn't try to mess with the coral. It's very fragile."
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 28) ; "The living creatures and plants in the sea have a RIGHT to be here. The garbage bag is for human litter."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance distantCoral of Feature
	(properties
		onMeCheck 8
		lookStr 35
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (== theVerb 3) ; Do
			(Narrator init: 1 0 0 16) ; "There's nothing of interest over there. Besides, Adam is too concerned about Delphineus to go off very far right now."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance distantWaters of Feature
	(properties
		onMeCheck 4
		lookStr 36
	)

	(method (doVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(super doVerb: &rest)
	)
)

(instance harpoons of Feature
	(properties
		x 202
		y 67
		onMeCheck 2
		approachX 155
		approachY 85
	)

	(method (init)
		(self approachVerbs: 2) ; Look
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 1 0 0 22 store: 21) ; "There's a rack of harpoons on the cabin wall. One appears to be missing."
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 30) ; "The harpoons are no longer a threat to any living thing and they are too dangerous to carry around in Adam's recycle sack."
			)
			(3 ; Do
				(Narrator init: 1 0 0 23) ; "Adam doesn't want anything to do with those harpoons!"
			)
			(4 ; Inventory
				(if (== invItem 30) ; hackSaw
					(Narrator init: 1 0 0 20) ; "There's no reason for Adam to use the saw to cut apart the harpoons on the boat. Fortunately, they are not a danger to any fish anymore."
				else
					(Narrator init: 1 0 0 26) ; "There's nothing Adam needs to do with that harpoon rack."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance saw of View
	(properties
		x 142
		y 94
		approachX 157
		approachY 85
		lookStr 40
		view 620
		loop 4
		priority 2
		signal 16401
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 42) ; "Adam picks up the hacksaw and sees that, while slightly rusty, it is still very sharp."
				(gEgo get: 30) ; hackSaw
				(SetScore 1 317)
				(self dispose:)
			)
			(10 ; Recycle
				(Narrator init: 1 0 0 41) ; "Adam might need the hacksaw."
			)
			(4 ; Inventory
				(Narrator init: 1 0 0 43) ; "Adam can't do that to the hacksaw."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

