;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Interface)
(use Waters)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm022 0
)

(local
	[local0 21] = [76 132 80 113 145 80 189 145 80 210 135 80 224 128 80 65 111 80 240 120 80]
	[local21 8] = [0 183 38 182 42 189 0 189]
	[local29 10] = [0 177 52 178 87 169 77 159 0 159]
	[local39 10] = [0 125 64 130 79 140 8 140 0 135]
	[local49 26] = [319 170 294 181 214 173 182 169 167 153 238 143 242 136 214 135 159 152 156 143 151 124 155 0 319 0]
	[local75 22] = [131 139 125 151 93 147 94 139 81 136 76 130 61 126 0 122 0 0 148 0 136 126]
	[local97 12] = [136 130 143 124 143 95 154 146 144 151 131 147]
)

(instance rm022 of Rm
	(properties
		picture 22
		north 23
		east 21
		south 26
		west 24
	)

	(method (init)
		(super init:)
		(proc0_24 128 2 7 797)
		(self
			setFeatures: crevasse bridge witchHouse pathWay thisRoom
			addObstacle: poly1 poly2 poly4 poly5 poly6 poly7
			setRegions: 200 551 ; witchRegion, toadRegion
		)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 5 185 view: 2 init:)
			)
			(south
				(gEgo posn: 149 187 view: 2 init:)
			)
			(north
				(gEgo view: 4 setLoop: 2 init: hide: posn: 148 105)
				((gEgo head:) hide:)
				(HandsOff)
				(self setScript: walkInFromNorth)
			)
			(208 ; releaseGenie
				(gEgo posn: global110 global111 view: 2 init:)
				(NormalEgo 0 2)
			)
			(else
				(gEgo posn: 315 185 view: 2 init:)
			)
		)
		(if (== global81 3)
			(water init:)
		)
		(gEgo setStep: 2 2 offset: 2)
		(if (== ((gInventory at: 6) owner:) 200) ; Brass_Bottle
			(gEgo ignoreControl: 16)
		else
			(gEgo observeControl: 16)
		)
		(poly1 points: @local21 size: 4)
		(poly2 points: @local29 size: 5)
		(poly4 points: @local39 size: 5)
		(poly5 points: @local49 size: 13)
		(poly6 points: @local75 size: 11)
		(poly7 points: @local97 size: 6)
		(door init:)
	)

	(method (doit &tmp temp0)
		(if (== ((gInventory at: 6) owner:) 200) ; Brass_Bottle
			(gEgo ignoreControl: 16)
		)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 1) $2000)
				(HandsOff)
				(self setScript: dying)
			)
			((and (& (gEgo onControl: 0) $0200) (== (gEgo view:) 2))
				(HandsOff)
				(self setScript: getSmall)
			)
			((and (== (gEgo view:) 4) (gEgo mover:))
				(HandsOff)
				(self setScript: getBigScript)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gEgo setStep: 3 2)
				((ScriptID 200 1) register: temp0) ; poofOutScript
				(self setScript: (ScriptID 200 1) 0 (gEgo edgeHit:)) ; poofOutScript
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(DisposeScript 401)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gEgo illegalBits: -32768)
		(super newRoom: newRoomNumber)
		(gGlobalSound fade:)
	)
)

(instance doorLocked of Code
	(properties)

	(method (doit)
		(PrintDC 22 0) ; "Sorry, the door is locked."
		(gEgo normal: 1 view: 4 setLoop: -1 setCycle: Walk cycleSpeed: 0)
		((gEgo head:) show:)
		(HandsOn)
		(self dispose:)
	)
)

(instance getSmall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 7
					normal: 0
					setLoop: 0
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5)
					setCycle: End self
				)
				((gEgo head:) hide:)
			)
			(1
				(if (IsFlag 96)
					(doorLocked doit:)
					(self dispose:)
					(return)
				)
				(if
					(and
						(not (IsFlag 101))
						(== global100 0)
						(== (Random 1 4) 1)
					)
					(if
						((ScriptID 754) ; CPCheck
							doit:
								{The door to the witch's house has an enchantment on it and can't be opened.__Use Crispin's wand to break the spell.}
						)
						(SetFlag 94)
						(SetFlag 101)
						(= cycles 1)
					else
						(SetFlag 96)
						(doorLocked doit:)
						(self dispose:)
					)
					(DisposeScript 754)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					view: 4
					normal: 1
					setLoop: 3
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 148 112 self
				)
				((gEgo head:) show:)
			)
			(3
				(door cycleSpeed: 2 setCycle: End self)
				(gGlobalSound3 number: 122 vol: 50 loop: 1 play:)
			)
			(4
				(gEgo
					view: 4
					normal: 1
					setLoop: 3
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 148 105 self
				)
			)
			(5
				(gEgo setLoop: -1 hide:)
				((gEgo head:) hide:)
				(door setCycle: Beg self)
				(gGlobalSound3 number: 124 vol: 50 loop: 1 play:)
			)
			(6
				(HandsOn)
				(gCurRoom newRoom: 23)
			)
		)
	)
)

(instance walkInFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(door
					init:
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
				(gGlobalSound3 number: 122 vol: 50 loop: 1 play:)
			)
			(2
				(gEgo
					show:
					normal: 1
					offset: 2
					setLoop: -1
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 144 107 self
				)
				((gEgo head:) show:)
			)
			(3
				(door setPri: -1 setCycle: Beg self)
				(gGlobalSound3 number: 124 vol: 50 loop: 1 play:)
			)
			(4
				(client setScript: getBigScript)
			)
		)
	)
)

(instance getBigScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 136 129 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					view: 7
					normal: 0
					cel: 0
					setLoop: 1
					setCycle: End self
					setMotion: MoveTo 130 140 self
				)
			)
			(2)
			(3
				(gEgo
					view: 2
					normal: 1
					offset: 2
					setLoop: -1
					cycleSpeed: 0
					setCycle: Walk
				)
				((gEgo head:) show:)
				(gEgo loop: 7 cel: 2)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance dying of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 797
					cycleSpeed: 2
					normal: 0
					cel: 0
					setLoop: 0
					setMotion: 0
					setPri: 8
					illegalBits: 0
					setCycle: End self
				)
				((gEgo head:) hide:)
				(gGlobalSound3 number: 83 loop: 1 vol: 127 priority: 15 play:)
			)
			(1
				(gEgo dispose:)
				(= seconds 3)
			)
			(2
				(= global330 {Gotta watch those drop-offs, Graham!})
				(EgoDead 248)
			)
		)
	)
)

(instance water of Waters
	(properties
		view 436
		priority 1
		signal 16400
		cycleSpeed 1
	)

	(method (getLoop)
		(= x [local0 pos])
		(= y [local0 (++ pos)])
		(= cel [local0 (++ pos)])
	)

	(method (saveLoop)
		(= [local0 pos] cel)
		(++ pos)
	)
)

(instance witchHouse of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 22 1) ; "A crude, misshapen structure, which seems to be some sort of house, sits forlornly; surrounded by a hot, deep crevasse."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bridge of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 22 2) ; "A grotesque bridge of rib-like bones crosses the hot crevasse where a path continues to the front door of the odd little house."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance pathWay of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $1000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 22 3) ; "The path seems to dwindle down to nothing as it nears the strange structure."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance crevasse of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 22 4) ; "Spewing hot steam and flames, a deep crevasse surrounds the strange little house."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 103
		x 154
		view 434
		signal 16384
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 22 5) ; "A small door fronts the odd structure."
					(event claimed: 1)
				)
				(3 ; Do
					(if (== ((gInventory at: 6) owner:) 200) ; Brass_Bottle
						(HandsOff)
						(gEgo illegalBits: 0 setMotion: PolyPath 145 124)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance thisRoom of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 22 6) ; "The dark forest seems to encase the witch's bizarre little house like a claustrophobic shroud."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly5 of Polygon
	(properties)
)

(instance poly6 of Polygon
	(properties)
)

(instance poly7 of Polygon
	(properties
		type PBarredAccess
	)
)

