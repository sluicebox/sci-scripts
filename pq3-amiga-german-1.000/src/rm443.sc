;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 443)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm443 0
)

(local
	local0
	local1
)

(instance rm443 of PQRoom
	(properties
		picture 43
	)

	(method (init)
		(LoadMany rsVIEW 6 468 469 472)
		(Load rsSCRIPT 883)
		(if (== gPrevRoomNum 44)
			(gEgo posn: 228 82)
			(door cel: 3 init:)
		else
			(gEgo loop: 0 posn: 161 108)
			(door init:)
		)
		(gEgo view: 6 setPri: -1 setStep: 3 2 init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 80 90 91 105 136 90 176 137 133 146 116 151 59 89 57 90 112 151 87 157 39 95 37 96 81 155 39 172 42 189 247 189 200 137 201 119 185 104 219 94 194 70
					yourself:
				)
		)
		(reporter init:)
		(egoChair init:)
		(attorneyChair init:)
		(judgeBench init:)
		(witnessBox init:)
		(flag init:)
		(spectatorArea init:)
		(wall init:)
		(table init:)
		(chairs init:)
		(aisle init:)
		(reporter setScript: shufflePapers)
		(if (== gPrevRoomNum 44)
			(gCurRoom setScript: egoExitChambers)
		)
		(super init:)
	)

	(method (doit)
		(cond
			(script 0)
			((& (gEgo onControl: 0) $0800)
				(gCurRoom newRoom: 42)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance speechScript of rmnScript
	(properties)

	(method (changeState newState &tmp [temp0 200] temp200)
		(switch (= state newState)
			(0
				(switch local0
					(0
						(iEgo init:)
					)
					(5
						(ireporter init:)
					)
				)
				(= cycles 1)
			)
			(1
				(= save1 1)
				(switch local0
					(0
						(GetFarText 503 (+ register 0) @temp0)
						(Say iEgo 503 (+ register 0))
					)
					(5
						(GetFarText 503 (+ register 49) @temp0)
						(Say ireporter 503 (+ register 49))
					)
				)
				(if (not (< (= temp200 (StrLen @temp0)) 12))
					(= seconds (/= temp200 5))
				else
					(= seconds 4)
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(switch local0
					(0
						(iEgo dispose:)
					)
					(5
						(ireporter dispose:)
					)
				)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance ok2Enter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 201 83 self)
			)
			(1
				(openDoorSound play:)
				(= cycles 1)
			)
			(2
				(door setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 44)
			)
		)
	)
)

(instance notOk2Enter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 201 83 self)
			)
			(1
				(lockedDoorSound play: self)
			)
			(2
				(Print 443 0) ; "The door to the judge's chambers is locked. She must not be in."
				(= cycles 1)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useArticle of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 443 1) ; "You show the newspaper article to the court reporter and tell her that you need to see the judge about this case."
				(= cycles 1)
			)
			(1
				(= local0 5)
				(self setScript: speechScript self 0)
			)
			(2
				(= local1 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance mayIHelpYou of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 5)
				(self setScript: speechScript self 1)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shufflePapers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(reporter cycleSpeed: 12 setCycle: CT 3 1 self)
			)
			(1
				(reporter setCycle: CT 6 1 self)
				(paperSound play:)
			)
			(2
				(reporter setCycle: End self)
				(paperSound play:)
			)
			(3
				(= seconds 5)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance egoExitChambers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 1 setCycle: Walk setMotion: MoveTo 193 84 self)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(closeDoorSound play:)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance reporter of Actor
	(properties
		x 226
		y 109
		description {the court reporter}
		view 468
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 443 2) ; "The court reporter is busy at the judge's bench."
			)
			(5 ; Talk
				(HandsOff)
				(gCurRoom setScript: mayIHelpYou)
			)
			(3 ; Do
				(Print 443 3) ; "Bullying the court reporter will only get you in big trouble."
			)
			(4 ; Inventory
				(switch invItem
					(35 ; article
						(if local1
							(Print 443 4) ; "The reporter is busy. Besides, you don't have time for idle chit-chat."
						else
							(HandsOff)
							(gCurRoom setScript: useArticle)
						)
					)
					(1 ; gun
						(Print 443 5) ; "Get real Bonds!"
					)
					(16 ; nightStick
						(Print 443 6) ; "Testing... reality check ... testing..."
					)
					(2 ; handcuff
						(Print 443 7) ; "Come on Bonds! Can't you see the lady's busy? If you don't have anything to say then leave her alone."
					)
					(17 ; knife
						(Print 443 5) ; "Get real Bonds!"
					)
					(19 ; wallet
						(Print 443 8) ; "Yes Officer, can I help you?"
					)
					(else
						(Print 443 9) ; "She really isn't interested in that."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(reporter cycleSpeed: (gGame egoMoveSpeed:))
		(super init:)
	)
)

(instance egoChair of View
	(properties
		x 128
		y 133
		view 461
		loop 6
		priority 9
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 10) ; "This chair is for the prosecution."
			)
			(3 ; Do
				(Print 443 11) ; "You're not here to sit around."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance attorneyChair of View
	(properties
		x 106
		y 120
		view 461
		loop 6
		priority 10
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 12) ; "That chair for the prosecution."
			)
			(3 ; Do
				(Print 443 13) ; "You're not here to sit around."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance judgeBench of Feature
	(properties
		x 224
		y 114
		description {the bench}
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 14) ; "The judge's bench holds the place of honor in the courtroom."
			)
			(3 ; Do
				(Print 443 15) ; "You're not allowed up there."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance witnessBox of Feature
	(properties
		x 201
		y 92
		description {the witness box}
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 16) ; "The witness box is located next to the judge's bench."
			)
			(3 ; Do
				(Print 443 17) ; "Quit fooling around and stick to the matter at hand."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flag of Feature
	(properties
		x 238
		y 69
		description {the flag}
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 18) ; "The U.S. flag serves to remind everyone that the courts are a branch of the local, state, and U.S. governments."
			)
			(3 ; Do
				(Print 443 19) ; "You patriotically salute the flag."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spectatorArea of Feature
	(properties
		x 65
		y 121
		description {the spectator area}
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 20) ; "This is the spectator area. It is usually open for the public to observe the court's proceedings."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 131
		y 141
		description {the wall}
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 21) ; "The three foot wall divides the council from the spectator area of the courtroom."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 134
		y 103
		description {the table}
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 22) ; "That table is for the prosecuting attorney and the complaintent or prosecution witness."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chairs of Feature
	(properties
		x 65
		y 121
		description {the chairs}
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 23) ; "Theater chairs line the spectator area."
			)
			(3 ; Do
				(Print 443 11) ; "You're not here to sit around."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aisle of Feature
	(properties
		x 131
		y 141
		description {the aisle}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 24) ; "An aisle runs down the middle of the spectator area to the council area."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 209
		y 31
		description {the door}
		view 472
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 443 25) ; "That door must lead to the judge's chambers."
			)
			(3 ; Do
				(if local1
					(gCurRoom setScript: ok2Enter)
				else
					(gCurRoom setScript: notOk2Enter)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sSoundEffects of Sound ; UNUSED
	(properties
		priority 14
	)
)

(instance ireporter of View
	(properties
		x 252
		y 101
		view 469
		loop 1
		priority 15
		signal 16
	)

	(method (init)
		(repMouth
			x: (ireporter x:)
			y: (+ (ireporter y:) 10)
			z: 10
			setCycle: RandCycle
			init:
		)
		(super init:)
	)

	(method (dispose)
		(repMouth dispose:)
		(super dispose:)
	)
)

(instance repMouth of Prop
	(properties
		view 469
		priority 15
		signal 16
		cycleSpeed 8
	)
)

(instance iEgo of View
	(properties
		x 56
		y 116
		view 25
		priority 15
		signal 16
	)

	(method (init)
		(iEgoMouth
			x: (iEgo x:)
			y: (+ (iEgo y:) 10)
			z: 10
			setCycle: RandCycle
			init:
		)
		(iEgoClothes x: (+ (iEgo x:) 3) y: (+ (iEgo y:) 61) init:)
		(iEgoEyes
			x: (iEgo x:)
			y: (+ (iEgo y:) 10)
			z: 10
			init:
			setScript: egoEyesBlink
		)
		(super init:)
	)

	(method (dispose)
		(iEgoMouth dispose:)
		(iEgoClothes dispose:)
		(iEgoEyes setScript: 0 dispose:)
		(super dispose:)
	)
)

(instance iEgoMouth of Prop
	(properties
		view 25
		loop 1
		priority 15
		signal 16400
	)
)

(instance iEgoClothes of View
	(properties
		view 25
		cel 1
		priority 15
		signal 16
	)
)

(instance iEgoEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(iEgoEyes cel: 1)
				(= cycles 2)
			)
			(2
				(iEgoEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance paperSound of Sound
	(properties
		number 211
	)
)

(instance lockedDoorSound of Sound
	(properties
		number 213
	)
)

(instance openDoorSound of Sound
	(properties
		number 907
	)
)

(instance closeDoorSound of Sound
	(properties
		number 908
	)
)

