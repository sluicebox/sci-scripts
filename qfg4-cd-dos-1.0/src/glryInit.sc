;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Plane)
(use Talker)
(use User)
(use Actor)
(use System)

(public
	glryInit 0
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp0 (View new:))
	(temp0 view: 9999 loop: 0 cel: 0 x: 0 y: 100 init:)
	(= temp1 (GetTime))
	(while (< (temp0 x:) 320)
		(UpdateScreenItem (temp0 x: (+ (temp0 x:) 4) yourself:))
		(FrameOut)
	)
	(= global191 (- (GetTime) temp1))
	(temp0 dispose:)
)

(instance glryInit of Code
	(properties)

	(method (init &tmp [temp0 2])
		(RemapColors 5 66 20) ; SetGlobalNoMatchRange
		(User alterEgo: gEgo canControl: 0 canInput: 0 mapKeyToDir: 0)
		(gEgo setSpeed: 0)
		(= gSystemPlane Plane)
		((= gNarrator Narrator) back: 255 font: 300 y: 120)
		(SetFlag 400)
		(|= gMsgType $0002)
		(gGlory masterVolume: 15)
		(= gUseSortedFeatures 1)
		(= global133 (DoSound sndGET_POLYPHONY))
		(= gPossibleScore 500)
		(= gUserFont 300)
		(= gSmallFont 999)
		(= gBigFont 300)
		(= global134 20)
		(= global135 15)
		(= global198 20)
		(= global434 (Random 1 26))
		(= global435 (Random 1 26))
		(= global436 (Random 1 26))
		(if (HaveMouse)
			(= gEatMice 6)
			(gGlory setCursor: gNormalCursor 1)
		else
			(gGlory setCursor: gNormalCursor 1 304 174)
		)
		(= [gEgoStats 17] (gEgo maxHealth:)) ; health
		(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
		(= [gEgoStats 19] (gEgo maxMana:)) ; mana
		(= global394 1)
		(SetFlag 379)
		(localproc_0)
		((gInventory at: 18) state: 1) ; theShield
		((gInventory at: 19) state: 1) ; theSword
		(proc0_18 17)
		(proc0_18 18)
		(proc0_18 19)
		(gGlory newRoom: 4)
	)
)

