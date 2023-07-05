;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 652)
(include sci.sh)
(use Main)
(use AudioScript)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)

(public
	cdIntro3 0
)

(local
	[local0 2]
)

(instance cdIntro3 of Rm
	(properties
		picture 68
	)

	(method (init)
		(Load rsPIC 68)
		(super init:)
		(LoadMany rsVIEW 748 757 760 2)
		(Load rsSYNC 10103)
		(User canInput: 0 controls: 0)
		(gEgo view: 2 moveSpeed: 2 posn: -9 162 init:)
		(owl posn: -20 -15 init:)
		(self setScript: sceneThreeScript setRegions: 769) ; introtoonRegion
	)
)

(instance sceneThreeScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 44 162 self)
			)
			(1
				(audioTrak init: hide: play: 10103 653)
				((gEgo head:) hide:)
				(gEgo
					view: 748
					normal: 0
					cel: 0
					cycleSpeed: 2
					setLoop: 0
					setCycle: End self
				)
				(= waitForCue 784)
			)
			(2
				(= waitForCue 800)
			)
			(3
				(cls)
				(owl setCycle: Fwd setMotion: MoveTo 22 95 self)
			)
			(4
				(owl setCycle: End self)
			)
			(5
				(owl
					view: 757
					setLoop: 0
					setCycle: End
					setMotion: MoveTo 25 100 self
				)
			)
			(6
				(= waitForCue 816)
			)
			(7
				(= waitForCue 832)
			)
			(8
				(gEgo cel: 0 setLoop: 1 cycleSpeed: 1 setCycle: End self)
			)
			(9
				(gEgo setLoop: 2 setCycle: End self)
			)
			(10
				(= waitForCue 848)
			)
			(11
				(= waitForCue 864)
			)
		)
	)
)

(instance syncIt of Prop ; UNUSED
	(properties)
)

(instance owl of Actor
	(properties
		view 760
		loop 2
		signal 2048
	)
)

(instance audioTrak of MonoAudioProp
	(properties)
)

