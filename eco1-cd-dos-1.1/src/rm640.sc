;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use eRS)
(use n819)
(use EcoFeature)
(use Talker)
(use Osc)
(use MoveFwd)
(use LoadMany)
(use Motion)
(use User)
(use System)

(public
	rm640 0
)

(local
	local0
)

(instance rm640 of EcoRoom
	(properties
		picture 640
		style 10
		horizon 15
		south 344
		lookStr 5
	)

	(method (init)
		(LoadMany rsVIEW 641 642)
		(= global250 2)
		(NormalEgo)
		(gEgo init: ignoreActors: ignoreHorizon:)
		(fin init:)
		(lfin init:)
		(whaleMouth init:)
		(whale init:)
		(topOfWhale init:)
		(if (not (IsFlag 96))
			(cable init:)
		)
		(if (IsFlag 85)
			(eye init:)
		)
		(if (IsFlag 90)
			(self setScript: bounceBack)
		else
			(self setScript: comeFromWhale)
		)
		(self setRegions: 51) ; bubblesRegion
		(super init: &rest)
		(gLongSong2 stop:)
		(if
			(or
				(not (OneOf (gLongSong number:) 640 644))
				(== (gLongSong prevSignal:) -1)
			)
			(gLongSong number: 640 loop: -1 play:)
		)
		(Animate (gCast elements:) 0)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (< ((User curEvent:) y:) 70)
					(EcoNarrator init: 2 0 0 5) ; "Dappled light plays across the whale's body. He struggles to remain close to the surface so that he can breathe. However, in his weakened condition, he's bound to lose the struggle soon."
				else
					(EcoNarrator init: 2 0 0 8) ; "Adam is swimming in front of King Cetus. The noble whale has been chained to a sunken whaling vessel by means of a harpoon in his jaw. He strains to keep his blowhole near the surface so that he can breathe."
				)
			)
			(2 ; Talk
				(EcoNarrator init: 2 0 0 21) ; "Adam can't talk to the water."
			)
			(6 ; Recycle
				(EcoNarrator init: 2 0 0 20) ; "This is no time to be concerned with recycling."
			)
			(4 ; Do
				(EcoNarrator init: 2 0 0 18) ; "Adam can't do anything with the water."
			)
			(44 ; Inventory
				(EcoNarrator init: 2 0 0 18) ; "Adam can't do anything with the water."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 209 224 -7)
		(Palette palANIMATE 193 208 -6)
		(Palette palANIMATE 161 192 -6)
		(cond
			(script 0)
			((== (gEgo edgeHit:) 1)
				(self setScript: NoExit)
			)
			((OneOf (gEgo edgeHit:) 4 2)
				(self setScript: stayAndHelp)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(IsFlag 85)
				(not (IsFlag 87))
				(not (IsFlag 140))
				(== newRoomNumber 660)
			)
			(if local0
				(SetFlag 83)
			else
				(whaleMouth setCycle: 0 cel: 5)
				(Animate (gCast elements:) 0)
				(SetFlag 130)
				(SetFlag 90)
			)
		)
		(if (== newRoomNumber south)
			(if (not (IsFlag 85))
				(SetFlag 140)
			)
			(gLongSong fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance bounceBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setCycle: 0
					posn: 221 88
					view: 644
					setLoop: 0
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 197 114 self
				)
			)
			(1
				(gEgo setCycle: CT 2 1 self)
			)
			(2
				(ClearFlag 90)
				(NormalEgo 3)
				(gEgo posn: 200 117 ignoreHorizon:)
				(= cycles 3)
			)
			(3
				(cond
					((not (SetFlag 128))
						((ScriptID 2 1) init: 1 0 0 10 1 self) ; Adam, "IT'S CETUS!!!"
					)
					((IsFlag 130)
						(EcoNarrator init: 2 0 0 11 self) ; "Adam will have to time his approach to the mouth more carefully if he's to get inside."
						(ClearFlag 130)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance comeFromWhale of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: 0
					view: 641
					setLoop: 5
					cel: 0
					posn: 230 82
					setMotion: MoveTo 201 111 self
				)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(NormalEgo 2)
				(gEgo posn: 200 117 setHeading: 0 self ignoreHorizon:)
			)
			(3
				(= cycles 2)
			)
			(4
				(cond
					((IsFlag 140)
						(ClearFlag 140)
						(= cycles 1)
					)
					((not (SetFlag 129))
						(EcoNarrator init: 2 0 0 10 self) ; "From here, Adam can see that unconscious Cetus' jaw has grown slack. His mouth opens and closes in a regular rhythm."
					)
					((IsFlag 131)
						(ClearFlag 131)
						(EcoNarrator init: 2 0 0 24 self) ; "Though Adam has removed the harpoon head, the harpoon shaft is still lodged in the wound."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance mouthScript of Script
	(properties)

	(method (init)
		(= start 3)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(whaleMouth setCycle: CT 2 1 self)
			)
			(1
				(= local0 0)
				(whaleMouth setCycle: End self)
			)
			(2
				(= cycles (whaleMouth cycleSpeed:))
			)
			(3
				(= local0 1)
				(whaleMouth setCycle: Beg self)
			)
			(4
				(= state -1)
				(= cycles (whaleMouth cycleSpeed:))
			)
		)
	)
)

(instance goToWhaleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= start 0)
				(gEgo setCycle: Walk setMotion: MoveTo 200 117 self)
			)
			(1
				(gEgo
					view: 641
					setLoop: 0
					cel: 0
					cycleSpeed: 7
					posn: 210 99
					setCycle: End self
				)
			)
			(2
				(if (IsFlag 85)
					(= cycles 1)
				else
					(gEgo hide:)
					(= cycles 5)
				)
			)
			(3
				(gCurRoom newRoom: 660)
			)
		)
	)
)

(instance NoExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(EcoNarrator init: 2 0 0 22 self) ; "There's nothing Adam can do for Cetus on the ocean's surface."
			)
			(1
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gCurRoom horizon:) 5) self
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stayAndHelp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(EcoNarrator init: 2 0 0 23 self) ; "There's nothing Adam can do for Cetus over there."
			)
			(1
				(Face gEgo 160 (gEgo y:) self)
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

(instance eye of EcoView
	(properties
		x 221
		y 70
		onMeCheck 0
		view 642
		loop 2
		signal 16401
	)
)

(instance fin of EcoProp
	(properties
		x 155
		y 68
		view 642
		loop 1
		signal 16400
		cycleSpeed 20
		detailLevel 1
	)

	(method (init)
		(self setCycle: Osc)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(whale doVerb: theVerb &rest)
	)
)

(instance lfin of EcoProp
	(properties
		x 204
		y 94
		view 642
		loop 5
		signal 16400
		cycleSpeed 20
		detailLevel 1
	)

	(method (init)
		(self setCycle: Osc)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(whale doVerb: theVerb &rest)
	)
)

(instance whaleMouth of EcoProp
	(properties
		x 216
		y 77
		view 642
		cel 5
		signal 16400
		cycleSpeed 25
	)

	(method (init)
		(super init: &rest)
		(if (and (IsFlag 85) (not (IsFlag 86)))
			(self setScript: mouthScript)
		else
			(self stopUpd:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 86)
						(EcoNarrator init: 2 0 0 25) ; "Now that the head of the harpoon has been removed, Cetus' mouth is closed."
					)
					((IsFlag 85)
						(EcoNarrator init: 2 0 0 7) ; "The whale's massive jaw is slack. The current opens and shuts the mouth in a regular rhythm."
					)
					(else
						(EcoNarrator init: 2 0 0 14) ; "Cetus' mouth is closed."
					)
				)
			)
			(4 ; Do
				(if (and (IsFlag 85) (not (IsFlag 86)))
					(goToWhaleScript start: -1)
					(gCurRoom setScript: goToWhaleScript)
					(EcoNarrator init: 2 0 0 12 goToWhaleScript) ; "Adam decides to make a dash for Cetus' moving mouth."
				else
					(whale doVerb: theVerb &rest)
				)
			)
			(else
				(whale doVerb: theVerb &rest)
			)
		)
	)
)

(instance whale of EcoFeature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 85)
					(EcoNarrator init: 2 0 0 6) ; "Cetus floats, an apparently lifeless weight. Adam detects slight contractions of his blowhole. The whale is weakening rapidly."
				else
					(EcoNarrator init: 2 0 0 3) ; "The mighty Cetus floats helplessly near the ocean's surface. He is terribly still."
				)
			)
			(4 ; Do
				(goToWhaleScript start: -1)
				(gCurRoom setScript: goToWhaleScript)
				(if (not (IsFlag 85))
					(EcoNarrator init: 2 0 0 9 goToWhaleScript) ; "With a mixture of joy and fear, Adam approaches the mighty whale."
				else
					(SetFlag 140)
					(EcoNarrator init: 2 0 0 13 goToWhaleScript) ; "Adam decides to get closer to the outside of the whale."
				)
			)
			(2 ; Talk
				(cond
					((not (IsFlag 85))
						(goToWhaleScript start: -1)
						(gCurRoom setScript: goToWhaleScript)
						(EcoNarrator init: 2 0 0 9 goToWhaleScript) ; "With a mixture of joy and fear, Adam approaches the mighty whale."
					)
					((and (IsFlag 85) (not (IsFlag 86)))
						(goToWhaleScript start: -1)
						(gCurRoom setScript: goToWhaleScript)
						(EcoNarrator init: 2 0 0 12 goToWhaleScript) ; "Adam decides to make a dash for Cetus' moving mouth."
					)
					(else
						(EcoNarrator init: 2 0 0 15) ; "Cetus has lost consciousness and can no longer speak to Adam."
					)
				)
			)
			(44 ; Inventory
				(switch temp0
					(12
						(EcoNarrator init: 2 0 0 16) ; "Adam can't heal Cetus from here."
					)
					(else
						(EcoNarrator init: 2 0 0 17) ; "That won't help Cetus."
					)
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 2 0 0 20) ; "This is no time to be concerned with recycling."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance topOfWhale of EcoFeature
	(properties
		onMeCheck 4
		lookStr 2
	)
)

(instance cable of EcoView
	(properties
		x 227
		y 77
		sightAngle 0
		view 642
		loop 3
		priority 1
		signal 16401
		lookStr 4
	)

	(method (onMe param1)
		(return (InRect 221 74 229 189 param1))
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 2 0 0 1) ; "There's nothing Adam can do to the cable from here that would help Cetus."
			)
			(44 ; Inventory
				(EcoNarrator init: 2 0 0 1) ; "There's nothing Adam can do to the cable from here that would help Cetus."
			)
			(6 ; Recycle
				(EcoNarrator init: 2 0 0 19) ; "The cable will not be that simple to deal with."
			)
			(2 ; Talk
				(EcoNarrator init: 2 0 0 21) ; "Adam can't talk to the water."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

