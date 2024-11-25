;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm007 0
)

(local
	[local0 16] = [144 149 0 149 0 0 202 0 206 63 266 76 76 98 163 134]
	[local16 14] = [319 129 162 124 95 101 288 78 218 61 219 0 319 0]
	[local30 8] = [319 189 152 189 211 169 319 156]
	[local38 10] = [0 168 99 168 96 181 74 189 0 189]
)

(instance rm007 of KQ5Room
	(properties
		picture 7
		horizon 75
		north 8
		east 2
		south 6
		west 10
	)

	(method (init)
		(super init:)
		(= global320 181)
		(= global321 35)
		(gEgo normal: 1 setStep: 3 2 view: 0 illegalBits: $8000)
		(= global325
			{"You can see there's nothing here, Graham!"}
		)
		(gGlobalSound number: 24 loop: -1 play:)
		(if (and (not (IsFlag 26)) (!= ((gInventory at: 9) owner:) 9)) ; Heart
			(SetFlag 26)
			(gGlobalSound2 number: 26 loop: 1 play:)
			(prince init: stopUpd:)
		)
		(self setFeatures: bath path7 room setRegions: 202) ; owl
		(switch gPrevRoomNum
			(west
				(gEgo posn: 2 148)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(east
				(gEgo posn: 286 131)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(north
				(gEgo view: 2 setStep: 2 1 posn: 265 77)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(south
				(gEgo posn: 120 186)
				(self setScript: (ScriptID 202 1)) ; stdWalkIn
			)
			(else
				(gEgo posn: 120 186)
			)
		)
		(gEgo setCycle: KQ5SyncWalk init:)
		(bird setCycle: Fwd init:)
		(poly1 points: @local0 size: 8)
		(poly2 points: @local16 size: 7)
		(poly3 points: @local30 size: 4)
		(poly4 points: @local38 size: 5)
		(self addObstacle: poly1 poly2 poly3 poly4)
	)

	(method (doit &tmp temp0)
		(cond
			((& (gEgo onControl: 1) $2000)
				(gEgo view: 0 setStep: 3 2)
			)
			((& (gEgo onControl: 1) $4000)
				(gEgo view: 2 setStep: 2 1)
			)
		)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
				(self setScript: (ScriptID 202 2)) ; stdWalkOut
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

	(method (newRoom newRoomNumber)
		(gGlobalSound2 fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance birdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bird z: 0 x: 108 y: 85 setLoop: 11 cycleSpeed: 0 setCycle: Fwd)
				(= cycles 20)
			)
			(1
				(bird x: 105 setLoop: 12 setCycle: End self)
			)
			(2
				(bird
					setLoop: 9
					cycleSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo -20 72 self
				)
			)
			(3
				(bird dispose:)
				(self dispose:)
			)
		)
	)
)

(instance princeLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 259 145 self)
			)
			(1
				(proc0_7 gEgo prince 5)
				((gEgo head:) moveHead: 0 cel: 6)
				(= cycles 3)
			)
			(2
				(proc0_28 160 7 0 67 10 90 25 4) ; "Excuse me, young man."
				(prince cycleSpeed: 2 setCycle: CT 2 1 self)
			)
			(3
				(prince setLoop: 4 cel: 0 setCycle: End self)
			)
			(4
				(proc0_28 160 7 1 67 10 85 25 8) ; "Sorry to bother you, but I couldn't help but notice you sitting there on that log. I was wondering if there was anything wrong."
				(RedrawCast)
				(proc0_28 163 7 2 67 10 10 25 10) ; "Why, yes...as a matter of fact, there is. I've been searching everywhere for my fiancee. She's a beautiful princess with long golden tresses, fetching blue eyes, and smooth, creamy skin. Have you seen her anywhere about?"
				(RedrawCast)
				(proc0_28 160 7 3 67 10 90 25 4) ; "No, sorry. I haven't seen anyone like that."
				(RedrawCast)
				(proc0_28 163 7 4 67 10 10 25 8) ; "That's what I figured. No one has seen her. I think that old witch who lives in the Dark Forest had something to do with her disappearance."
				(RedrawCast)
				(proc0_28 160 7 5 67 10 90 25 8) ; "I'll keep an eye out for her. If I see her I'll let her know you're looking for her."
				(RedrawCast)
				(proc0_28 163 7 6 67 10 10 25 12) ; "I would appreciate that. Well, I guess I'd better get back to looking for her. I'm not ever going to find her just sitting around here. Thanks for your concern."
				(RedrawCast)
				(prince
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 340 (prince y:) self
				)
				((gEgo head:) moveHead: 1)
			)
			(5
				(gGlobalSound2 fade:)
				(HandsOn)
				(prince dispose:)
				(client setScript: 0)
			)
		)
	)
)

(instance path7 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 7 7) ; "Graham feels the eyes of many creatures upon him as he follows a meandering path through the thick wood."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bath of RFeature
	(properties
		nsTop 68
		nsLeft 87
		nsBottom 95
		nsRight 128
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 7 8) ; "In a nearby tree trunk, an old wound has created a perfect birdbath."
					(event claimed: 1)
				)
				(3 ; Do
					(if (!= (bird x:) 108)
						(PrintDC 7 9) ; "There's nothing here but a little water."
						(event claimed: 1)
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance prince of Actor
	(properties
		x 237
		y 123
		view 146
		loop 3
	)

	(method (handleEvent event)
		(cond
			((and (MousedOn global322 event) (== (event message:) 5)) ; Talk
				(proc0_28 75 7 10) ; "Let's say 'hello' to the young prince, Graham. He looks like he could use a cheering up."
				(event claimed: 1)
			)
			(
				(or
					(event claimed:)
					(not (== (event type:) evVERB))
					(not (MousedOn self event))
				)
				(return)
			)
			(else
				(switch (event message:)
					(2 ; Look
						(PrintDC 7 11) ; "Upon a fallen log sits a dashing young prince who looks very sad and confused."
						(event claimed: 1)
					)
					(3 ; Do
						(PrintDC 7 12) ; "Despite his own troubles, Graham feels sorry for the young man who obviously has troubles of his own."
						(event claimed: 1)
					)
					(5 ; Talk
						(HandsOff)
						(gCurRoom setScript: princeLeave)
						(event claimed: 1)
					)
					(4 ; Inventory
						(if (!= (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
							(PrintDC 7 13) ; "The young prince is too despondent over something to even notice it."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance bird of Actor
	(properties
		x 108
		y 135
		z 55
		view 146
		loop 8
		priority 10
		signal 24592
		cycleSpeed 2
		detailLevel 3
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(> (gGame detailLevel:) 0)
				(not script)
				(< (gEgo distanceTo: self) 30)
			)
			(self setScript: birdScript)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 7 14) ; "What a wonderful bluebird. It could almost make Graham happy again if it wasn't for his family."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 7 15) ; "Graham could never catch the bird."
					(event claimed: 1)
				)
				(5 ; Talk
					(PrintDC 7 16) ; "The bluebird is too busy taking a bath to answer Graham."
					(event claimed: 1)
				)
				(4 ; Inventory
					(if (!= (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
						(PrintDC 7 17) ; "The bluebird doesn't care about it."
						(event claimed: 1)
					)
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

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 7 7) ; "Graham feels the eyes of many creatures upon him as he follows a meandering path through the thick wood."
					(event claimed: 1)
				)
			)
		)
	)
)

