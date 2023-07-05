;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 815)
(include sci.sh)
(use Main)
(use HRView)
(use GKIconbar)
(use n013)
(use DButton)
(use Plane)
(use Str)
(use Array)
(use Print)
(use Dialog)
(use Inset)
(use Feature)
(use LoadMany)
(use Cursor)
(use Timer)
(use User)
(use System)

(public
	drumInset 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
)

(instance drumTimer of Timer
	(properties)

	(method (init param1)
		(gTimers add: self)
		(= client param1)
	)
)

(class Drum of Code
	(properties
		phraseNum 0
		beat 0
	)

	(method (doit param1)
		(= beat 0)
		(= phraseNum param1)
		(self cue:)
	)

	(method (cue &tmp temp0)
		(if (!= (= temp0 ((local4 at: phraseNum) at: beat)) -1)
			(++ beat)
			(if (DoSound sndGET_AUDIO_CAPABILITY)
				(gGkSound2 number: (+ temp0 1800) setLoop: 1 play: self)
			else
				(drumTimer setTicks: 70 init: self)
			)
			(if (Drummer jammin:)
				(DrumDisplay doit: temp0)
			)
		else
			(Drummer doit:)
		)
	)
)

(instance myPrint of Print
	(properties)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(class DrumDisplay of Code
	(properties
		nextX 184
		nextY 96
		myStr 0
	)

	(method (doit param1 &tmp temp0 temp1)
		(= temp0 (+ 97 (- param1 1)))
		(cond
			((not myStr)
				((= myStr (Str new:)) format: {%c } temp0)
			)
			((> (myStr size:) 250)
				(self clear:)
				((= myStr (Str new:)) format: {%c } temp0)
			)
			(else
				(myStr cat: ((= temp1 (Str new:)) format: {%c } temp0))
				(temp1 dispose:)
			)
		)
		(if (myPrint dialog:)
			((myPrint dialog:) dispose:)
		)
		(myPrint
			fore: global222
			back: 0
			skip: 1
			font: 9561
			posn: 184 96
			width: 125
			modeless: 2
			addText: myStr
			init:
		)
		(FrameOut)
	)

	(method (clear)
		(= nextX 184)
		(= nextY 96)
		(myStr dispose:)
		(= myStr 0)
	)
)

(class Drummer of Code
	(properties
		phCount 0
		drumPlay 0
		justJammed 0
		jammin 1
	)

	(method (init)
		(switch local0
			(2
				(= drumPlay (IntArray with: 6 10 26 -1))
			)
			(3
				(= drumPlay (IntArray with: 6 10 20 -1))
			)
			(1
				(= drumPlay (IntArray with: 1 -1))
			)
			(0
				(= drumPlay (IntArray with: 8 -1))
			)
			(4
				(ClearFlag 469)
				(= jammin 0)
				(= drumPlay (IntArray with: 8 8 8 8 -1))
			)
		)
		(if jammin
			(self doit:)
		)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((and jammin (or (not justJammed) (== (Random 0 4) 2)))
				(= justJammed 1)
				(Drum doit: (+ (Random 0 5) 35))
			)
			((== (= temp0 (drumPlay at: phCount)) -1)
				(if jammin
					(= phCount 0)
					(= justJammed 1)
					(Drum doit: (+ (Random 0 5) 35))
				else
					(self stop:)
					(SetFlag 406)
				)
			)
			(else
				(++ phCount)
				(= justJammed 0)
				(Drum doit: temp0)
			)
		)
	)

	(method (stop &tmp temp0)
		(gTimers delete: drumTimer)
		(drumTimer dispose:)
		(gGkSound2 client: 0)
		(FrameOut)
		(gGkSound2 stop:)
		(for ((= temp0 0)) (< temp0 (local4 size:)) ((++ temp0))
			((local4 at: temp0) dispose:)
		)
		(local4 dispose:)
		(local10 dispose:)
		(drumPlay dispose:)
	)
)

(instance drumInset of Inset
	(properties
		picture 9561
		modNum 815
	)

	(method (init)
		(LoadMany rsVIEW 959 9561)
		(super init: &rest)
		(ClearFlag 406)
		(User canControl: 1 canInput: 1)
		(= local2 gEatMice)
		(= gEatMice 0)
		(= oldStyle 14)
		(= local1 gTheCursor)
		((ScriptID 0 1) view: 999) ; globeCursor
		(gGame setCursor: (ScriptID 0 1)) ; globeCursor
		(SetFlag 220)
		(if (gGame barUp:)
			(gTheIconBar erase:)
		)
		(= local3 gTheIconBar)
		(= gTheIconBar myBar)
		(if (gEgo has: 54) ; records
			(myBar add: nextBookIcon)
		)
		(gGkMusic1 fade:)
		(myBar
			add: eraseIcon exitIcon iconCon drumIconHelp
			helpIconItem: drumIconHelp
			init:
			highlightedIcon: 0
			state: 3072
		)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(= local0
			(switch gCurRoomNum
				(410 ; neJackson
					(switch gDay
						(6 2)
						(7 1)
						(10 3)
						(else 0)
					)
				)
				(800 4) ; Hounfour
				(else
					(if (< gDay 6) 0 else 1)
				)
			)
		)
		(= local10 (IntArray newWith: 4))
		(= local4
			(IDArray
				with:
					(IntArray with: 9 1 1 1 5 9 -1)
					(IntArray with: 9 5 7 2 2 9 -1)
					(IntArray with: 9 2 4 4 2 9 -1)
					(IntArray with: 9 1 1 7 2 9 -1)
					(IntArray with: 9 2 2 4 2 9 -1)
					(IntArray with: 9 4 1 2 5 9 -1)
					(IntArray with: 9 8 1 1 1 9 -1)
					(IntArray with: 9 8 2 2 5 9 -1)
					(IntArray with: 9 4 4 4 9 -1)
					(IntArray with: 7 2 2 7 -1)
					(IntArray with: 7 1 1 7 -1)
					(IntArray with: 7 5 5 7 -1)
					(IntArray with: 7 4 4 7 -1)
					(IntArray with: 7 2 2 5 7 -1)
					(IntArray with: 7 3 3 7 -1)
					(IntArray with: 7 3 3 6 7 -1)
					(IntArray with: 7 6 6 7 -1)
					(IntArray with: 7 6 6 9 7 -1)
					(IntArray with: 7 8 9 7 -1)
					(IntArray with: 8 2 2 8 -1)
					(IntArray with: 8 6 6 8 -1)
					(IntArray with: 8 4 8 -1)
					(IntArray with: 8 3 3 8 -1)
					(IntArray with: 8 1 1 8 -1)
					(IntArray with: 8 7 1 1 8 -1)
					(IntArray with: 8 7 2 2 8 -1)
					(IntArray with: 8 7 4 4 8 -1)
					(IntArray with: 8 7 6 6 8 -1)
					(IntArray with: 5 6 2 2 5 -1)
					(IntArray with: 5 4 7 4 5 -1)
					(IntArray with: 5 3 3 2 5 -1)
					(IntArray with: 5 4 6 3 5 -1)
					(IntArray with: 5 2 2 3 5 -1)
					(IntArray with: 5 9 2 2 5 -1)
					(IntArray with: 5 7 2 3 5 -1)
					(IntArray with: 3 3 3 3 -1)
					(IntArray with: 6 4 3 2 3 4 -1)
					(IntArray with: 1 2 3 6 2 -1)
					(IntArray with: 2 2 2 6 6 2 2 -1)
					(IntArray with: 1 1 1 2 -1)
					(IntArray with: 2 4 2 1 2 3 -1)
			)
		)
		(= local5
			(IDArray
				with:
					(Str
						with:
							(switch (gGame printLang:)
								(34 {CONVOCAR: i a a a e i})
								(49 {EINBERUFEN: i a a a e i})
								(33 {APPELER: i a a a e i})
								(else {SUMMON: i a a a e i})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {ADVERTIR: i e g b b i})
								(49 {WARNEN: i e g b b i})
								(33 {AVERTIR: i e g b b i})
								(else {WARN: i e g b b i})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {LUCHAR: i b d d b i})
								(49 {ANGREIFEN: i b d d b i})
								(33 {ENGAGER: i b d d b i})
								(else {ENGAGE: i b d d b i})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {PEDIR: i a a g b i})
								(49 {VERLANGEN: i a a g b i})
								(33 {DEMANDER: i a a g b i})
								(else {REQUEST: i a a g b i})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {PREGUNTAR: i b b d b i})
								(49 {BEFRAGEN: i b b d b i})
								(33 {EXAMINER: i b b d b i})
								(else {INQUIRE: i b b d b i})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {ANUNCIAR: i d a b e i})
								(49 {ANK\9aNDIGEN: i d a b e i})
								(33 {ANNONCER: i d a b e i})
								(else {ANNOUNCE: i d a b e i})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {BEANTRAGE PRIVATTREFFEN: i h a a a i})
								(33 {REUNIR ASSEMBLEE SECRETE: i h a a a i})
								(34 {LLAMAR A CONCLAVE: i h a a a i})
								(else {CALL CONCLAVE: i h a a a i})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {BEANTRAGE TREFFEN: i h b b e i})
								(33 {REUNIR ASSEMBLEE: i h b b e i})
								(34 {LLAMAR A REUNION TRIBAL: i h b b e i})
								(else {CALL TRIBAL MEETING: i h b b e i})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {KEINE NACHRICHT: i d d d i})
								(33 {PAS DE MESSAGE: i d d d i})
								(34 {SIN MENSAJE: i d d d i})
								(else {NO MESSAGE: i d d d i})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {HEUTE: g b b g})
								(33 {AUJOURD'HUI: g b b g})
								(34 {HOY: g b b g})
								(else {TODAY: g b b g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {HEUTE NACHT: g a a g})
								(33 {CE SOIR: g a a g})
								(34 {ESTA NOCHE: g a a g})
								(else {TONIGHT: g a a g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {MORGEN: g e e g})
								(33 {DEMAIN-JOURNEE: g e e g})
								(34 {MA\a5ANA DIA: g e e g})
								(else {TOMORROW DAY: g e e g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {MORGEN ABEND: g d d g})
								(33 {DEMAIN SOIR: g d d g})
								(34 {MA\a5ANA NOCHE: g d d g})
								(else {TOMORROW NIGHT: g d d g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {HEUTE +n TAGE: g b b n- e g})
								(33 {AUJOURD'HUI +n JOURS: g b b n- e g})
								(34 {HOY +n DIAS: g b b n- e g})
								(else {TODAY +n DAYS: g b b n- e g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {N\8eCHSTER MOND: g c c g})
								(33 {PROCHAINE LUNE: g c c g})
								(34 {PROXIMA LUNA: g c c g})
								(else {NEXT MOON: g c c g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {DIESER MOND +n MOND: g c c n- f g})
								(33 {CETTE LUNE +n LUNES: g c c n- f g})
								(34 {ESTA LUNA +n LUNAS: g c c n- f g})
								(else {THIS MOON +n MOONS: g c c n- f g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {N\8eCHSTES JAHR: g f f g})
								(33 {L'ANNEE PROCHAINE: g f f g})
								(34 {A\a5O PROXIMO: g f f g})
								(else {NEXT YEAR: g f f g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {DIESES JAHR +n JAHRE: g f f n-i g})
								(33 {CETTE ANNEE +n ANNEES: g f f n-i g})
								(34 {ESTE A\a5O +n A\a5OS: g f f n-i g})
								(else {THIS YEAR +n YEARS: g f f n-i g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {ZUKUNFT: g h i g})
								(33 {FUTUR: g h i g})
								(34 {FUTURO: g h i g})
								(else {FUTURE: g h i g})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {DORF: h b b h})
								(33 {VILLAGE: h b b h})
								(34 {PUEBLO: h b b h})
								(else {VILLAGE: h b b h})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {HOUNFOUR: h f f h})
								(33 {HOUNFOUR: h f f h})
								(else {HOUNFOUR: h f f h})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {WALD: h d h})
								(33 {FORET: h d h})
								(34 {ARBOLEDA: h d h})
								(else {FOREST: h d h})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {BERGE: h c c h})
								(33 {MONTAGNES: h c c h})
								(34 {MONTA\a5AS: h c c h})
								(else {MOUNTAINS: h c c h})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {T\8eLER: h a a h})
								(33 {PLAINES: h a a h})
								(34 {LLANURAS: h a a h})
								(else {PLAINS: h a a h})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {SEE: h g a a h})
								(33 {LAC: h g a a h})
								(34 {LAGO: h g a a h})
								(else {LAKE: h g a a h})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {FLUSS: h g b b h})
								(33 {RIVIERE: h g b b h})
								(34 {RIO: h g b b h})
								(else {RIVER: h g b b h})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {SUMPF: h g d d h})
								(33 {MARECAGE: h g d d h})
								(34 {PANTANO: h g d d h})
								(else {SWAMP: h g d d h})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(49 {MEER: h g f f h })
								(33 {MER: h g f f h})
								(34 {MAR: h g f f h })
								(else {SEA: h g f f h })
							)
					)
			)
		)
		(= local6
			(IDArray
				with:
					(Str
						with:
							(switch (gGame printLang:)
								(34 {HERMANA COCODRILO: e f b b e})
								(49 {SCHWESTER KROKODIL: e f b b e})
								(33 {LA SOEUR ALLIGATOR: e f b b e})
								(else {SISTER ALLIGATOR: e f b b e})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {HERMANO AGUILA: e d g d e})
								(49 {BRUDER ADLER: e d g d e})
								(33 {LE FRERE AIGLE: e d g d e})
								(else {BROTHER EAGLE: e d g d e})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {HERMANO TIGRE: e c c b e})
								(49 {BRUDER TIGER: e c c b e})
								(33 {LE FRERE TIGRE: e c c b e})
								(else {BROTHER TIGER: e c c b e})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {HERMANA BUHO: e d f c e})
								(49 {SCHWESTER EULE: e d f c e})
								(33 {LA SOEUR HIBOU: e d f c e})
								(else {SISTER OWL: e d f c e})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {HERMANA GISSELLE: e b b c e})
								(49 {SCHWESTER GISSELLE: e b b c e})
								(33 {LA SOEUR GISSELLE: e b b c e})
								(else {SISTER GAZELLE: e b b c e})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {HERMANO RINOCERONTE: e i b b e})
								(49 {BRUDER NILPFERD: e i b b e})
								(33 {LE FRERE RHINO: e i b b e})
								(else {BROTHER RHINO: e i b b e})
							)
					)
					(Str
						with:
							(switch (gGame printLang:)
								(34 {HERMANO LEON: e g b c e})
								(49 {BRUDER L\99WE: e g b c e})
								(33 {LE FRERE LION: e g b c e})
								(else {BROTHER LION: e g b c e})
							)
					)
			)
		)
		((= local8 radaBook) init:)
		(turnLeft init:)
		(turnRight init:)
		(Drummer init:)
	)

	(method (dispose &tmp temp0)
		(= gEatMice local2)
		(if (Drummer jammin:)
			(Drummer stop:)
		else
			(PhraseDisplay checkPhrases:)
		)
		(local8 dispose:)
		(turnLeft dispose:)
		(turnRight dispose:)
		(if (PhraseDisplay phaserArray:)
			((PhraseDisplay phaserArray:) dispose:)
		)
		(FrameOut)
		(for ((= temp0 0)) (< temp0 (local5 size:)) ((++ temp0))
			((local5 at: temp0) dispose:)
		)
		(local5 dispose:)
		(for ((= temp0 0)) (< temp0 (local6 size:)) ((++ temp0))
			((local6 at: temp0) dispose:)
		)
		(local6 dispose:)
		(if (Drummer jammin:)
			(if (DrumDisplay myStr:)
				((DrumDisplay myStr:) dispose:)
			)
			(if (myPrint dialog:)
				((myPrint dialog:) dispose:)
			)
			(FrameOut)
		)
		(if (pagePrint dialog:)
			((pagePrint dialog:) dispose:)
		)
		(FrameOut)
		(if (pdPrint1 dialog:)
			((pdPrint1 dialog:) dispose:)
		)
		(FrameOut)
		(if (pdPrint2 dialog:)
			((pdPrint2 dialog:) dispose:)
		)
		(FrameOut)
		(if (pdPrint3 dialog:)
			((pdPrint3 dialog:) dispose:)
		)
		(FrameOut)
		(if (pdPrint4 dialog:)
			((pdPrint4 dialog:) dispose:)
		)
		(FrameOut)
		(ClearFlag 220)
		(if (Drummer jammin:)
			(gGame setCursor: local1)
		else
			(gGame setCursor: gWaitCursor)
		)
		(FrameOut)
		(super dispose: &rest)
	)

	(method (doVerb)
		(return 1)
	)
)

(instance bookEvent of Event ; UNUSED
	(properties)
)

(instance pagePrint of Print
	(properties)

	(method (handleEvent &tmp temp0))
)

(instance pageDialog of Dialog
	(properties)

	(method (init)
		(super init: &rest)
		(FrameOut)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= temp1 0)
		(= temp0 (Event new:))
		(temp0
			x: ((User curEvent:) x:)
			y: ((User curEvent:) y:)
			type: ((User curEvent:) type:)
		)
		(temp0 localize: plane)
		(if mouseHiliting
			(self eachElementDo: #perform checkHiliteCode self temp0)
		)
		(if (temp0 type:)
			(= temp1 (self firstTrue: #handleEvent temp0))
		)
		(temp0 dispose:)
		(FrameOut)
	)

	(method (handleEvent))
)

(instance checkHiliteCode of Code
	(properties)

	(method (doit param1 param2 param3)
		(if
			(and
				(& (param1 state:) $0001)
				(param1 onMe: param3)
				(not (& (param1 state:) $0008))
			)
			((param2 theItem:) hilite: 0)
			(param2 theItem: param1)
			(param1 hilite: 1)
		)
	)
)

(class Book of Feature
	(properties
		modNum 815
		nsLeft 30
		nsTop 34
		nsRight 160
		nsBottom 130
		y 1
		pageNum 0
		pages 0
		phFirst 0
		phLast 0
	)

	(method (init &tmp [temp0 2])
		(super init: &rest)
		(self writePhrases:)
	)

	(method (dispose)
		(if (pagePrint dialog:)
			(gMouseDownHandler delete: (pagePrint dialog:))
			((pagePrint dialog:) dispose:)
		)
		(FrameOut)
		(super dispose: &rest)
	)

	(method (doVerb)
		(return 1)
	)

	(method (turnPage param1 &tmp temp0)
		(= temp0 0)
		(cond
			((== param1 0)
				(if (< (+ pageNum 1) pages)
					(++ pageNum)
					(= temp0 1)
				)
			)
			((> pageNum 0)
				(-- pageNum)
				(= temp0 1)
			)
		)
		(if temp0
			(if (pagePrint dialog:)
				(gMouseDownHandler delete: (pagePrint dialog:))
				((pagePrint dialog:) dispose:)
			)
			(FrameOut)
			(self writePhrases:)
		)
		(return pageNum)
	)

	(method (writePhrases &tmp temp0 temp1)
		(pagePrint
			dialog: pageDialog
			modeless: 2
			classButton: BookButton
			plane: Plane
			font: 9561
		)
		(= temp0 phFirst)
		(for ((= temp1 0)) (<= temp0 phLast) ((++ temp1))
			((pagePrint
					addButton:
						temp1
						((self getPhraseAt: temp0) data:)
						1
						(* temp1 10)
				)
				fore: global240
				highlightColor: global225
				lowlightColor: global240
			)
			(++ temp0)
		)
		(pagePrint posn: 30 34 back: 1 skip: 1 fore: global240)
		((pagePrint plane:) picture: -2)
		((pagePrint dialog:) theItem: (NodeValue ((pagePrint dialog:) first:)))
		(pagePrint init:)
		((pagePrint dialog:) mouseHiliting: 1)
		(gMouseDownHandler addToFront: (pagePrint dialog:))
	)

	(method (getPhraseAt))

	(method (selectPhrase param1 &tmp temp0)
		(= temp0 (self getPhraseAt: (+ param1 phFirst)))
		(if
			(and
				(<= param1 (- phLast phFirst))
				(not (PhraseDisplay addPhrase: (temp0 data:) param1))
			)
			(gMessager say: 1 0 4 0 0 815) ; "That seems like too many phrases somehow."
		)
	)
)

(instance radaBook of Book
	(properties
		pages 3
	)

	(method (writePhrases)
		(switch pageNum
			(0
				(= phFirst 0)
				(= phLast 8)
			)
			(1
				(= phFirst 9)
				(= phLast 18)
			)
			(2
				(= phFirst 19)
				(= phLast 27)
			)
		)
		(super writePhrases:)
	)

	(method (getPhraseAt param1)
		(return
			(if (<= param1 phLast)
				(local5 at: param1)
			else
				0
			)
		)
	)
)

(instance tribeBook of Book
	(properties
		pages 1
	)

	(method (writePhrases &tmp [temp0 2])
		(= phFirst 0)
		(= phLast 6)
		(super writePhrases:)
	)

	(method (getPhraseAt param1)
		(return
			(if (<= param1 phLast)
				(local6 at: param1)
			else
				0
			)
		)
	)
)

(instance turnLeft of Feature
	(properties
		nsLeft 1
		nsTop 34
		nsRight 30
		nsBottom 130
		y 40
	)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (self onMe: gMouseX gMouseY))
		(= temp1 (> (local8 pageNum:) 0))
		(cond
			((and x (or (not temp0) (not temp1)))
				(= x 0)
				(ClearFlag 220)
				(gGame setCursor: (ScriptID 0 1)) ; globeCursor
				(SetFlag 220)
			)
			((and temp0 temp1 (not x))
				(= x 1)
				(ClearFlag 220)
				(gGame setCursor: leftCursor)
				(SetFlag 220)
			)
		)
	)

	(method (doVerb)
		(local8 turnPage: 1)
		(return 1)
	)
)

(instance turnRight of Feature
	(properties
		nsLeft 160
		nsTop 42
		nsRight 178
		nsBottom 130
		y 100
	)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (self onMe: gMouseX gMouseY))
		(= temp1 (> (local8 pages:) (+ (local8 pageNum:) 1)))
		(cond
			((and x (or (not temp0) (not temp1)))
				(= x 0)
				(ClearFlag 220)
				(gGame setCursor: (ScriptID 0 1)) ; globeCursor
				(SetFlag 220)
			)
			((and temp0 temp1 (not x))
				(= x 1)
				(ClearFlag 220)
				(gGame setCursor: rightCursor)
				(SetFlag 220)
			)
		)
	)

	(method (doVerb)
		(local8 turnPage: 0)
		(return 1)
	)
)

(class BookButton of DButton
	(properties
		back 1
		skip 1
		font 9561
		gap 5
		minWidth 100
		highlightColor 15
		lowlightColor 0
	)

	(method (init)
		(= borderColor -1)
		(= back (= skip -1))
		(= highlightColor global222)
		(= lowlightColor global228)
		(super init: &rest)
		(|= signal $0002)
	)

	(method (setSize param1 &tmp temp0 temp1)
		(= temp1 (if argc param1 else 190))
		(= textLeft (= nsLeft (= nsTop 0)))
		(= textTop gap)
		(= temp0 (IntArray with: 0 0 0 0))
		(TextSize (temp0 data:) text font temp1)
		(= textRight (temp0 at: 2))
		(= textBottom (+ gap (temp0 at: 3)))
		(temp0 dispose:)
		(= nsRight (if (< textRight minWidth) minWidth else textRight))
		(= nsBottom textBottom)
	)

	(method (hilite param1 &tmp temp0)
		(= fore (if (and argc param1) highlightColor else lowlightColor))
		(if bitmap
			(DisposeTextBitmap bitmap)
		)
		(self draw:)
		(UpdateScreenItem self)
	)

	(method (handleEvent event &tmp [temp0 2])
		(if (and (== (event type:) evMOUSEBUTTON) (self onMe: event))
			(event claimed: 1)
			(local8 selectPhrase: value)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance pdPrint1 of Print
	(properties)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(instance pdPrint2 of Print
	(properties)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(instance pdPrint3 of Print
	(properties)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(instance pdPrint4 of Print
	(properties)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(class PhraseDisplay of Code
	(properties
		nextY 36
		leftX 184
		count 0
		phaserArray 0
	)

	(method (addPhrase param1 param2 &tmp temp0)
		(= leftX (proc13_6 182 184 184 184 184))
		(if (< count 4)
			(if (not phaserArray)
				(= phaserArray
					(IDArray newWith: 4 pdPrint1 pdPrint2 pdPrint3 pdPrint4)
				)
			)
			((= temp0 (phaserArray at: count))
				fore: global233
				font: 9561
				skip: 1
				back: 0
				modeless: 2
				posn: leftX nextY
				width: 135
				addText: param1
				init:
			)
			((temp0 plane:) picture: -2)
			(+= nextY 12)
			(local10
				at:
					count
					(+
						param2
						(local8 phFirst:)
						(if (== local8 tribeBook) 28 else 0)
					)
			)
			(++ count)
			(if (Drummer jammin:)
				(self checkPhrases:)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (deletePhrase &tmp temp0)
		(if count
			(-= nextY 12)
			(-- count)
			(local10 at: count 0)
			(((phaserArray at: count) dialog:) dispose:)
			(FrameOut)
			(if (Drummer jammin:)
				(self checkPhrases:)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (checkPhrases &tmp temp0)
		(switch local0
			(2
				(if
					(and
						(== count 3)
						(OneOf
							6
							(local10 at: 0)
							(local10 at: 1)
							(local10 at: 2)
						)
						(OneOf
							10
							(local10 at: 0)
							(local10 at: 1)
							(local10 at: 2)
						)
						(OneOf
							26
							(local10 at: 0)
							(local10 at: 1)
							(local10 at: 2)
						)
						(not (IsFlag 268))
					)
					(gEgo getPoints: 388 5)
					(gMessager say: 1 0 1 0 0 815) ; "(PONDERING)Hmmm. If Gabriel's translation of the drum code is correct...."
					(SetFlag 268)
				)
			)
			(4
				(for ((= temp0 0)) (< temp0 count) ((++ temp0))
					((Drummer drumPlay:) at: temp0 (local10 at: temp0))
					(if (== (local10 at: temp0) 29)
						(SetFlag 346)
					)
				)
				((Drummer drumPlay:) at: count -1)
				(cond
					((== count 0)
						(SetFlag 469)
					)
					((IsFlag 346) 0)
					((IsFlag 348)
						(SetFlag 349)
					)
					((IsFlag 347)
						(SetFlag 348)
					)
					(else
						(SetFlag 347)
					)
				)
			)
		)
	)
)

(instance myBar of GKIconbar
	(properties)

	(method (init)
		(= plane barPlane)
		(plane back: 0 priority: -1 init: 0 0 210 100 addCast: self)
		(self eachElementDo: #init self)
		(plane setSize:)
		(= local9 (Cast new:))
		(plane addCast: local9)
		(cLion1 init: local9)
		(cBar1 init: local9)
		(cBorder init: local9)
		(cBar2 init: local9)
		(cBar3 init: local9)
		(cBar4 init: local9)
		(cBar5 init: local9)
		(cBar6 init: local9)
		(cLion2 init: local9)
		(cLion1Eyes init: local9)
		(cLion2Eyes init: local9)
		(cInvIcon init: local9)
		(dScore init: local9)
		(dOne init: local9)
		(dTwo init: local9)
		(dThree init: local9)
		(dFour init: local9)
		(dFive init: local9 hide:)
		(dSix init: local9 hide:)
		(plane setSize:)
		(self curIcon: eraseIcon curInvIcon: 0 state: 3072)
	)

	(method (noClickHelp &tmp temp0 temp1 temp2 temp3)
		(= temp1 (= temp2 (= temp3 0)))
		(ClearFlag 220)
		(gGame setCursor: (helpIconItem getCursor:))
		(SetFlag 220)
		(while (not ((= temp0 ((gUser curEvent:) new:)) type:))
			(temp0 localize: plane)
			(cond
				((= temp2 (self firstTrue: #onMe temp0))
					(if (and (!= temp2 temp1) (temp2 helpVerb:))
						(= temp1 temp2)
						(if temp3
							(temp3 dispose:)
							(= temp3 0)
							(FrameOut)
						)
						(Print
							font: gUserFont
							width: 250
							addText:
								(temp2 noun:)
								(temp2 helpVerb:)
								0
								1
								0
								0
								(if (== (temp2 modNum:) -1)
									0
								else
									(temp2 modNum:)
								)
							modeless: 2
							init:
						)
						(= temp3 (Print dialog:))
						(FrameOut)
					)
				)
				(temp3
					(temp3 dispose:)
					(= temp3 0)
					(FrameOut)
				)
				(else
					(= temp1 0)
				)
			)
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(ClearFlag 220)
		(gGame setCursor: (ScriptID 0 1)) ; globeCursor
		(SetFlag 220)
		(if temp3
			(temp3 dispose:)
			(FrameOut)
		)
	)

	(method (show)
		(super show: &rest)
	)

	(method (drawScore)
		(cond
			((< gScore 10)
				(dFour setLoop: 4 cel: gScore posn: 233 3)
				(UpdateScreenItem dFour)
			)
			((< gScore 100)
				(dFour setLoop: 4 cel: (/ gScore 10) posn: 231 3)
				(UpdateScreenItem dFour)
				(dFive setLoop: 4 cel: (mod gScore 10) posn: 237 3 show:)
				(UpdateScreenItem dFive)
			)
			(else
				(dFour setLoop: 4 cel: (/ gScore 100) posn: 227 3)
				(UpdateScreenItem dFour)
				(dFive
					setLoop: 4
					cel: (/ (mod gScore 100) 10)
					posn: 233 3
					show:
				)
				(UpdateScreenItem dFive)
				(dSix setLoop: 4 cel: (mod gScore 10) posn: 239 3 show:)
				(UpdateScreenItem dSix)
			)
		)
	)

	(method (showInvItem))

	(method (hide &tmp temp0)
		(= temp0 (gGame keepBar:))
		(gGame keepBar: 0)
		(super hide: &rest)
		(gGame keepBar: temp0)
	)

	(method (handleEvent)
		(if (not local11)
			(super handleEvent: &rest)
		)
	)
)

(instance eraseIcon of GKIconItem
	(properties
		noun 42
		x 46
		y 2
		signal 67
		message 0
		mainView 9561
		maskView 9561
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 68
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (PhraseDisplay deletePhrase:)
				(return 1)
			else
				(gMessager say: 1 0 2 1 0 815) ; "There are no phrases to erase."
				(return 0)
			)
		else
			(return 0)
		)
	)

	(method (init)
		(= topIcon (= bottomIcon (= leftIcon (= rightIcon self))))
		(if (== gCurRoom 800)
			(= noun 41)
		)
		(super init: &rest)
	)
)

(instance nextBookIcon of GKIconItem
	(properties
		noun 40
		x 92
		y 2
		signal 67
		message 0
		mainView 9561
		mainLoop 1
		maskView 9561
		maskLoop 1
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 68
	)

	(method (init)
		(= topIcon (= bottomIcon (= leftIcon (= rightIcon self))))
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(local8 dispose:)
			(= local8 (if (== local8 radaBook) tribeBook else radaBook))
			(local8 init:)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance exitIcon of GKIconItem
	(properties
		noun 38
		x 144
		signal 67
		message 0
		mainView 9561
		mainLoop 2
		maskView 9561
		maskLoop 2
		cursorView 999
		cursorLoop 0
		cursorCel 0
		helpVerb 68
	)

	(method (init)
		(= topIcon (= bottomIcon (= leftIcon (= rightIcon self))))
		(super init: &rest)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(drumInset dispose:)
			(User canInput: 0)
			(= local11 1)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance barPlane of Plane
	(properties)
)

(instance leftCursor of Cursor
	(properties
		view 9561
		loop 3
		cel 1
	)
)

(instance rightCursor of Cursor
	(properties
		view 9561
		loop 3
	)
)

(instance dScore of HRView
	(properties
		x 224
		view 959
		loop 3
	)
)

(instance dOne of HRView
	(properties
		x 227
		y 20
		view 959
		loop 4
		cel 3
	)
)

(instance dTwo of HRView
	(properties
		x 233
		y 20
		view 959
		loop 4
		cel 4
	)
)

(instance dThree of HRView
	(properties
		x 239
		y 20
		view 959
		loop 4
		cel 2
	)
)

(instance dFour of HRView
	(properties
		x 233
		y 3
		view 959
		loop 4
	)
)

(instance dFive of HRView
	(properties
		view 959
		loop 4
	)
)

(instance dSix of HRView
	(properties
		view 959
		loop 4
	)
)

(instance cLion1 of HRView
	(properties
		view 959
		loop 1
		cel 2
	)
)

(instance cBar1 of HRView
	(properties
		x 37
		view 959
		loop 1
	)
)

(instance cBorder of HRView
	(properties
		x 43
		view 959
		loop 5
	)
)

(instance cBar2 of HRView
	(properties
		x 138
		view 959
		loop 1
	)
)

(instance cBar3 of HRView
	(properties
		x 167
		view 959
		loop 1
	)
)

(instance cBar4 of HRView
	(properties
		x 218
		view 959
		loop 1
	)
)

(instance cBar5 of HRView
	(properties
		x 248
		view 959
		loop 1
	)
)

(instance cBar6 of HRView
	(properties
		x 277
		view 959
		loop 1
	)
)

(instance cLion2 of HRView
	(properties
		x 283
		view 959
		loop 1
		cel 1
	)
)

(instance cLion1Eyes of HRView
	(properties
		x 8
		y 8
		view 959
		loop 8
	)
)

(instance cLion2Eyes of HRView
	(properties
		x 292
		y 8
		view 959
		loop 7
	)
)

(instance cInvIcon of HRView
	(properties
		x 173
		view 959
		loop 2
		cel 2
	)
)

(instance iconCon of GKIconItem
	(properties
		noun 14
		x 254
		y 16
		signal 71
		message 0
		mainView 960
		mainLoop 11
		mainCel 1
		maskView 960
		maskLoop 11
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(= topIcon (= bottomIcon (= leftIcon (= rightIcon self))))
		(super init: &rest)
	)
)

(instance drumIconHelp of GKIconItem
	(properties
		noun 1
		x 254
		signal 3
		type 8192
		message 68
		mainView 960
		mainLoop 10
		maskView 960
		maskLoop 10
		maskCel 2
		helpVerb 68
	)

	(method (init)
		(self setCursor: drumHelpCursor)
		(= topIcon (= bottomIcon (= leftIcon (= rightIcon self))))
		(super init: &rest)
	)
)

(instance drumHelpCursor of Cursor
	(properties
		view 958
		loop 8
	)
)

