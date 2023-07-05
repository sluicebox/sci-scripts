;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 304)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene38e 0
)

(local
	local0
)

(instance Clarence of Prop
	(properties)
)

(instance Torso of Prop
	(properties)
)

(instance Eyes of Prop
	(properties)
)

(instance Mouth of Prop
	(properties)
)

(instance Hand of Act
	(properties)
)

(instance myMusic of Sound
	(properties)
)

(instance scene38e of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(Load rsFONT 41)
		(LoadMany rsMESSAGE 406)
		(Load rsVIEW 642)
		(LoadMany rsSOUND 29 94 95 96)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(Clarence view: 415 loop: 0 cel: 0 posn: 103 86 setPri: 1 init:)
		(Torso
			view: 415
			loop: 1
			cel: 0
			posn: 103 107
			setPri: 1
			ignoreActors: 1
			init:
		)
		(Eyes
			view: 415
			loop: 2
			cel: 0
			posn: 99 67
			setPri: 2
			setScript: ClarsEyes
			init:
		)
		(Mouth view: 415 loop: 6 cel: 0 posn: 99 85 setPri: 2 init: hide:)
		(Hand
			view: 415
			setLoop: 7
			setCel: 0
			setPri: 3
			yStep: 5
			posn: 71 142
			init:
			hide:
		)
		(self setScript: twice)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance twice of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0008))
						(|= gMustDos $0008)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(Print 304 0 #width 230 #dispose) ; "It's only Clarence sitting alone at the bar."
				(Hand show: setMotion: MoveTo 93 120 self)
			)
			(2
				(Eyes hide:)
				(Clarence startUpd: setCycle: End)
				(Hand setCycle: End setMotion: MoveTo 95 108 self)
			)
			(3
				(Hand stopUpd:)
				(Mouth show: setCycle: Fwd)
				(= cycles 4)
			)
			(4
				(Mouth hide:)
				(Clarence setCycle: Beg)
				(Hand setCycle: Beg setMotion: MoveTo 93 120 self)
			)
			(5
				(Eyes show:)
				(Clarence stopUpd:)
				(Hand setMotion: MoveTo 71 142 self)
			)
			(6
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance ClarsEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Eyes cel: (^ (Eyes cel:) $0001) forceUpd:)
				(= state -1)
				(if (Eyes cel:)
					(Eyes loop: (Random 2 5))
					(= cycles 2)
				else
					(= seconds (Random 1 3))
				)
			)
		)
	)
)

