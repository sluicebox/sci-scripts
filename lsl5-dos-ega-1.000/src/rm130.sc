;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 130)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use LoadMany)
(use Sound)
(use Actor)
(use System)

(public
	rm130 0
)

(local
	[local0 2]
	local2
)

(instance rm130 of LLRoom
	(properties
		picture 130
	)

	(method (init)
		(LoadMany rsVIEW 130 1130)
		(LoadMany rsSOUND 130 140)
		(HandsOff)
		(cigar init: setPri: 15 addToPic:)
		(vMouth init: setPri: 13 addToPic:)
		(brow1 init: addToPic:)
		(brow2 init: addToPic:)
		(gAddToPics doit:)
		(super init:)
		(SetFFRoom 155)
		(gTheMusic number: 130 flags: 1 loop: 0 play:)
		(self setScript: sCartoon)
		(gKeyDownHandler add: sCartoon)
		(gMouseDownHandler add: sCartoon)
	)

	(method (dispose)
		(gMouseDownHandler delete: sCartoon)
		(gKeyDownHandler delete: sCartoon)
		(super dispose:)
		(gTheMusic fade: 0 15 12 1)
	)
)

(instance vMouth of View
	(properties
		x 154
		y 129
		view 1130
	)
)

(instance brow1 of View
	(properties
		x 127
		y 53
		view 130
	)
)

(instance brow2 of View
	(properties
		x 179
		y 55
		view 130
		loop 1
	)
)

(instance cigar of View
	(properties
		x 201
		y 104
		view 130
		loop 3
	)
)

(instance officeHit of Sound ; UNUSED
	(properties
		number 130
	)
)

(instance Mr__Bigg of Talker
	(properties
		name {Mr. Bigg}
		x -1
		y 10
		nsTop 79
		nsLeft 111
		view 1130
		loop 3
		priority 14
		signal 16
		talkWidth 280
	)

	(method (init)
		(= mouth biggMouth)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (not (mod (++ local2) 32))
			(Palette palANIMATE 206 254 -1)
		)
	)

	(method (show &tmp pnv)
		(if (not underBits)
			(= underBits (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
		)
		(= pnv (PicNotValid))
		(PicNotValid 1)
		(if bust
			(DrawCel
				(bust view:)
				(bust loop:)
				(bust cel:)
				(+ (bust nsLeft:) nsLeft)
				(+ (bust nsTop:) nsTop)
				14
			)
		)
		(if eyes
			(DrawCel
				(eyes view:)
				(eyes loop:)
				(eyes cel:)
				(+ (eyes nsLeft:) nsLeft)
				(+ (eyes nsTop:) nsTop)
				14
			)
		)
		(if mouth
			(DrawCel
				(mouth view:)
				(mouth loop:)
				(mouth cel:)
				(+ (mouth nsLeft:) nsLeft)
				(+ (mouth nsTop:) nsTop)
				14
			)
		)
		(DrawCel view loop cel nsLeft nsTop 10)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		(PicNotValid pnv)
	)

	(method (cycle obj &tmp theCel)
		(if (and obj (obj cycler:))
			(= theCel (obj cel:))
			((obj cycler:) doit:)
			(if (!= theCel (obj cel:))
				(DrawCel
					(obj view:)
					(obj loop:)
					(obj cel:)
					(+ (obj nsLeft:) nsLeft)
					(+ (obj nsTop:) nsTop)
					14
				)
				(obj
					nsRight:
						(+
							(obj nsLeft:)
							(CelWide
								(obj view:)
								(obj loop:)
								(obj cel:)
							)
						)
				)
				(obj
					nsBottom:
						(+
							(obj nsTop:)
							(CelHigh
								(obj view:)
								(obj loop:)
								(obj cel:)
							)
						)
				)
				(Graph
					grUPDATE_BOX
					(+ (obj nsTop:) nsTop)
					(+ (obj nsLeft:) nsLeft)
					(+ (obj nsBottom:) nsTop)
					(+ (obj nsRight:) nsLeft)
					1
				)
			)
		)
	)
)

(instance biggMouth of Prop
	(properties
		view 1130
		priority 14
		signal 16
		cycleSpeed 10
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(Say Mr__Bigg 130 0 #dispose #caller self) ; "I understand the problem, but I want a solution!"
			)
			(2
				(= seconds 3)
			)
			(3
				(gTheIconBar disable:)
				(DrawPic 1 -32762)
				(= seconds 3)
			)
			(4
				(gTheIconBar enable:)
				(CenterDisplay 3 gColWhite 130 1)
				(= seconds 3)
			)
			(5
				(gCurRoom newRoom: 140)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if
			(and
				(== (self state:) 4)
				(or (== (event type:) evKEYBOARD) (== (event type:) evMOUSEBUTTON))
			)
			(event claimed: 1)
			(self changeState: 5)
		)
	)
)

