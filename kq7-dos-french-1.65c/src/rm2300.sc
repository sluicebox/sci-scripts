;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2300)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Print)
(use Motion)
(use Actor)
(use System)

(public
	rm2300 0
)

(local
	local0 = 200
	local1 = 1
)

(instance rm2300 of KQRoom
	(properties
		picture 2300
	)

	(method (init)
		(switch gPrevRoomNum
			(4050
				(Load rsVIEW 2300)
			)
			(2100
				(Load rsVIEW 2201)
				(Load rsPIC 2200)
			)
		)
		(super init:)
		((ScriptID 7001 0) client: trollKing hide_mouth: 0 clientCel: -2) ; kingTalker
		((ScriptID 7001 1) client: malicia clientCel: -2 hide_mouth: 0) ; maliciaTalker
		(gEgo view: 2301 x: 130 y: 88 setLoop: 0 init:)
		(self setScript: goToHall)
		(Load 140 2301) ; WAVE
	)

	(method (doit)
		(super doit: &rest)
		(if (and local1 (not (-- local0)))
			(= local0 (Random 300 450))
			(gKqSound1 number: 2301 setLoop: 1 play:)
		)
	)
)

(instance goToHall of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load 140 2201) ; WAVE
					(Load rsVIEW 22015)
					(Load rsVIEW 9060)
					(gEgo
						view: 2301
						setLoop: 0
						cel: 0
						posn: 120 88
						setCycle: CT 19 1 self
					)
				)
				(1
					((ScriptID 7001 1) hide_mouth: 1) ; maliciaTalker
					((ScriptID 7001 0) hide_mouth: 1) ; kingTalker
					(gMessager say: 0 0 1 0 self) ; "(SURPRISED AND SCARED)My--My lady Malicia! I wasn't expecting you..."
				)
				(2
					((ScriptID 7001 1) hide_mouth: 0) ; maliciaTalker
					((ScriptID 7001 0) hide_mouth: 0) ; kingTalker
					(gEgo cycleSpeed: 12 setCycle: CT 26 1 self)
				)
				(3
					(UpdatePlane (gThePlane drawPic: 2200 yourself:))
					(gKqSound1 number: 2201 setLoop: -1 play:)
					(= local1 0)
					(gEgo hide:)
					(malicia init: setPri: 140 setCycle: Fwd)
					(trollKing init: setPri: 140)
					(= ticks 40)
				)
				(4
					(malicia setCycle: 0)
					(gMessager say: 0 0 1 1 self 2200) ; "(VENOMOUSLY)Listen to me, you pudding-brained puppet. If you and your obsession with that pale-skinned meddlesome princess manage to disrupt my plans, I'll have you filleted. Have you learned to work the volcano mechanism yet?"
				)
				(5
					(malicia setCycle: Fwd)
					(gMessager say: 0 0 1 2 self 2200) ; "(SCARED AND CONFUSED)Well, y-yes, I think so...but Lady Malicia, is it really necessary? Won't the Realm of Eldritch be harmed, my lady? The Bountiful Woods are right below Etheria, and the land of Ooga Booga..."
				)
				(6
					(malicia setCycle: 0)
					(gMessager say: 0 0 1 3 self 2200) ; "(GETTING WORKED UP)Oh, a village here, a township there, who's going to miss them? Even if all of Eldritch is covered in slag, at least the blight of Etheria will be GONE!"
				)
				(7
					(malicia setCycle: Fwd)
					(gMessager say: 0 0 1 4 self 2200) ; "(SNOTTILY)Barf! Barf!"
				)
				(8
					(malicia
						view: 9060
						setLoop: 0
						cel: 8
						posn: 154 132
						setCycle: Fwd
						setMotion: MoveTo 340 127 self
					)
				)
				(9
					(malicia dispose:)
					(= ticks 10)
				)
				(10
					(gKqSound1 number: 838 setLoop: 1 play: self)
				)
				(11
					(= ticks 30)
				)
				(12
					(trollKing setCycle: End self)
				)
				(13
					(trollKing
						view: 22015
						loop: 2
						cel: 0
						posn: 207 112
						cycleSpeed: 4
						setCycle: End self
					)
				)
				(14
					(gKqSound1 number: 838 setLoop: 1 play: self)
					(trollKing
						loop: 3
						cel: 0
						posn: 197 125
						cycleSpeed: 6
						setCycle: End self
					)
				)
				(15 0)
				(16
					(gKqSound1 number: 2201 setLoop: -1 play:)
					(gMessager say: 0 0 1 5 self 2200) ; "(CONFUSED, UPSET)I just don't know what's right...what's real. If only I could remember..."
				)
				(17
					(UpdatePlane (gThePlane drawPic: 2300 yourself:))
					(gKqMusic1 number: 2300 setLoop: 1 play:)
					(= local1 1)
					(trollKing dispose:)
					(gEgo cel: 2 posn: 200 90 show:)
					(= ticks 30)
				)
				(18
					(gEgo setCycle: Beg self)
					(gMessager say: 0 0 2 1 self) ; "(THINKS TO HERSELF IN HORROR)Oh no! She can't! She just can't!"
				)
				(19 0)
				(20
					(gEgo setCycle: End self)
				)
				(21
					(gGame handsOn:)
					(gCurRoom newRoom: 2450)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(gGame handsOn:)
					(gCurRoom newRoom: 2450)
				)
			)
		)
	)
)

(instance tempDoor of View ; UNUSED
	(properties
		x 23
		y 80
		view 2300
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(Prints
				{We cut to troll bridge to see Edgar and Val cartoon before room chg.}
			)
			(gCurRoom newRoom: 2200)
		)
	)
)

(instance malicia of Actor
	(properties
		x 140
		y 138
		view 2201
		loop 1
	)
)

(instance trollKing of Prop
	(properties
		x 208
		y 111
		view 2201
	)
)

