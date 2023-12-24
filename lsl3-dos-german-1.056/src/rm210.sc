;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm210 0
)

(local
	[string 600]
)

(procedure (PrintPlot &tmp t)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		10
		5
		#width
		290
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 3 (LangSwitch t t (+ t t) (+ t t))))
)

(instance rm210 of Rm
	(properties
		picture 210
		south 220
	)

	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(cond
			((not (TestFlag 19))
				(Load rsVIEW 53)
			)
			((not (TestFlag 20))
				(Load rsVIEW 53)
			)
			((not (TestFlag 25))
				(Load rsVIEW (LangSwitch 212 903))
				(aCredit1 view: (LangSwitch 212 903) init:)
				(aCredit2 init:)
			)
		)
		(if (InRoom 3)
			(Load rsVIEW 709)
			(aWood init:)
		)
		(cond
			((== gPrevRoomNum 200)
				(gEgo posn: 317 126 loop: 1)
			)
			((== gPrevRoomNum 216)
				(gEgo posn: 2 163)
			)
			((== gPrevRoomNum 213)
				(gEgo posn: 2 175)
			)
			(else
				(gEgo posn: 317 175)
			)
		)
		(NormalEgo)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (gEgo edgeHit:)
			(cond
				((& (gEgo onControl:) $0008)
					(gCurRoom newRoom: 200)
				)
				((& (gEgo onControl:) $0004)
					(gCurRoom newRoom: 216)
				)
				((& (gEgo onControl:) $0010)
					(gCurRoom newRoom: 220)
				)
				((& (gEgo onControl:) $0002)
					(gCurRoom newRoom: 213)
				)
			)
		)
	)

	(method (handleEvent event &tmp i)
		(if
			(and
				(not (super handleEvent: event))
				(not (event claimed:))
				gModelessDialog
				(== (event message:) KEY_RETURN)
				(== (event type:) evKEYBOARD)
			)
			(event claimed: 1)
			(cls)
			(self cue:)
		)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look,look>')
			(if (Said '/palm')
				(Printf ; "The granadilla is short and graceful, with a gray trunk, and delicately spreading branches.%s%"
					210
					0
					(if (InRoom 3)
						{ Beneath its outstretched boughs lies a beautiful piece of wood, probably cut by a native then forgotten.}
					else
						{}
					)
					(if (InRoom 3)
						{Unter seinen ausgestreckten Zweigen liegt ein h\81bsches Holzst\81ck, das sicher von einem Eingeborenen abges\84gt und dann vergessen wurde.}
					else
						{}
					)
				)
			)
			(if (and (InRoom 3) (Said '/drop,stick,granadilla'))
				(Print 210 1) ; "Beneath the granadilla lies a beautiful piece of wood."
			)
			(if (Said '[/area]')
				(Print 210 2) ; "The native corporation (Natives, Inc.) has done an excellent job of preserving the environment of the jungle, at least in this location! A beautiful, specimen granadilla tree grows here."
			)
		)
		(if (Said 'get,get/granadilla')
			(cond
				((!= gEgoState 0)
					(NotNow) ; "Good idea. You might try that again later."
				)
				((not (InRoom 3))
					(Print 210 3) ; "There is no wood lying around here."
				)
				((not (& (gEgo onControl:) $0040))
					(Print 210 4) ; "Move over until you are beside the small tree with the gray trunk in the lower right-hand corner of the scene."
				)
				(else
					(self changeState: 4)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not (TestFlag 19))
						(= cycles 30)
					)
					((not (TestFlag 20))
						(= cycles 20)
						(++ state)
					)
				)
			)
			(1
				(Format @string 210 5) ; "The villagers were wise to retain total financial and political control of their island. For example, they've never allowed vehicular traffic anywhere. Everyone walks wherever they go.%"
				(= seconds (PrintPlot))
			)
			(2
				(SetFlag 19) ; beenIn210
				(if (not (TestFlag 20))
					(aCredit1
						view: 53
						posn: 0 121
						setCycle: Fwd
						cycleSpeed: 1
						ignoreActors:
						init:
						setPri: 12
					)
					(Format @string 210 6) ; "Up this path lies your home. Your beloved Kalalau is probably there right now, waiting patiently for your return....%"
					(= seconds (PrintPlot))
				)
			)
			(3
				(aCredit1 dispose:)
				(= seconds 0)
			)
			(4
				(= cycles (= seconds 0))
				(Ok) ; "O.K."
				(HandsOff)
				(if (< (gEgo x:) (aWood x:))
					(gEgo
						illegalBits: 0
						setMotion: MoveTo (- (aWood x:) 19) (gEgo y:) self
					)
				else
					(gEgo
						illegalBits: 0
						setMotion: MoveTo (+ (aWood x:) 19) (gEgo y:) self
					)
				)
			)
			(5
				(gEgo
					view: 709
					loop: (> (gEgo x:) (aWood x:))
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(6
				(aWood hide:)
				(gEgo get: 3 setCycle: Beg self) ; Granadilla_Wood
			)
			(7
				(NormalEgo)
				(gGame changeScore: 2)
				(Print 210 7) ; "You take the beautiful chunk of granadilla wood from beneath the tree."
			)
		)
	)
)

(instance aWood of View
	(properties
		y 161
		x 223
		view 210
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 288
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		y 154
		x 288
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 212 903))
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(aCredit1 setCycle: End)
				(= cycles 16)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 22)
			)
			(3
				(SetFlag 25) ; sawCredits210
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)

