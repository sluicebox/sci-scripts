;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use System)

(public
	rm053 0
)

(local
	local0
	[local1 16] = [76 189 128 168 77 163 59 153 43 136 43 0 0 0 0 189]
	[local17 20] = [137 183 115 183 136 166 117 162 111 156 86 156 61 148 62 0 164 0 169 153]
)

(instance rm053 of Rm
	(properties
		picture 53
		horizon 145
		north 54
		south 52
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 834 loop: -1 vol: 127 play:)
		(if (not (IsFlag 56))
			(= global320 159)
			(= global321 109)
			(self setRegions: 202) ; owl
			(= global325 {"Come on, Graham! This place gives me the shivers!"})
		)
		(self
			setFeatures: chasm stairWay aCastle path1 path2 path3
			obstacles: polyListTop
		)
		(switch gPrevRoomNum
			(north
				(gEgo view: 2 observeControl: 16384 posn: 57 146)
				(= local0 1)
				(global322 view: 138 loop: 2 cel: 0 cycleSpeed: 3 setCycle: End)
			)
			(else
				(gEgo
					view: 0
					ignoreControl: 16384
					setPri: 15
					setStep: 3 2
					posn: 156 185
				)
				(= local0 0)
				(if (not (IsFlag 56))
					(self setScript: (ScriptID 202 1)) ; stdWalkIn
					(if (not (IsFlag 99))
						(gEgo setScript: conversation)
					)
				)
			)
		)
		(gEgo init:)
		(poly1 points: @local1 size: 8)
		(poly2 points: @local17 size: 10)
		(polyListTop add: poly1 poly2)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(if (not (IsFlag 56))
					((ScriptID 202 2) register: (gEgo edgeHit:)) ; stdWalkOut
					(self setScript: (ScriptID 202 2)) ; stdWalkOut
				else
					(gCurRoom newRoom: temp0)
				)
			)
			((and (& (gEgo onControl: 0) $0080) (!= (gEgo view:) 9))
				(self setScript: goingUp)
			)
			((and (& (gEgo onControl: 0) $0100) (!= (gEgo view:) 9))
				(self setScript: goingDown)
			)
			((& (gEgo onControl: 0) $0400)
				(gEgo setPri: 15 ignoreControl: 16384)
				(= local0 0)
			)
			((and (& (gEgo onControl: 0) $2000) (== local0 1))
				(HandsOff)
				(self setScript: fallBottom)
			)
			((& (gEgo onControl: 0) $0002)
				(= local0 1)
				(gEgo setPri: -1 observeControl: 16384)
			)
			((and (& (gEgo onControl: 0) $1000) (== local0 0))
				(HandsOff)
				(self setScript: fallTop)
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
		(polyListTop dispose:)
		(gEgo ignoreControl: 16384)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 52)
			(gGlobalSound fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fallTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 56))
					(Say 75 53 0 67 20 20 25 3) ; "No, don't...!"
				)
				(= cycles 1)
			)
			(1
				(gGlobalSound3 number: 60 loop: 1 vol: 127 play:)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 68
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
					setPri: 13
					illegalBits: 0
				)
			)
			(2
				(gEgo yStep: 8 setMotion: MoveTo (gEgo x:) 230 self)
			)
			(3
				(= seconds 3)
			)
			(4
				(= global330 {That last step was a doozy!})
				(EgoDead)
			)
		)
	)
)

(instance fallBottom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 56))
					(Say 75 53 0 67 20 20 25 3) ; "No, don't...!"
				)
				(= cycles 1)
			)
			(1
				(gGlobalSound3 number: 60 loop: 1 vol: 127 play:)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 70
					setLoop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
					setPri: 13
					illegalBits: 0
				)
			)
			(2
				(gEgo yStep: 8 setMotion: MoveTo (gEgo x:) 230 self)
			)
			(3
				(= seconds 3)
			)
			(4
				(= global330 {That last step was a doozy!})
				(EgoDead)
			)
		)
	)
)

(instance goingDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 9
					setLoop: 1
					cel: 0
					setCycle: End self
					setMotion: PolyPath 131 164 self
				)
			)
			(1
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 2
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 123 166 self
				)
			)
			(2
				(gEgo signal: 8194 setMotion: MoveTo 103 160 self)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance goingUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 123 169 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 9
					setLoop: 0
					cel: 0
					setCycle: End self
					setMotion: PolyPath 101 188 self
				)
			)
			(2
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 98 186 self
				)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance conversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
				(SetFlag 99)
			)
			(1
				(Say 75 53 1 67 10 10 25 6) ; "Well, it looks like there's n-n-no way in. Let's turn back."
				(Say 160 53 2 67 100 10 25 6) ; "Come ON, Cedric!"
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance chasm of RFeature
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
					(PrintDC 53 3) ; "A wide chasm separates the narrow trail from the castle's massive front gate. Graham ponders the situation but can't find a way to solve it."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 53 4) ; "The chasm between the trail and the front gate of the castle is too wide to jump across. Graham will have to find another way to enter the castle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance stairWay of RFeature
	(properties
		nsTop 168
		nsLeft 90
		nsBottom 181
		nsRight 124
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
					(PrintDC 53 5) ; "Graham notices a small stairway leading down to another trail which winds around the left side of Mordack's castle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance aCastle of RFeature
	(properties
		nsLeft 77
		nsBottom 124
		nsRight 319
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
					(PrintDC 53 6) ; "The strange castle, so close now, intimidates Graham as it towers threateningly before him."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance path1 of RFeature
	(properties
		nsTop 141
		nsLeft 44
		nsBottom 166
		nsRight 138
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
					(PrintDC 53 5) ; "Graham notices a small stairway leading down to another trail which winds around the left side of Mordack's castle."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 53 4) ; "The chasm between the trail and the front gate of the castle is too wide to jump across. Graham will have to find another way to enter the castle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance path2 of RFeature
	(properties
		nsTop 150
		nsLeft 157
		nsBottom 189
		nsRight 319
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
					(PrintDC 53 3) ; "A wide chasm separates the narrow trail from the castle's massive front gate. Graham ponders the situation but can't find a way to solve it."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 53 4) ; "The chasm between the trail and the front gate of the castle is too wide to jump across. Graham will have to find another way to enter the castle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance path3 of RFeature
	(properties
		nsTop 114
		nsLeft 168
		nsBottom 131
		nsRight 273
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
					(PrintDC 53 3) ; "A wide chasm separates the narrow trail from the castle's massive front gate. Graham ponders the situation but can't find a way to solve it."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 53 4) ; "The chasm between the trail and the front gate of the castle is too wide to jump across. Graham will have to find another way to enter the castle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance polyListTop of List
	(properties)
)

(instance poly1 of Polygon
	(properties
		type PTotalAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

